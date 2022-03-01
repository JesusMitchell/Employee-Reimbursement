package revature;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int numone = Integer.parseInt(request.getParameter("num1"));
        int numtwo = Integer.parseInt(request.getParameter("num2"));

        response.getWriter().write("Those two numbers equal " + (numone + numtwo));
    }


}
