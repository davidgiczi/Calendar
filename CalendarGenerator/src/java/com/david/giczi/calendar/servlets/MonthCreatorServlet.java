package com.david.giczi.calendar.servlets;

import com.david.giczi.calendar.model.EventCreator;
import com.david.giczi.calendar.model.Month;
import com.david.giczi.calendar.model.MonthFactory;
import com.david.giczi.calendar.model.OrganizingMonthDataForView;
import com.david.giczi.calendar.utils.MonthName;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GicziD
 */
public class MonthCreatorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Map<String, String[]> store = request.getParameterMap();

        Month month = MonthFactory.createMonth(MonthName.getMonthNameByIndex(
                Integer.parseInt(store.get("inputmonth")[0])), Integer.parseInt(store.get("inputyear")[0]));

        int j = 0;

        for (int i = 1; i < store.size() - (1 + j); i++) {

            j++;

            EventCreator.collectEvents(store.get(i + "event")[0], store.get("inputyear")[0],
                    store.get("inputmonth")[0], store.get(i + "date")[0]);

        }

        EventCreator.addEventsToTheMonth(month);

        OrganizingMonthDataForView disp = new OrganizingMonthDataForView(month.getDays(),
                month.getYear(), month.getMonthName());

        request.setAttribute("year", disp.getYear());
        request.setAttribute("month", disp.getNameOfMonth());
        request.setAttribute("rows", disp.getNumberOfRows());
        request.setAttribute("daynumbers", disp.getDayNumberOfMonth());
        request.setAttribute("names", disp.getNamedaysOfMonth());
        request.setAttribute("holidays", disp.getHolidaysOfMonth());
        request.setAttribute("colors", disp.getDayColorOfMonth());

        request.getRequestDispatcher("display.jsp").forward(request, response);

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
