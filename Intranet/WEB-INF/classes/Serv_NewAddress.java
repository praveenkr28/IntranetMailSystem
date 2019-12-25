import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Serv_NewAddress extends HttpServlet
{
     Connection con;
    Statement st;
    ServletContext scon;
    public Serv_NewAddress()
    {
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/intranet", "root", "");

            st = con.createStatement();
            scon = getServletContext();
            String s;
            try
            {
                HttpSession httpsession = httpservletrequest.getSession(true);
                s = httpsession.getValue("name").toString();
            }
            catch(Exception exception1)
            {
                s = "vinodkumar";
            }
            ServletOutputStream servletoutputstream = httpservletresponse.getOutputStream();
            servletoutputstream.println("<html><head><title>Welcome To Intranet Mailing System</title></head>");
            servletoutputstream.println("<h1><center><blink>New Address Screen</blink></center></h1><body bgcolor=white background=indtextb.jpg text=blue><h3>Adding new address to '" + s + "'<b>Address Box</b></h3><br>");
            servletoutputstream.println("<form name=form8 method=post action='Serv_AddAddress'><pre><b><h3><center>Allows To Add Name,Nick Name,Mail_Id</center></h3></b>");
            servletoutputstream.println("<b>Name     </b>:   <input type=text name=nam value=''><br>");
            servletoutputstream.println("<b>Nick Name</b>:   <input type=text name=nname value=''><br>");
            servletoutputstream.println("<b>E-mail Id</b>:   <input type=text name=mid value=''><br>");
            servletoutputstream.println("<b>Address  </b>:   <input type=text name=add value=''><br>");
            servletoutputstream.println("<b>Phone No.</b>:   <input type=text name=pno value=''><br><br>");
            servletoutputstream.println("<input type=submit name=s7 value='ADD-ADDRESS'></form></body></HTML>");
        }
        catch(SQLException exception)
        {
            httpservletresponse.getOutputStream().println(""+exception);
        }
		catch(ClassNotFoundException exception)
        {
            httpservletresponse.getOutputStream().println(""+exception);
        }
    }

   
}
