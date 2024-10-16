/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uamc.mx.airbnb.backend.usuario;

import com.uamc.mx.airbnb.backend.sesion.Sesion;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jguillermofc
 */
public class Anfitrion extends Usuario {

    private String tipoAnfitrion;

    public String getTipoAnfitrion() {
        return tipoAnfitrion;
    }

    public void setTipoAnfitrion(String tipoAnfitrion) {
        this.tipoAnfitrion = tipoAnfitrion;
    }

    @Override
    public Usuario consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardar() {
        try {
            return AnfitrionDB.crear(this) && Sesion.escribirRegistro(user, password, id, "anfitrion");
        } catch (IOException ex) {
            Logger.getLogger(Anfitrion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
