/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
public class SaveAddress extends HttpServlet {

    Connection con;
    PreparedStatement ps;
     public void init() {
        try{
        con = mypkg.Data.connect();
        String qr = "insert into udetails values(?,?,?)";
        ps = con.prepareStatement(qr);
        }catch(Exception e){}
    }

    public void destroy() {
        try {
            con.close();
        } catch (Exception e) {

        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
            
       String uadd=request.getParameter("uadd");
       String ustate=request.getParameter("ustate");
       String upin=request.getParameter("upin");
       
       try{ ps.setString(1, uadd);
         ps.setString(2, ustate);
          ps.setString(3, upin);   
             ps.executeUpdate();
           out.println("<h3>Address saved Successfully </h3>");
            out.println("<h4><a href=>Select payment mode</a></h4>");
    }catch(Exception e){
        out.println("<h3></h3>");
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
