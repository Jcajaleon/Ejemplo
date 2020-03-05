/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportal.controller;

import com.miportal.model.Usuario;
import com.miportal.model.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor_Thebestone
 */
@WebServlet(name = "MenuController", urlPatterns = {"/MenuController"})
public class MenuController extends HttpServlet {
    Usuario ji=new Usuario();
    UsuarioDAO usuDao=new UsuarioDAO();
    int idUsu;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu=request.getParameter("menu");
        String accion=request.getParameter("accion");
        if(menu.equalsIgnoreCase("Principal")){
            
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else if(menu.equalsIgnoreCase("Usuario")){
            switch(accion){
                case "Listar":
                    List lista=usuDao.listarUsuario();
                    request.setAttribute("listaUsuario", lista);
                    break;
                case "Agregar":
                    String nombres=request.getParameter("txtNombres");
                    String apellidos=request.getParameter("txtApellidos");
                    String dni=request.getParameter("txtDni");
                    String telefono=request.getParameter("txtTelefono");
                    String direccion=request.getParameter("txtDireccion");
                    String correo=request.getParameter("txtCorreo");
                    String clave=request.getParameter("txtClave");
                    ji.setNombres(nombres);
                    ji.setApellidos(apellidos);
                    ji.setDni(dni);
                    ji.setTelefono(telefono);
                    ji.setDireccion(direccion);
                    ji.setCorreo(correo);
                    ji.setClave(clave);
                    ji.setTipo("2");
                    //usuDao.registrarUsuario(ji);
                    try {
                        int result =  usuDao.registrarUsuario(ji);
                        if (result == 1) {
                            request.setAttribute("NOTIFICATION", "User Registered Successfully!");
                    }

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    request.getRequestDispatcher("MenuController?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idUsu=Integer.parseInt(request.getParameter("idUsu"));
                    //idUsu=1;
                    Usuario u=usuDao.listarId(idUsu);
                    request.setAttribute("usuar", u);
                    request.getRequestDispatcher("MenuController?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombres1=request.getParameter("txtNombres");
                    String apellidos1=request.getParameter("txtApellidos");
                    String dni1=request.getParameter("txtDni");
                    String telefono1=request.getParameter("txtTelefono");
                    String direccion1=request.getParameter("txtDireccion");
                    String correo1=request.getParameter("txtCorreo");
                    String clave1=request.getParameter("txtClave");
                    ji.setNombres(nombres1);
                    ji.setApellidos(apellidos1);
                    ji.setDni(dni1);
                    ji.setTelefono(telefono1);
                    ji.setDireccion(direccion1);
                    ji.setCorreo(correo1);
                    ji.setClave(clave1);
                    ji.setTipo("2");
                    ji.setId(idUsu);
                    
                    //usuDao.registrarUsuario(ji);
                    try {
                        int result =  usuDao.actualizarUusuario(ji);
                        if (result == 1) {
                            request.setAttribute("NOTIFICATION", "User Registered Successfully!");
                    }

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    request.getRequestDispatcher("MenuController?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                   idUsu=Integer.parseInt(request.getParameter("idUsu"));
                    
                    //usuDao.registrarUsuario(ji);
                    try {
                         usuDao.deleteUsuario(idUsu);
                        
                        request.setAttribute("NOTIFICATION", "User Registered Successfully!");
            
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    request.getRequestDispatcher("MenuController?menu=Usuario&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            
            request.getRequestDispatcher("RegistroUsuario.jsp").forward(request, response);
        }
        else if(menu.equalsIgnoreCase("Especialidad")){
            
            request.getRequestDispatcher("Especialidad.jsp").forward(request, response);
        }
        else if(menu.equalsIgnoreCase("Medico")){
            
            request.getRequestDispatcher("Medico.jsp").forward(request, response);
        }
        else if(menu.equalsIgnoreCase("CitaMedica")){
            
            request.getRequestDispatcher("CitasMedicas.jsp").forward(request, response);
        }
        else
        {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
