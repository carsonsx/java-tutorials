package com.carsonsx.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * Created by carsonsx on 2017/3/27.
 */
public interface IHello extends Remote {

    String say() throws RemoteException;

}
