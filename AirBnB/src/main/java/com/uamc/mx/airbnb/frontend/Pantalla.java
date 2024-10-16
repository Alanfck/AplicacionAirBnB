/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uamc.mx.airbnb.frontend;

import com.uamc.mx.airbnb.backend.sesion.Sesion;
import com.uamc.mx.airbnb.backend.usuario.Anfitrion;
import com.uamc.mx.airbnb.backend.usuario.Huesped;
import java.util.Scanner;

/**
 *
 * @author jguillermofc
 */
public class Pantalla {

    private Scanner scan;

    public Pantalla() {
        scan = new Scanner(System.in);
    }

    public void showBienvenida() {
        int op;
        System.out.println("Bienvenido a UAM-BnB");
        System.out.println("1. Registrar huesped");
        System.out.println("2. Registrar anfitrion");
        System.out.println("3. Iniciar sesión");
        System.out.println("4. Salir");
        System.out.println("Ingrese la opcion deseada:");
        op = scan.nextInt();
        switch (op) {
            case 1 -> {
                if (showRegistrarHuesped()) {
                    System.out.println("¡El registro de huesped ha sido existoso!");
                } else {
                    System.err.println("El registro de huesped no fue exitoso.");
                }
                showBienvenida();
            }
            case 2 -> {
                if (showRegistrarAnfitrion()) {
                    System.out.println("¡El registro del anfitrion ha sido existoso!");
                } else {
                    System.err.println("El registro del anfitrion no fue exitoso.");
                }
                showBienvenida();
            }
            case 3 -> {
                boolean result = showIniciarSesion();
                do {
                    if (result) {
                        System.out.println("Inicio de sesion exitoso. Bienvenido.");
                        op = 2;
                    } else {
                        System.out.println("Usuario y/o constraseña equivocados");
                        System.out.println("Ingrese la opcion deseada: (1) Reintentar, (2) Salir al menu.");
                        op = scan.nextInt();
                    }
                } while (op != 2);

                if (result) {
                    showMenuAirBNB();
                } else {
                    showBienvenida();
                }
            }
            default -> {
            }
        }

    }

    private boolean showRegistrarHuesped() {
        Huesped h = new Huesped();
        int id, edad, diaNac, mesNac, yearNac, lealtad;
        String nombre, apellidoPaterno, apellidoMaterno, RFC, direccion, user, password, reputacion;
        char sexo;

        System.out.println("****************************************************");
        System.out.println("Registrar huesped");
        System.out.println("Ingrese el ID:");
        id = scan.nextInt();
        h.setId(id);
        scan.nextLine();
        System.out.println("Ingrese el nombre:");
        nombre = scan.nextLine();
        h.setNombre(nombre);
        System.out.println("Ingrese el apellido paterno");
        apellidoPaterno = scan.nextLine();
        h.setApellidoPaterno(apellidoPaterno);
        System.out.println("Ingrese el apellido materno");
        apellidoMaterno = scan.nextLine();
        System.out.println("Ingrese su sexo (M, F):");
        sexo = scan.next().charAt(0);
        h.setSexo(sexo);
        h.setApellidoMaterno(apellidoMaterno);
        System.out.println("Ingrese edad:");
        edad = scan.nextInt();
        h.setEdad(edad);
        scan.nextLine();
        System.out.println("Ingrese el dia de nacimiento:");
        diaNac = scan.nextInt();
        h.setDiaNac(diaNac);
        scan.nextLine();
        System.out.println("Ingrese el mes de nacimiento (numerico):");
        mesNac = scan.nextInt();
        h.setMesNac(mesNac);
        scan.nextLine();
        System.out.println("Ingrese el año de nacimiento (AAAA):");
        yearNac = scan.nextInt();
        h.setYearNac(yearNac);
        scan.nextLine();
        h.construirRFC();
        System.out.println("Ingrese la direccion:");
        direccion = scan.nextLine();
        h.setDireccion(direccion);
        System.out.println("Ingrese el nombre de usuario:");
        user = scan.next();
        h.setUser(user);
        System.out.println("Ingrese la password:");
        password = scan.next();
        h.setPassword(password);
        h.setReputacion("nuevo");
        h.setLealtad(0);

        return h.guardar();
    }

    private boolean showRegistrarAnfitrion() {
        Anfitrion h = new Anfitrion();
        int id, edad, diaNac, mesNac, yearNac;
        String nombre, apellidoPaterno, apellidoMaterno, RFC, direccion, user, password, tipoAnfitrion;
        char sexo;

        System.out.println("****************************************************");
        System.out.println("Registrar anfitrion");
        System.out.println("Ingrese el ID:");
        id = scan.nextInt();
        h.setId(id);
        scan.nextLine();
        System.out.println("Ingrese el nombre:");
        nombre = scan.nextLine();
        h.setNombre(nombre);
        System.out.println("Ingrese el apellido paterno");
        apellidoPaterno = scan.nextLine();
        h.setApellidoPaterno(apellidoPaterno);
        System.out.println("Ingrese el apellido materno");
        apellidoMaterno = scan.nextLine();
        System.out.println("Ingrese su sexo (M, F):");
        sexo = scan.next().charAt(0);
        h.setSexo(sexo);
        h.setApellidoMaterno(apellidoMaterno);
        System.out.println("Ingrese edad:");
        edad = scan.nextInt();
        h.setEdad(edad);
        scan.nextLine();
        System.out.println("Ingrese el dia de nacimiento:");
        diaNac = scan.nextInt();
        h.setDiaNac(diaNac);
        scan.nextLine();
        System.out.println("Ingrese el mes de nacimiento (numerico):");
        mesNac = scan.nextInt();
        h.setMesNac(mesNac);
        scan.nextLine();
        System.out.println("Ingrese el año de nacimiento (AAAA):");
        yearNac = scan.nextInt();
        h.setYearNac(yearNac);
        scan.nextLine();
        h.construirRFC();
        System.out.println("Ingrese la direccion:");
        direccion = scan.nextLine();
        h.setDireccion(direccion);
        System.out.println("Ingrese el nombre de usuario:");
        user = scan.next();
        h.setUser(user);
        System.out.println("Ingrese la password:");
        password = scan.next();
        h.setPassword(password);
        h.setTipoAnfitrion("novato");

        return h.guardar();
    }

    private boolean showIniciarSesion() {
        String user, password;
        System.out.println("****************************************************");
        System.out.println("Iniciar sesion");
        System.out.println("Ingrese el nombre de usuario:");
        user = scan.next();
        System.out.println("Ingrese el password:");
        password = scan.next();
        return Sesion.iniciarSesion(user, password);
    }

    private void showMenuAirBNB() {
        System.out.println("jajajajajajaja");
    }
}
