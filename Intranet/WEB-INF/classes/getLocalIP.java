import java.net.InetAddress;

public class getLocalIP
{

    public getLocalIP()
    {
    }

    public String HostName()
        throws Exception
    {
        InetAddress inetaddress = InetAddress.getLocalHost();
        String s = inetaddress.getHostName();
        return s;
    }
}
