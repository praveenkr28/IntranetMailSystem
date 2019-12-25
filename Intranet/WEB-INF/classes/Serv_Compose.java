import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Serv_Compose extends HttpServlet
{

    public Serv_Compose()
    {
        con = null;
        st = null;
        scon = null;
        rs = null;
        sos = null;
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
            String s = null;
            HttpSession httpsession = httpservletrequest.getSession(true);
            s = httpsession.getValue("name").toString();
            ServletOutputStream servletoutputstream = httpservletresponse.getOutputStream();
            servletoutputstream.println("<html><title>Intranet Mailing System</title>");
            servletoutputstream.println("<body bgcolor=white background=indtextb.jpg text=blue><center></center>");
            servletoutputstream.println("<pre>");
            servletoutputstream.println("<form name=form4 method=post action='Serv_Send' enctype='multipart/form-data'>");
            servletoutputstream.println("To                  :<input type=text name=to value=''><br>");
            servletoutputstream.println("Subject             :<input type=text name=subject value=''><br>");
            servletoutputstream.println("Cc                  :<input type=text name=cc value=''><br>");
            servletoutputstream.println("Bcc                 :<input type=text name=bcc value=''><br><br>");
            servletoutputstream.println("<input type=file name=filename><font face=verdana><b>Attach Files</b></font></a>");
            servletoutputstream.println("<textarea name=maildata rows=10 cols=60></textarea><br>");
            servletoutputstream.println("<input type=submit name=submit1 value='SEND'><br>");
            rs = st.executeQuery("select actname,emailid from address where uname='" + s + "'");
            /*if(rs.next())
            {
                servletoutputstream.println("<SELECT name=se onclick=getName(value) style=\"LEFT: 400px; POSITION: absolute; TOP: 160px; BACKGROUND-COLOR:#b464ff;width:130px;FONT-WEIGHT:BOLD\"");
                servletoutputstream.println("SIZE=5 name=List1 value=\"List1\">");
                do
                    servletoutputstream.println("<OPTION value=" + rs.getString(2) + " >" + rs.getString(1) + "</OPTION>");
                while(rs.next());
                servletoutputstream.println("</SELECT>");
            }*/
            servletoutputstream.println("</form></body></html>");
            servletoutputstream.println("<script language=javascript>");
            servletoutputstream.println("function getName(Myname){");
            servletoutputstream.println("document.form4.to.value=Myname");
            servletoutputstream.println("}</script>");
        }
        catch(Exception exception)
        {
			  ServletOutputStream servletoutputstream = httpservletresponse.getOutputStream();
            servletoutputstream.println(""+exception);
			exception.printStackTrace();
        }
    }

    Connection con;
    Statement st;
    ServletContext scon;
    ResultSet rs;
    ServletOutputStream sos;
}
