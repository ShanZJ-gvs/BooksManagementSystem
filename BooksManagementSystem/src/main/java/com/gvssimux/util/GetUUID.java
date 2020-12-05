package com.gvssimux.util;

import java.security.SecureRandom;
import java.util.UUID;

public final class GetUUID {


    public static String get(){

        String UUID;
        UUID = java.util.UUID.randomUUID().toString().replace("-", "" );

        return UUID;
    }




}
