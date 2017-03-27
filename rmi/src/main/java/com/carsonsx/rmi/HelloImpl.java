package com.carsonsx.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * Created by carsonsx on 2017/3/27.
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {

    protected HelloImpl() throws RemoteException {
    }

    @Override
    public String say() throws RemoteException {
        System.out.println("Hello, World!");
        return "Hello, World!";
    }
}
