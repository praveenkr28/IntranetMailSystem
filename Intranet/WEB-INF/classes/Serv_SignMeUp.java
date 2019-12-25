import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Serv_SignMeUp extends HttpServlet
{
     Connection con;
    Statement st;
    Statement st1;
    PreparedStatement ps;
    ResultSet rs;
    boolean b;
    ServletOutputStream sos;
    public Serv_SignMeUp()
    {
        con = null;
        st = null;
        st1 = null;
        ps = null;
        rs = null;
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        try
        {
            super.init(servletconfig);
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/intranet", "root", "");

            st = con.createStatement();
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
            sos = httpservletresponse.getOutputStream();
            String s = httpservletrequest.getParameter("uname");
            String s1 = httpservletrequest.getParameter("pwd");
            String s2 = httpservletrequest.getParameter("age");
            int i = Integer.parseInt(s2);
            String s3 = httpservletrequest.getParameter("r1");
            String s4 = httpservletrequest.getParameter("city");
            String s5 = httpservletrequest.getParameter("state");
            String s6 = httpservletrequest.getParameter("pin");
            int j = Integer.parseInt(s6);
            String s7 = httpservletrequest.getParameter("nation");
            ResultSet resultset = st.executeQuery("select * from signupdetails where uname='" + s + "'");
            if(resultset.next())
            {
                sos.println("<html><body><h2>Username already exists. Try giving another name</h2></body></html>");
                httpservletresponse.setHeader("Refresh", "3;URL=signmeup.html");
            } else
            {
                st1 = con.createStatement();
                ps = con.prepareStatement("insert into signupdetails values(?,?,?,?,?,?,?,?)");
                ps.setString(1, s);
                ps.setString(2, s1);
                ps.setInt(3, i);
                ps.setString(4, s3);
                ps.setString(5, s4);
                ps.setString(6, s5);
                ps.setInt(7, j);
                ps.setString(8, s7);
                ps.execute();
                sos.println("<h1> hello </h1>");
                sos.println("<html><body bgcolor=white background=indtextb.jpg text=blue><h1>Congrats ! <br>for sucessfully registering urself with the Intranet Mailing System </h1></body></html>");
                httpservletresponse.setHeader("Refresh", "2;URL=loginsc.html");
                ps = con.prepareStatement("insert into folders values(?,?)");
                ps.setString(1, s);
                ps.setString(2, "Trash");
                ps.execute();
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
    }

   
}
