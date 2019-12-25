import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Serv_ChangePwd extends HttpServlet
{
     Statement st;
    Connection con;
    ResultSet rs;
    ServletContext scon;
    String un;
    public Serv_ChangePwd()
    {
    }

    public void init(ServletConfig servletconfig)
    {
        try
        {
            super.init(servletconfig);
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/intranet", "root", "");


            st = con.createStatement();
            scon = getServletContext();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        try
        {
            HttpSession httpsession = httpservletrequest.getSession(true);
            un = httpsession.getValue("name").toString();
            ServletOutputStream servletoutputstream = httpservletresponse.getOutputStream();
            String s = httpservletrequest.getParameter("np");
            int i = st.executeUpdate("Update signupdetails set passwd='" + s + "' where uname='" + un + "'");
            servletoutputstream.println("<html><body bgcolor=white background=indtextb.jpg text=blue><h2><i>password is changed</i></h2></body></html>");
            httpservletresponse.setHeader("Refresh", "2;URL=Serv_Inbox");
        }
        catch(SQLException exception)
        {
            httpservletresponse.getOutputStream().println(""+exception);
        }
		
    }

   
}
