package Activity1;

// @author HenryR
import java.net.*;

public class DireccionIP {
    
    public String direccionLocal(){  
        String dataFinal="";
        
        try {
            InetAddress localHost = InetAddress.getLocalHost(); //Constructor para crear nueva instancia de la clase InetAddress
            Inet4Address ipV4 = (Inet4Address) Inet4Address.getByName(localHost.getHostName()); //Constructor para crear nueva instancia de la clase Inet4Address

            InetAddress[] inetArray = Inet6Address.getAllByName(localHost.getHostName());  //Instancia de InetAddress en forma de array
            Inet6Address ipv6Object = getIPv6Addresses(inetArray); //llamada a funcion getIPv6Addresses. Se obtiene un objeto Inet6Address

            String dirLocal = "\nDireccion Local equipo: "+localHost.toString(); //Obtengo los datos del equipo nombre equipo e IP
            String hostName = "\nNombre del host: "+localHost.getHostName(); //Obtengo solo nombre del equipo
            String ipLocal = "\nDirección IP Local: "+localHost.getHostAddress(); //Obtengo IP del equipo con clase InetAddress
            String ip4 = "\nDirección Ipv4 usando Inet4Adress: "+ipV4.getHostAddress(); // Obtengo IP del equipo con clase Inet4Address
            String ipv6 = "\nDirección ipv6: "+ ipv6Object;  //String que incluye la direccion ipv6

            dataFinal = dirLocal+hostName+ipLocal+ip4+ipv6;

        } catch (UnknownHostException ex) {
             ex.getStackTrace();
        }  
        return dataFinal;
    }

    public Inet6Address getIPv6Addresses(InetAddress[] addresses) {  //funcion para extraer un objeto Inet6Address
        for (InetAddress addr : addresses) {    //Recorrido por todos los objetos del array
            if (addr instanceof Inet6Address) {     //Si el objeto es de tipo inet6address se pasa como true
                return (Inet6Address) addr;
            }
        }
        return null;
    }
}
