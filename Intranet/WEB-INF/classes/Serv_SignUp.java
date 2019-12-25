import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;

public class Serv_SignUp extends HttpServlet
{
    Connection con;
    Statement st;
    static String u;
    static String p;
    ResultSet rs;
    public Serv_SignUp()
    {
    }
    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
		ServletOutputStream servletoutputstream = httpservletresponse.getOutputStream();;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/intranet", "root", "");
            st = con.createStatement();            
            p = httpservletrequest.getParameter("pwd1");
            HttpSession httpsession = httpservletrequest.getSession(true);
            httpsession.putValue("name", httpservletrequest.getParameter("uname1"));
            u = httpsession.getValue("name").toString();
            rs = st.executeQuery("select * from signupdetails where uname='" + u + "' and  passwd='" + p + "'");
			//servletoutputstream.println("select * from signupdetails where uname='" + u + "' and  passwd='" + p + "'");
            if(rs.next())
            {
                httpservletresponse.sendRedirect("listoptions.html");
            } else
            {
                servletoutputstream.println("<html><body bgcolor=white background=indtextb.jpg text=red><h2><i><b>You are not a valid user! Try again using correct Loginname & Password or try registering </b></i></h2></body></html>");
                httpservletresponse.setHeader("Refresh", "15;URL=loginsc.html");
            }
        }
        catch(Exception exception)
        {
            servletoutputstream.println(""+exception);
        }
    }

   
}
