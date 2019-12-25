import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class Serv_Logout extends HttpServlet
{
    ServletContext scon;
    String name;
    public Serv_Logout()
    {
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        try
        {
            scon = getServletContext();
            HttpSession httpsession = httpservletrequest.getSession(true);
            name = httpsession.getValue("name").toString();
            httpsession.removeValue("name");
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        ServletOutputStream servletoutputstream = httpservletresponse.getOutputStream();
        servletoutputstream.println("<html><title>Welcome To Intranet Mail System</title>");
        servletoutputstream.println("<body bgcolor=white background=indtextb.jpg text=blue><center><img src='thanks.gif'></center>");
        servletoutputstream.println("<center><h2><i>'" + name + "'</i></h2></center>");
        servletoutputstream.println("<center><h2><i>For Visiting Intranet Mailing System</i></h2></center>");
        servletoutputstream.println("<center><a href='loginsc.html' target=_parent><h3>Login to Intranet Mail System</h3></a></center>");
        servletoutputstream.println("</body></html>");
    }

    
}
