/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportal.controller;

import com.miportal.model.Usuario;
import com.miportal.model.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author c19255
 */
public class LoginController extends HttpServlet {

    private UsuarioDAO usuarioDAO;
    Usuario usu=new Usuario();
    
    @Override
    public void init(){
        usuarioDAO = new UsuarioDAO();
    }
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
        
        String accion=request.getParameter("accion");
        if(accion.equalsIgnoreCase("Ingresar")){
            String correo = request.getParameter("txtCorreo");
            String clave = request.getParameter("txtClave");
            Usuario loginUsuario = new Usuario();
            loginUsuario.setCorreo(correo);
            loginUsuario.setClave(clave);

            try {
                usu=usuarioDAO.validarUsuario(correo, clave);
                if (usu.getCorreo()!=null) {

                    request.getSession().setAttribute("correo", usu.getCorreo());
                    request.getSession().setAttribute("datos", usu.getNombres() + " "+ usu.getApellidos());

                    RequestDispatcher dispatcher = request.getRequestDispatcher("Principal.jsp");
                    dispatcher.forward(request, response);
                } else {/*
                    HttpSession session = request.getSession();
                    session.setAttribute("user", correo);
                    response.sendRedirect("login.jsp");
                    */
                    String mensaje = "Usuario y/o clave incorrecta";
                    String link = "login";
                    request.getSession().setAttribute("link", link);
                    request.getSession().setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            
        }
       
/*
        String correo = request.getParameter("txtCorreo");
        String clave = request.getParameter("txtClave");

        if (correo.trim().isEmpty() || clave.trim().isEmpty()) {
            String mensaje = "Debera de completar todos los campos";
            String link = "login";
            request.getSession().setAttribute("link", link);
            request.getSession().setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            Usuario usuario = new Usuario();
            usuario.setCorreo(correo);
            usuario.setClave(clave);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (usuarioDAO.login(usuario)) {
                 if ("jperez@gmail.com".equals(usuario.getCorreo())){
                request.getRequestDispatcher("administrador.jsp").forward(request, response);
                 }
                 else {
                     request.getRequestDispatcher("usuario.jsp").forward(request, response);
                 }
            } else {
                String mensaje = "Usuario y/o clave incorrecta";
                String link = "login";
                request.getSession().setAttribute("link", link);
                request.getSession().setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        }
*/
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
