package org.amerike.ameribank.config;

import java.security.*;
import java.security.spec.*;
import javax.crypto.Cipher;
import java.nio.file.*;
import java.util.Base64;

public class CifradorRSA {
    private  String NombreBaseDeDatos;
    private  String User;
    private  String Password;
    public static void cifrador(String NombreBaseDeDatos, String User, String Password) throws Exception {

        byte[] claveBytes = Files.readAllBytes(Paths.get("public_key.pem"));
        PublicKey clavePublica = cargarClavePublica(claveBytes);


        String datos = String.format("\"jdbc:mariadb://localhost:3306/%s\"|\"%s\"|\"%s\"", NombreBaseDeDatos, User, Password);
        Cipher cifrador = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
        byte[] cifrado = cifrador.doFinal(datos.getBytes());

        Files.write(Paths.get("accesodbjava.enc"), cifrado);
    }

    private static PublicKey cargarClavePublica(byte[] pem) throws Exception {
        String contenido = new String(pem).replaceAll("-----.*-----", "").replaceAll("\\s", "");
        byte[] decoded = Base64.getDecoder().decode(contenido);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
        return KeyFactory.getInstance("RSA").generatePublic(spec);
    }
}
