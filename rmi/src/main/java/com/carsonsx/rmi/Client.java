package com.carsonsx.rmi;

import java.rmi.Naming;

/**
 *
 * Created by carsonsx on 2017/3/27.
 */
public class Client {


    public static void main(String[] args) throws Exception {

        IHello hello = (IHello) Naming.lookup("hello");
        System.out.println(hello.say());
    }



}
