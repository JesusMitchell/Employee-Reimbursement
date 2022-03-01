package revature;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw =response.getWriter();
        pw.write( "Hello World me me Servlet");

        ServletConfig config = getServletConfig();
        System.out.println(config);

        response.getWriter().write(" Im a different thing :)");



    }


}
