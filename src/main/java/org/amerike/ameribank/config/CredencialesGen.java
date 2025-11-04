package org.amerike.ameribank.config;

import java.util.Scanner;

public class CredencialesGen {

    public static void credencialesGen() {
        try {
            CrearLlaves.generadorClaves();
            System.out.println("Cifrando credenciales.");
            Scanner sc = new Scanner(System.in);
            System.out.print("Nombre de la Base de Datos: ");
            String NombreBaseDeDatos = sc.nextLine();
            System.out.print("Nombre de usuario: ");
            String User = sc.nextLine();
            System.out.print("Password: ");
            String Password = sc.nextLine();
            CifradorRSA.cifrador(NombreBaseDeDatos, User, Password);
            System.out.println("Cifrado finalizado");

        } catch (Exception e) {
            System.err.println("Error al generar las claves");
            e.printStackTrace();
        }
    }
}
