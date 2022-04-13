package external;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Network {

    public String getMac(InetAddress addr) throws SocketException{
        NetworkInterface iface
                = NetworkInterface.getByInetAddress(addr);

        byte[] mac = iface.getHardwareAddress();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format(
                    "%02X%s", mac[i],
                    (i < mac.length - 1) ? "-" : ""));
        }

        return sb.toString();
    }
    
    public String getLocalHost() {

        try {
            String localhost = InetAddress.getLocalHost().getHostName();
            return localhost;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getLocalHost(InetAddress addr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}