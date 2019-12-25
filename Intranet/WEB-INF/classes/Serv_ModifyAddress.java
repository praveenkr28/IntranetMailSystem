import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Serv_ModifyAddress extends HttpServlet
{
    Statement st;
    Connection con;
    ServletContext scon;
    String frname;
    String newfraddress;
    String newfrmid;
    int newfrphone;
    public Serv_ModifyAddress()
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
            ServletOutputStream servletoutputstream = httpservletresponse.getOutputStream();
            String s = httpservletrequest.getParameter("nam");
            System.out.println("str:" + s);
            newfraddress = httpservletrequest.getParameter("add1");
            System.out.println("new address:" + newfraddress);
            int i = Integer.parseInt(httpservletrequest.getParameter("pno1"));
            System.out.println("new phone: " + i);
            newfrmid = httpservletrequest.getParameter("mid1");
            System.out.println("new frm id:" + newfrmid);
            System.out.println("str=" + s + "add=" + newfraddress + "ph=" + i + "id=" + newfrmid);
            int j = st.executeUpdate("update address set addresses='" + newfraddress + "',phone=" + i + ",emailid='" + newfrmid + "' where uname='" + s + "'");
            if(j > 0)
            {
                servletoutputstream.println("<html><body bgcolor=white background=indtextb.jpg text=blue><h2><i>" + s + "'s Address Updated Successfully</i></h2></body></html>");
                httpservletresponse.setHeader("Refresh", "2;URL='Serv_Address'");
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    
}
