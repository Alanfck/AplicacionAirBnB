/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uamc.mx.airbnb.backend.usuario;

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
public class HuespedDB {

    public static boolean crear(Huesped h) {
        FileWriter archivo = null;
        PrintWriter pw = null;

        try {
            archivo = new FileWriter("huesped_" + h.getId() + ".txt");
            pw = new PrintWriter(archivo);

            pw.println("id=" + h.getId());
            pw.println("Nombre=" + h.getNombre());
            pw.println("ApellidoPaterno=" + h.getApellidoPaterno());
            pw.println("ApellidoMaterno=" + h.getApellidoMaterno());
            pw.println("Edad=" + h.getEdad());
            pw.println("DiaNac=" + h.getDiaNac());
            pw.println("MesNac=" + h.getMesNac());
            pw.println("AñoNac=" + h.getYearNac());
            pw.println("RFC=" + h.getRFC());
            pw.println("Sexo=" + h.getSexo());
            pw.println("Direccion=" + h.getDireccion());
            pw.println("Usuario=" + h.getUser());
            pw.println("Password=" + h.getPassword());
            pw.println("Reputacion=" + h.getReputacion());
            pw.println("Lealtad=" + h.getLealtad());

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
        return false;
    }

    public static Huesped consultar(int id) {
        Huesped h = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("huesped_" + id + ".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String keyValue[];
            h = new Huesped();
            while ((linea = br.readLine()) != null) {
                keyValue = linea.split("=");
                switch (keyValue[0]) {
                    case "id" -> h.setId(Integer.parseInt(keyValue[1]));
                    case "Nombre" -> h.setNombre(keyValue[1]);
                    case "ApellidoPaterno" -> h.setApellidoPaterno(keyValue[1]);
                    case "ApellidoMaterno" -> h.setApellidoMaterno(keyValue[1]);
                    case "Edad" -> h.setEdad(Integer.parseInt(keyValue[1]));
                    case "DiaNac" -> h.setDiaNac(Integer.parseInt(keyValue[1]));
                    case "MesNac" -> h.setMesNac(Integer.parseInt(keyValue[1]));
                    case "AñoNac" -> h.setYearNac(Integer.parseInt(keyValue[1]));
                    case "RFC" -> h.setRFC(keyValue[1]);
                    case "Sexo" -> h.setSexo(keyValue[1].charAt(0));
                    case "Direccion" -> h.setDireccion(keyValue[1]);
                    case "Usuario" -> h.setUser(keyValue[1]);
                    case "Password" -> h.setPassword(keyValue[1]);
                    case "Reputacion" -> h.setReputacion(keyValue[1]);
                    case "Lealtad" -> h.setLealtad(Integer.parseInt(keyValue[1]));
                    default -> {
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                    return h;
                }
            } catch (IOException e2) {
            }
        }
        return null;

    }

}
