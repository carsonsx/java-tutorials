package com.carsonsx.springchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Created by carsonsx on 17/03/2017.
 */

@SpringBootApplication
public class SpringChatApplication {

    public static void main(String[] args) throws Exception {


        AsynchronousNetServer.startServer();

        //SpringApplication.run(SpringChatApplication.class, args);

        while(true) {

            Thread.sleep(100);

        }


    }

}
