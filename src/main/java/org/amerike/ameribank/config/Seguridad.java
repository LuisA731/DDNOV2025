package org.amerike.ameribank.config;

import java.security.*;
import java.security.spec.*;
import javax.crypto.Cipher;
import java.nio.file.*;
import java.util.Base64;

public class Seguridad {
    public static String[] obtenerCredenciales() throws Exception {
        byte[] claveBytes = Files.readAllBytes(Paths.get("private_key.pem"));
        PrivateKey clavePrivada = cargarClavePrivada(claveBytes);

        byte[] cifrado = Files.readAllBytes(Paths.get("accesodbjava.enc"));
        Cipher descifrador = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        descifrador.init(Cipher.DECRYPT_MODE, clavePrivada);
        byte[] descifrado = descifrador.doFinal(cifrado);

        return new String(descifrado).split("\\|");
    }

    private static PrivateKey cargarClavePrivada(byte[] pem) throws Exception {
        String contenido = new String(pem).replaceAll("-----.*-----", "").replaceAll("\\s", "");
        byte[] decoded = Base64.getDecoder().decode(contenido);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
        return KeyFactory.getInstance("RSA").generatePrivate(spec);
    }
}