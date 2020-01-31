
package com.david.giczi.calendar.servlets;

import com.david.giczi.calendar.model.OrganizingMonthDataForView;
import com.david.giczi.calendar.model.Validate;
import com.david.giczi.calendar.utils.MonthName;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GicziD
 */
@WebServlet(name = "ValidateServlet", urlPatterns = {"/validate"})
public class ValidateServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter pw = response.getWriter();
        
        String inputData = request.getParameter("data");
       
        String[] inputDataStore = inputData.split(",");
        
        for (String string : inputDataStore) {
            System.out.println("-"+string);
        }
        
      if(  inputDataStore.length == 2 && !Validate.isYearValid(inputDataStore[0]) ){
           
      pw.append("Csak szám lehet az évszám adat és 1581 < értéke < 10000.");
            
      }
      else if (inputDataStore.length > 2 ) {
        
           
          String inYear = inputDataStore[inputDataStore.length-2];
          String inMonth = inputDataStore[inputDataStore.length-1];
          
        for( int i = 0; i< inputDataStore.length-2; i++)   {
            
            
        if( i%2 == 1 && !Validate.isMonthDayNumberValid(inputDataStore[i], inYear, inMonth) ) {
           
          OrganizingMonthDataForView o = new OrganizingMonthDataForView(Integer.parseInt(inYear),
                  MonthName.getMonthNameByIndex(Integer.parseInt(inMonth)));
                   
          pw.append(o.getNameOfMonth()+" hónap "+o.getMonthDaysNumber()+
                  " napos és 0 < napok száma < "+(o.getMonthDaysNumber()+1)+"." );
           
         return;
       }
                      
            
   }
          
       
          
          
          
          
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
