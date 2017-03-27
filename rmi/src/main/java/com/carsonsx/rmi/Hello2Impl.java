package com.carsonsx.rmi;

import sun.rmi.server.UnicastServerRef;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * Created by carsonsx on 2017/3/27.
 */
public class Hello2Impl extends UnicastRemoteObject implements IHello {

    protected Hello2Impl() throws RemoteException {
    }

    @Override
    public String say() throws RemoteException {
        return null;
    }
}
