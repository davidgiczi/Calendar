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

        if (!Validate.isYearValid(inputDataStore[0])) {

            pw.append("Csak szám lehet az évszám adat és 1581 < értéke < 10000.");
            return;
        }

        String inYear = inputDataStore[0];
        String inMonth = inputDataStore[1];

        OrganizingMonthDataForView o = new OrganizingMonthDataForView(Integer.parseInt(inYear),
                MonthName.getMonthNameByIndex(Integer.parseInt(inMonth)));

        for (int i = 2; i < inputDataStore.length; i++) {

            if (i % 2 == 1 && !Validate.isMonthDayNumberValid(inputDataStore[i], inYear, inMonth)) {

                pw.append(o.getNameOfMonth() + " hónap " + o.getMonthDaysNumber()
                        + " napos, 0 < napok száma < " + (o.getMonthDaysNumber() + 1) + ".");
                return;
            }

        }

        for (int i = 2; i < inputDataStore.length; i++) {

            if (i % 2 == 0 && !Validate.isEasterValid(inputDataStore[i], inYear, inMonth, inputDataStore[i + 1])) {

                int day = Integer.parseInt(inputDataStore[i + 1]);
                o.setDay(day);

                pw.append("Húsvétnak március vagy április hónpban hétfői napra kell esnie, "
                        + inYear + ". " + o.getNameOfMonth().toLowerCase() + " " + inputDataStore[i + 1] + ". (" + o.getNameOfDay() + ").");

            }

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
