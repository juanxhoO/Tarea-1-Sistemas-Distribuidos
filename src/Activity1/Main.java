package Activity1;

//@author HenryR
import java.net.SocketException;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws SocketException {
        DireccionIP ip = new DireccionIP();
        MacAddress mac = new MacAddress();

        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");

        String dataLocal = ip.direccionLocal();

        String macAddress = mac.obtenerMac();

        JOptionPane.showMessageDialog(null,
        "\n- Datos del equipo de: " + nombre + 
        "\n-------------------------------------------------------------------------------"
                + dataLocal + 
        "\n-------------------------------------------------------------------------------" 
                + macAddress);
    }
}
