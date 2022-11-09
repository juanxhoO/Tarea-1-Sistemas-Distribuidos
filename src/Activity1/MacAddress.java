package Activity1;

import java.net.*;

//@author HenryR
public class MacAddress {
    public String obtenerMac() throws SocketException {
        // Clase para obtener la interfaz de la red
        StringBuilder cadenaMac = new StringBuilder();
        String macFinal = "";

        try {

            InetAddress ipLocalHost = InetAddress.getLocalHost();
            NetworkInterface red = NetworkInterface.getByInetAddress(ipLocalHost); // Obteniendo interfaz de red

            byte[] mac = red.getHardwareAddress(); // obtención de la dirección mac en bytes

            // Recorrido del array de Bytes y transformación en hexadecimal para cada
            // segmento

            for (int i = 0; i < mac.length; i++) {

                // Añadiendo caracteres transformados al objeto de StringBuild
                cadenaMac.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }

            macFinal = "\nMAC del equipo: " + cadenaMac.toString();

        } catch (UnknownHostException excepcion) {
            excepcion.getStackTrace();
        }

        return macFinal;
    }
}
