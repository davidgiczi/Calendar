package com.david.giczi.calendar.servlets;

import com.david.giczi.calendar.model.EventCreator;
import com.david.giczi.calendar.model.Month;
import com.david.giczi.calendar.model.MonthFactory;
import com.david.giczi.calendar.utils.MonthName;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GicziD
 */
@WebServlet(name = "MonthlyEventsDeleteServlet", urlPatterns = {"/delete"})
public class MonthlyEventsDeleteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Map<String, String[]> store = request.getParameterMap();

        Month month = MonthFactory.createMonth(MonthName.getMonthNameByIndex(
                Integer.parseInt(store.get("inputmonth")[0])), Integer.parseInt(store.get("inputyear")[0]));

        EventCreator.clearAddedEventNameFromTheMonthDays(month);
        EventCreator.addEventsToTheMonth(month);
        EventCreator.deleteAddedEventsFromTheMonths(month);

        request.getRequestDispatcher("create?inputyear=" + month.getYear() + "&inputmonth="
                + store.get("inputmonth")[0]).forward(request, response);

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
