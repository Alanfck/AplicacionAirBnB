/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uamc.mx.airbnb.backend.sesion;

import com.uamc.mx.airbnb.backend.usuario.Anfitrion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author jguillermofc
 */
public class Sesion {

    public static boolean escribirRegistro(String user, String password, int id, String tipo) throws IOException {
        FileWriter archivo = null;
        PrintWriter pw = null;
        File formato;
        formato = new File("sesion.txt");
        if (!formato.exists()) {
            try {
                formato.createNewFile();
                archivo = new FileWriter(formato, true);
                pw = new PrintWriter(archivo);
                pw.println(user + "," + password + "," + id + "," + tipo);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (archivo != null) {
                        archivo.close();
                        return true;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            try {
                archivo = new FileWriter(formato, true);
                pw = new PrintWriter(archivo);
                pw.println(user + "," + password + "," + id + "," + tipo);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (archivo != null) {
                        archivo.close();
                        return true;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        return false;
    }

    public static boolean iniciarSesion(String user, String password) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        boolean flag = false;
        try {
            archivo = new File("sesion.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String keyValue[];

            while ((linea = br.readLine()) != null) {
                keyValue = linea.split(",");
                System.out.println(keyValue[0] + "  " + keyValue[1]);
                if (keyValue[0].equals(user) && keyValue[1].equals(password)) {
                    flag = true;
                    break;
                }
            }
        } catch (IOException | NumberFormatException e) {
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return flag;
                }
            } catch (IOException e2) {
            }
        }
        return false;
    }
}
