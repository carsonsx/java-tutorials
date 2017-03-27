package com.carsonsx.springchat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * Created by carsonsx on 18/03/2017.
 */
public class AsynchronousNetServer {

    private static Log logger = LogFactory.getLog(AsynchronousNetServer.class);

    private static HashSet<AsynchronousSocketChannel> onlines = new HashSet<>();


    public static void startServer() throws Exception {
        AsynchronousServerSocketChannel listener = AsynchronousServerSocketChannel.open();
        listener.bind(new InetSocketAddress(8888));
        listener.accept(null, new AcceptHandler(listener));
    }

    public static class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Void> {

        private AsynchronousServerSocketChannel listener;

        public AcceptHandler(AsynchronousServerSocketChannel listener) {
            this.listener = listener;
        }

        @Override
        public void completed(AsynchronousSocketChannel ach, Void att) {

            onlines.add(ach);

            // accept next
            listener.accept(null, this);

            // business
            logger.info(ObjectUtil.toString(ach));
            try {
                logger.info("connected from " + ach.getRemoteAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            ach.read(buffer, null, new ReceiveHandler(ach, buffer));
        }

        @Override
        public void failed(Throwable exc, Void att) {

        }
    }

    public static class ReceiveHandler implements CompletionHandler<Integer, Void> {

        private AsynchronousSocketChannel ach;
        private ByteBuffer buffer;

        public ReceiveHandler(AsynchronousSocketChannel ach, ByteBuffer buffer) {
            this.ach = ach;
            this.buffer = buffer;
        }

        @Override
        public void completed(Integer readBytes, Void att) {

            if (readBytes <= 0) {
                try {
                    onlines.remove(ach);
                    ach.close();
                    logger.info("disconnected from " + ach.getRemoteAddress());
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            byte[] data = new byte[readBytes];
            buffer.flip();
            buffer.get(data, 0, data.length);
            buffer.clear();
            logger.info("received: " + new String(data));

            // Broadcast
            Iterator<AsynchronousSocketChannel> iter = onlines.iterator();
            while(iter.hasNext()) {
                AsynchronousSocketChannel _ach = iter.next();
                if (this.ach != _ach) {
                    _ach.write(ByteBuffer.wrap(data));
                }
            }

            // read next
            ach.read(buffer, att, this);
        }

        @Override
        public void failed(Throwable exc, Void att) {

        }
    }

}
