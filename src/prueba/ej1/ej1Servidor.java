package prueba.ej1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
Realiza un programa cliente-servidor que implemente una calculadora (suma,
resta, multiplicación y división). El servidor ha de poder atender a múltiples
clientes simultáneamente.

 El programa servidor creará un stream socket y aguardará conexiones.

 El programa cliente recogerá de teclado la operación a realizar y los operandos,
y se los enviará al servidor para que la resuelva. A continuación, leerá la
respuesta del servidor y la mostrará por pantalla.

 */
public class ej1Servidor {
    public static void main(String[] args) throws IOException {
        int puerto=6000;
        ServerSocket servidor=new ServerSocket(puerto);
        while(true){
            Socket cliente;
            cliente=servidor.accept();
            HiloServidor hilo=new HiloServidor(cliente);
            hilo.start();

        }
    }

}
