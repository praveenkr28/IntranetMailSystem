import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Serv_SeeMessage extends HttpServlet
{
    Statement st;
    Statement st1;
    ResultSet rs;
    Connection con;
    ServletContext scon;
    String uname,filename;
    public Serv_SeeMessage()
    {
        st = null;
        st1 = null;
        rs = null;
        con = null;
        scon = null;
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/intranet","root","");
            scon=getServletContext();
            HttpSession httpsession = httpservletrequest.getSession(true);
            uname = httpsession.getValue("name").toString();
            st = con.createStatement();
            ServletOutputStream servletoutputstream = httpservletresponse.getOutputStream();
            System.out.println("id:" + httpservletrequest.getParameter("id"));
            int i = 0;
            try
            {
                i = Integer.parseInt(httpservletrequest.getParameter("id"));
            }
            catch(Exception exception1) { }
            System.out.println("mi:" + i);
            for(rs = st.executeQuery("select mailfrom,mailto,subject,maildate,mailcc,mailbcc,maildata,mailst,mailid,fileno from newcompose where mailto='" + uname + "' and mailid=" + i); 
			rs.next(); servletoutputstream.println("</form></body></html>"))
            {
                String s = rs.getString(1);
                String s1 = rs.getString(2);
                String s2 = rs.getString(3);
                String s3 = rs.getString(4);
                String s4 = rs.getString(5);
                String s5 = rs.getString(6);
                String s6 = rs.getString(7);
                int j = rs.getInt(8);
                int k = rs.getInt(9);
				filename=rs.getString(10);
                servletoutputstream.println("<html><head><title>Welcome to Intranet Mailing System</title></head>");
                servletoutputstream.println("<form name=fo>");
                servletoutputstream.println("<body bgcolor=white background=indtextb.jpg text=blue><pre>");
                servletoutputstream.println("<table cellpadding=15 ><tr><td><a href=Serv_Compose1?from=" + s + " & subj=" + s2 + ">Reply</a>");
                servletoutputstream.println("</td><td><a href=Serv_Inbox>Inbox</a></td></tr></table><hr>");
                servletoutputstream.println("<pre><br>");
				if(!filename.equals(""))
				{
					servletoutputstream.println("attachment:<a href=Test?fileno="+filename+">" + filename+" </a><br>");
				}
				servletoutputstream.println(s + " wrote a mail on " + s3 + "<br>");
                servletoutputstream.println("<p>" + s6 + "</pre>");
                servletoutputstream.println("<hr><table cellpadding=15><tr><td><a href=Serv_Compose1?from=" + s + "&subj=" + s2 + ">Reply</a>");
                servletoutputstream.println("</td><td><a href=Serv_Inbox>Inbox</a></td></tr></table>");
                //servletoutputstream.println("<center><img src=adv1.gif>");
                st1 = con.createStatement();
                int l = st1.executeUpdate("update newcompose set mailst=0 where mailid=" + k);
                st1.close();
            }

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
