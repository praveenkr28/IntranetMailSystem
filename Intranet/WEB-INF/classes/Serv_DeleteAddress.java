import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Serv_DeleteAddress extends HttpServlet
{
    Statement st;
    Connection con;
    ServletContext scon;
    String frname;
    public Serv_DeleteAddress()
    {
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/intranet", "root", "");


            st = con.createStatement();
            ServletOutputStream servletoutputstream = httpservletresponse.getOutputStream();
            String s = httpservletrequest.getParameter("name");
            System.out.println("nm: " + s);
            int i = st.executeUpdate("delete from address where uname='" + s + "'");
            if(i > 0)
            {
                servletoutputstream.println("<html><body bgcolor=white background=indtextb.jpg text=blue><h2><i>Address of  " + s + "  deleted successfully</i></h2></body></html>");
                httpservletresponse.setHeader("Refresh", "2;URL='Serv_Address'");
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    
}
