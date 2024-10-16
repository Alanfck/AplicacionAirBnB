/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uamc.mx.airbnb.backend.usuario;

/**
 *
 * @author jguillermofc
 */
public abstract class Usuario {

    protected int id;
    protected String nombre;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected int edad;
    protected int diaNac;
    protected int mesNac;
    protected int yearNac;

    protected String RFC;
    protected char sexo;
    protected String direccion;

    protected String user;
    protected String password;
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public int getDiaNac() {
        return diaNac;
    }

    public void setDiaNac(int diaNac) {
        this.diaNac = diaNac;
    }

    public int getMesNac() {
        return mesNac;
    }

    public void setMesNac(int mesNac) {
        this.mesNac = mesNac;
    }

    public int getYearNac() {
        return yearNac;
    }

    public void setYearNac(int yearNac) {
        this.yearNac = yearNac;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void construirRFC() {
        String yearStr = Integer.toString(yearNac);
        String diaStr, mesStr;

        if (diaNac < 10) {
            diaStr = "0" + diaNac;
        } else {
            diaStr = Integer.toString(diaNac);
        }

        if (mesNac < 10) {
            mesStr = "0" + mesNac;
        } else {
            mesStr = Integer.toString(mesNac);
        }
        this.RFC = this.apellidoPaterno.charAt(0) + "" + this.apellidoPaterno.charAt(1) + "" + this.apellidoMaterno.charAt(0) + "" + this.nombre.charAt(0) + "" + yearStr.substring(2) + mesStr + diaStr;
    }

    public abstract boolean guardar();

    public abstract Usuario consultar(int id);

    public abstract boolean eliminar(int id);

    public abstract void modificar();
}
