
package com.david.giczi.calendar.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GicziD
 */
@WebServlet(name = "InitServlet", urlPatterns = {"/init"})
public class InitServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
      List<String> months = new ArrayList<>();
      
      months.add("Január");
      months.add("Február");
      months.add("Március");
      months.add("Április");
      months.add("Május");
      months.add("Június");
      months.add("Július");
      months.add("Augusztus");
      months.add("Szeptember");
      months.add("Október");
      months.add("November");
      months.add("December");
           
     String thisYear =  new SimpleDateFormat("yyyy").format(new Date(System.currentTimeMillis()));
     String thisMonth =  new SimpleDateFormat("M").format(new Date(System.currentTimeMillis()));
       
     request.setAttribute("monthsname", months);
     request.setAttribute("thisyear", thisYear);
     request.setAttribute("thismonth", Integer.parseInt(thisMonth)-1);
     
     request.getRequestDispatcher("start.jsp").forward(request, response);
     
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
