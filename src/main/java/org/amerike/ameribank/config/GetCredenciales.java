package org.amerike.ameribank.config;
import java.util.concurrent.ExecutionException;

public class GetCredenciales {
    // se encarga de obtener la url, user y password dependiendo del metodo
    public static String obtenerUrl()  {
        try {
            String[] datos = Seguridad.obtenerCredenciales();
            String url = datos[0].replace("\"", "");
            return url;
        } catch (Exception e ) {
            System.err.println("Error al obtener las credenciales");
            return null;
        }
    }
    public static String obtenerUsuario()  {
        try {
            String[] datos = Seguridad.obtenerCredenciales();
            String user = datos[1].replace("\"", "");
            return user;
        } catch (Exception e ) {
            System.err.println("Error al obtener las credenciales");
            return null;
        }
    }
    public static String obtenerPassword()  {
        try {
            String[] datos = Seguridad.obtenerCredenciales();
            String Password = datos[2].replace("\"", "");
            return Password;
        } catch (Exception e ) {
            System.err.println("Error al obtener las credenciales");
            return null;
        }
    }
}