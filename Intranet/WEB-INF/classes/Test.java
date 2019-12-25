import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class Test extends javax.servlet.http.HttpServlet implements
        javax.servlet.Servlet {
    static final long serialVersionUID = 1L;
    private static final int BUFSIZE = 4096000;
    private String filePath;
    String filename;
    public void init() {
        
        filePath = "C:/xampp/python\\";
    }
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		filename=request.getParameter("fileno");
        File file = new File(filePath+filename);
        int length   = 0;
        ServletOutputStream outStream = response.getOutputStream();
        ServletContext context  = getServletConfig().getServletContext();
        String mimetype = context.getMimeType(filePath+filename);
        
        // sets response content type
        if (mimetype == null) {
            mimetype = "application/au";
        }
        response.setContentType(mimetype);
        response.setContentLength((int)file.length());
        String fileName = (new File(filePath+filename)).getName();
        
        // sets HTTP header
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        
        byte[] byteBuffer = new byte[BUFSIZE];
        DataInputStream in = new DataInputStream(new FileInputStream(file));
        
        // reads the file's bytes and writes them to the response stream
        while ((in != null) && ((length = in.read(byteBuffer)) != -1))
        {
            outStream.write(byteBuffer,0,length);
        }
        
        in.close();
        outStream.close();
    }
}
