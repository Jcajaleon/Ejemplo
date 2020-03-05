/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportal.model;

import com.miportal.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author c19255
 */
public class UsuarioDAO  {

    public boolean login(Usuario usuario) throws ClassNotFoundException {
        boolean result = false;
         Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from tbusuarios where correo = ? and clave = ? ")) {
            preparedStatement.setString(1, usuario.getCorreo());
            preparedStatement.setString(2, usuario.getClave());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            result = rs.next();
            
            
            String clave="", nombre="", tipo="";
            
            // TEST PROFILE
            if (rs.next())
            {
             nombre = rs.getString(1);
             clave = rs.getString(2);
             tipo = rs.getString(3);
             usuario.setNombres(nombre);
             usuario.setApellidos(rs.getString(2));
            }
            System.out.println("Nombre: "+nombre + "Tipo: " + tipo );
        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
        return result;
    }
    
   public Usuario validarUsuario(String email, String password) throws ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
       Usuario usu=new Usuario();
        try (Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from tbusuarios where correo = ? and clave = ? ")) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            
            
            String clave="", nombre="", tipo="";
            
            // TEST PROFILE
            if (rs.next())
            {
             usu.setNombres(rs.getString("nombre"));
             usu.setApellidos(rs.getString("apellido"));
             usu.setDni(rs.getString("dni"));
             usu.setCorreo(rs.getString("correo"));
                nombre=rs.getString("nombre");
            }
            System.out.println("Nombre: "+nombre + "Tipo: " + tipo );
        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
        return usu;
   }
   
   public List listarUsuario(){
       String sql="select * from tbusuarios";
       List<Usuario> listaUsu=new ArrayList<>();
       
       try (Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Usuario usu=new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setNombres(rs.getString("nombre"));
                usu.setApellidos(rs.getString("apellido"));
                usu.setDni(rs.getString("DNI"));
                usu.setTelefono(rs.getString("telefono"));
                usu.setDireccion(rs.getString("direccion"));
                usu.setCorreo(rs.getString("correo"));
                listaUsu.add(usu);
            }

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
       
       return listaUsu;
   }
   
   

    public int registrarUsuario(Usuario usuario) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO tbusuarios" +
            "  (nombre, apellido, DNI, telefono, direccion, correo, clave, tipo) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?);";

        int result = 0;
        try (Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            System.out.println(usuario.getCorreo());
            System.out.println(usuario.getClave());
            System.out.println(usuario.getTipo());
            preparedStatement.setString(1, usuario.getNombres());
            preparedStatement.setString(2, usuario.getApellidos());
            preparedStatement.setString(3, usuario.getDni());
            preparedStatement.setString(4, usuario.getTelefono());
            preparedStatement.setString(5, usuario.getDireccion());
            preparedStatement.setString(6, usuario.getCorreo());
            preparedStatement.setString(7, usuario.getClave());
            preparedStatement.setString(8, usuario.getTipo());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
        return result;
    }
    
    public Usuario listarId(int id){
        Usuario usu=new Usuario();
        String sql="select * from tbusuarios where id="+id+";";
       List<Usuario> listaUsu=new ArrayList<>();
       
       try (Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                usu.setNombres(rs.getString("nombre"));
                usu.setApellidos(rs.getString("apellido"));
                usu.setDni(rs.getString("DNI"));
                usu.setTelefono(rs.getString("telefono"));
                usu.setDireccion(rs.getString("direccion"));
                usu.setCorreo(rs.getString("correo"));
                listaUsu.add(usu);
            }

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
       
       return usu;
       

    }
    
    public int actualizarUusuario(Usuario usuario){
        String INSERT_USERS_SQL = "UPDATE tbusuarios" +
            " set nombre=?, apellido=?,DNI=?, telefono=?, direccion=?, correo=?, clave=?, tipo=? " +
            " where id=?";

        int result = 0;
        try (Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)) {
            System.out.println(usuario.getCorreo());
            System.out.println(usuario.getClave());
            System.out.println(usuario.getTipo());
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getDni());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getDireccion());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getClave());
            ps.setString(8, usuario.getTipo());
            ps.setInt(9, usuario.getId());
            System.out.println(ps);
            // Step 3: Execute the query or update query
            result = ps.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
        return result;
        
    }
    
    public void deleteUsuario(int id){
         String INSERT_USERS_SQL = "DELETE FROM tbusuarios" +
            " where id="+id;

        int result = 0;
        try (Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)) {
            System.out.println(ps);
            // Step 3: Execute the query or update query
            ps.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            JDBCUtils.printSQLException(e);
        }
        
    }

   
    
    
}
