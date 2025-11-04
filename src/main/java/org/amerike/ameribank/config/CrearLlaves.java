package org.amerike.ameribank.config;

import java.security.*;
import java.util.Base64;
import java.io.*;

public class CrearLlaves {
    public static void generadorClaves() throws Exception {
        KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
        generador.initialize(2048);
        KeyPair parClaves = generador.generateKeyPair();

        // Guardar llave Privada
        guardarClavePEM("./private_key.pem", parClaves.getPrivate(), "PRIVATE KEY");

        // Guardar llave Pública
        guardarClavePEM("./public_key.pem", parClaves.getPublic(), "PUBLIC KEY");
    }

    private static void guardarClavePEM(String archivo, Key clave, String tipo) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("-----BEGIN " + tipo + "-----\n");
        sb.append(Base64.getMimeEncoder(64, "\n".getBytes()).encodeToString(clave.getEncoded()));
        sb.append("\n-----END " + tipo + "-----\n");

        try (FileWriter fw = new FileWriter(archivo)) {
            fw.write(sb.toString());
        }
    }
}
