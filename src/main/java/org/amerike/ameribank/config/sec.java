package org.amerike.ameribank.config;

import java.io.File;

public class sec {
    private static String rutaPrivateKey = "./private_key.pem";
    private static String rutaPublicKey = "./public_key.pem";

    static boolean checkKeys() {
        File PrivateKey = new File(rutaPrivateKey);
        File PublicKey = new File(rutaPublicKey);

        if (PrivateKey.exists()) {



        }
    }




}
