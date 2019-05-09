
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyProduct extends HttpServlet {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public void init() {
        try{
        con = mypkg.Data.connect();
        String qr="select * from products where PCode=?";
        ps = con.prepareStatement(qr,ResultSet.TYPE_SCROLL_SENSITIVE,
          ResultSet.CONCUR_UPDATABLE);
        
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
        String s=request.getParameter("pcode");
        int id=Integer.parseInt(s);
        try{ps.setInt(1, id);
         rs=ps.executeQuery();
        rs.next();
        }
        catch(Exception e){
            out.println("<h1>Congratulations!! your details are modified 1</h1>");
        }
        String s1=request.getParameter("name");
        String s2=request.getParameter("desc");
        String s3=request.getParameter("cat");
        String s4=request.getParameter("price");
        
        
        try{if(s1!=null){rs.updateString("pName",s1);}
        if(s2!=null){rs.updateString("pdesc",s2);}
       if(s3!=null){ rs.updateString("pcat",s3);}
        if(s4!=null){rs.updateInt("price",Integer.parseInt(s4));}
        //rs.updateRow();
        }
        
        catch(Exception e){
            out.println("<h1>Congratulations!! your details are modified 2</h1>");
        }
        
        out.println("<h1>Congratulations!! your details are modified");
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
