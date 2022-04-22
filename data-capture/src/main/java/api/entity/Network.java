package api.entity;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

public class Network {
    public String getMAC(InetAddress addr) throws SocketException {
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
}
