/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportal.model;

import java.util.ArrayList;

/**
 *
 * @author c19255
 */
public class UsuarioBD {
    
    static ArrayList<Usuario> usuarios;

    public UsuarioBD() {
    usuarios = new ArrayList<>();
    }
    public ArrayList<Usuario> getUsuarios(){
    Usuario usuario = new Usuario();
    usuario.setCorreo("jperez@gmail.com");
    usuario.setClave("123456");
    usuarios.add(usuario);
    Usuario usuario1 = new Usuario();
    usuario1.setCorreo("gareca@gmail.com");
    usuario1.setClave("123456");
    usuarios.add(usuario1);    
    return usuarios;
    }
    
    
}
