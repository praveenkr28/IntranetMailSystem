import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;
import java.util.Date;
import java.util.StringTokenizer;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
public class Serv_Send extends HttpServlet
{

    public Serv_Send()
    {
        stmt = null;
        st1 = null;
        st2 = null;
        st3 = null;
        con = null;
        rs = null;
        rs1 = null;
        scon = null;
        mfrom = null;
        flag = true;
        str1 = null;
        mdate = "";
    }

    public void service(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        try
        {
			pw=httpservletresponse.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            con = DriverManager.getConnection("jdbc:mysql://localhost/intranet", "root", "");
            log("Connection created");
            stmt = con.createStatement();
            scon = getServletContext();
            HttpSession httpsession = httpservletrequest.getSession(true);
            mfrom = httpsession.getValue("name").toString();
            DiskFileItemFactory fin=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(fin);
            /*String s = httpservletrequest.getParameter("to");
            String s1 = httpservletrequest.getParameter("subject");
            String s2 = httpservletrequest.getParameter("cc");
            String s3 = httpservletrequest.getParameter("bcc");
            String s4 = httpservletrequest.getParameter("s1");
            String s5 = httpservletrequest.getParameter("maildata");*/
			List<FileItem> fields=upload.parseRequest(httpservletrequest);
			Iterator it=fields.iterator();
			while(it.hasNext())
			{
				FileItem fileitem=(FileItem)it.next();
				if(fileitem.isFormField())
				{	
					if(fileitem.getFieldName().equals("to"))
					{
						s =fileitem.getString();
					}
					if(fileitem.getFieldName().equals("subject"))
					{
						s1 =fileitem.getString();
					}
					if(fileitem.getFieldName().equals("cc"))
					{
						s2 = fileitem.getString();
					}
					if(fileitem.getFieldName().equals("bcc"))
					{
						s3 = fileitem.getString();
					}
					if(fileitem.getFieldName().equals("s1"))
					{
						s4 = fileitem.getString();
					}
					if(fileitem.getFieldName().equals("maildata"))
					{
						s5 = fileitem.getString();
					}
				}
				else
				{
					filename=fileitem.getName();
					if(filename.equals(""))
					{
					
					}
					else
					{
						File f=new File("python",fileitem.getName());
						f.getAbsolutePath();
						fileitem.write(f);
						//filename=null;
					}
				}
				
			}
			log("username="+s+s1);
			StringTokenizer stringtokenizer = new StringTokenizer(s, ",");
			mdate = String.valueOf(new Date());
			while(stringtokenizer.hasMoreTokens()) 
			{
				str1 = stringtokenizer.nextToken();
				st1 = con.createStatement();
				rs1 = st1.executeQuery("select * from signupdetails where uname='" + str1 + "'");
				if(rs1.next())
				{
					bool = true;
				} else
				{
					bool = false;
					pw.println("<html><head><script>{alert('Invalid Mail-to address - He is an unregistered user');window.history.go(-1);}</script></head></html>");
				}
				rs1.close();
				st1.close();
				if(bool && flag)
				{
					rs = stmt.executeQuery("Select max(mailid) from newcompose");
					rs.next();
					if(rs == null)
					{
						i = 1;
					} else
					{
						i = rs.getInt(1);
						i++;
					}
					rs.close();
					st2 = con.createStatement();
					log("St2 successful");
					int j = st2.executeUpdate("insert into newcompose values(" + i + ",'" + mfrom + "','" + str1 + "','" + s1 + "','" + s2 + "','" + s3 + "','"+filename+"','" + s5 + "','inbox','" + mdate + "',0)");
					if(j > 0)
						pw.println("<html><body bgcolor=white background=indtextb.jpg text=blue><font color=blue><h3><i>Message has been sent to " + str1 + " </i></h3></font>");
					else
						pw.println("<html><body bgcolor=white background=indtextb.jpg text=blue><font color=red><h3><i>Some error in message sending</i></h3></font>");
					st2.close();
				}
			}
			str1 = "";
			i++;
			st3 = con.createStatement();
			log("St3 successful");
			int k = st3.executeUpdate("insert into newcompose values(" + i + ",'" + mfrom + "','" + s2 + "','" + s1 + "','','" + s3 + "','','" + s5 + "','inbox','" + mdate + "', 0)");
			if(k > 0)
				pw.println("<html><body bgcolor=white background=indtextb.jpg text=blue><font color=blue><h3><i>Message has been sent to " + s2 + " </i></h3></font>");
			else
				pw.println("<html><body bgcolor=white background=indtextb.jpg text=blue><font color=red><h3><i>Some error in message sending</i></h3></font>");
			st3.close();
			pw.println("<form action=Serv_NewAddress><center>");
			pw.println("<h3><a href=Serv_Compose>Compose</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href=Serv_Inbox>Goto Inbox</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href=Serv_NewAddress>Add Address</a>");
			pw.println("</form></body></html>");
		}
		catch(SQLException exception)
		{
			log(exception);
			exception.printStackTrace();
		}
		catch(Exception exception)
		{
			log(exception);
			exception.printStackTrace();
		}
	}

    Statement stmt;
    Statement st1;
    Statement st2;
    Statement st3;
    Connection con;
    ResultSet rs;
    ResultSet rs1;
    int i;
    ServletContext scon;
    boolean bool;
    String mfrom;
    boolean flag;
    String str1;
    String mdate;
	String filename;
	PrintWriter pw;
	String s,s1,s2,s3,s4,s5;
}
