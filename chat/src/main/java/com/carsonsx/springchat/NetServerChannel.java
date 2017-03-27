package com.carsonsx.springchat;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * Created by carsonsx on 18/03/2017.
 */
public class NetServerChannel {


    private static void printObject(Object o) {
        System.out.println(o.getClass().getName() + "@" + Integer.toHexString(o.hashCode()));
    }

    public static void startServer() throws Exception {

        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        printObject(ssc);

        ssc.configureBlocking(false);
        ssc.socket().bind(new InetSocketAddress(8888));
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {

            int count = selector.selectNow();

            if (count > 0) {

                System.out.println("count: " + count);
                System.out.println("selected: " + selector.selectedKeys().size());


                //System.out.println(new Date());
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
//                if (iter.hasNext()) {
//                    iter.next();
//                }
                    if (key.isAcceptable()) {
                        SocketChannel sc = ssc.accept();
                        printObject(sc);
                        System.out.println("connected: " + sc);
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                        iter.remove();
                    } else if (key.isReadable()) {
                        SocketChannel sc = (SocketChannel) key.channel();
                        //printObject(sc);
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
//                    while (true) {
                        buffer.clear();
                        int n = sc.read(buffer);
                        if (n <= 0) {
                            sc.close();
                            key.cancel();
                            System.out.println("disconnected: " + sc);
                            continue;
                        }
                        buffer.flip();
                        byte[] bytes = new byte[buffer.remaining()];
                        buffer.get(bytes, 0, bytes.length);
                        System.out.println("received: " + new String(bytes));
                        //sc.write(ByteBuffer.wrap("Recieved".getBytes()));
//                    }
                        iter.remove();
                        System.out.println(selector.selectedKeys().toArray().length);
                    }
                }
            } else {
                System.out.println("抽根烟......");
                Thread.sleep(5000);
                System.out.println("keys: " + selector.keys().size());
                System.out.println("抽完了......");
            }
        }
    }

}
