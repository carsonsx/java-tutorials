package com.carsonsx.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * 
 * Created by carsonsx on 2017/3/27.
 */
public class Server {

    public static void main(String[] args) throws Exception {
        //LocateRegistry.createRegistry(1099);
        HelloImpl hello = new HelloImpl();
        System.out.println(hello);
        Hello2Impl hello2 = new Hello2Impl();
        System.out.println(hello2);
        Naming.rebind("rmi://localhost/hello", hello);
    }
}
