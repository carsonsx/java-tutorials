package com.carsonsx.springchat;

/**
 * Created by carsonsx on 18/03/2017.
 */
public class ObjectUtil {

    public static String toString(Object obj) {
        return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
    }

}
