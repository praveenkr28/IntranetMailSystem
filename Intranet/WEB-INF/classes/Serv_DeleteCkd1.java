import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Serv_DeleteCkd1 extends HttpServlet
{
    Statement st;
    Statement st1;
    ResultSet rs;
    ResultSet rs1;
    Connection con;
    ServletContext scon;
    String uname;
    int y;
    public Serv_DeleteCkd1()
    {
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        try
        {
            int i = 0;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/intranet", "root", "");

            st = con.createStatement();
            st1 = con.createStatement();
            scon = getServletContext();
            HttpSession httpsession = httpservletrequest.getSession(true);
            uname = httpsession.getValue("name").toString();
            ServletOutputStream servletoutputstream = httpservletresponse.getOutputStream();
            int j = Integer.parseInt(httpservletrequest.getParameter("hid"));
            for(int k = 1; k <= j; k++)
            {
                String s = httpservletrequest.getParameter("b" + k);
                if(s != null)
                {
                    int l = Integer.parseInt(s);
                    y = st1.executeUpdate("delete from newcompose where mailid=" + l);
                    if(y > 0)
                    {
                        i++;
                        servletoutputstream.println("<html><body bgcolor=white background=indtextb.jpg text=blue>");
                        servletoutputstream.println("</body></html>");
                        httpservletresponse.setHeader("Refresh", "2;URL=Serv_Sent");
                    }
                }
            }

            servletoutputstream.println("<h3><i>" + i + "Record deleted </i></h3>");
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    
}
