import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Serv_EditAddress extends HttpServlet
{
        Statement st;
    Connection con;
    ServletContext scon1;
    String fraddress;
    String frmid;
    String uname;
    String str;
    int frphone;
    ResultSet rs;
    public Serv_EditAddress()
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
            scon1 = getServletContext();
            HttpSession httpsession = httpservletrequest.getSession(true);
            uname = httpsession.getValue("name").toString();
            ServletOutputStream servletoutputstream = httpservletresponse.getOutputStream();
            str = httpservletrequest.getParameter("name");
            fraddress = httpservletrequest.getParameter("add");
            frphone = Integer.parseInt(httpservletrequest.getParameter("pno"));
            frmid = httpservletrequest.getParameter("mid");
            System.out.println(str);
            servletoutputstream.println("<html><body bgcolor=white background=indtextb.jpg text=blue><h2><b><i><center>Modify Address,phone,mail_id of " + str + "</center></i></b></h2><br><br>");
            servletoutputstream.println("<form name=form7 method=post action='Serv_ModifyAddress'><pre>");
            servletoutputstream.println("<h3><i>For editing the fields overwrite that particular field</i></h3><br>");
            servletoutputstream.println("<b>Frd-Name </b>:   <input type=text name=nam value=" + str + " readonly><br>");
            servletoutputstream.println("<b>Address  </b>:   <input type=text name=add1 value=" + fraddress + "><br>");
            servletoutputstream.println("<b>Phone No.</b>:   <input type=text name=pno1 value=" + frphone + "><br>");
            servletoutputstream.println("<b>Mail Id  </b>:   <input type=text name=mid1 value=" + frmid + "><br>");
            servletoutputstream.println("<input type=submit name=s6 value='MODIFY-ADDRESS'>");
            servletoutputstream.println("</form></body></HTML>");
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }


}
