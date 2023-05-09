package prueba.ej1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
Realiza un programa cliente-servidor que implemente una calculadora (suma,
resta, multiplicación y división). El servidor ha de poder atender a múltiples
clientes simultáneamente.

 El programa servidor creará un stream socket y aguardará conexiones.

 El programa cliente recogerá de teclado la operación a realizar y los operandos,
y se los enviará al servidor para que la resuelva. A continuación, leerá la
respuesta del servidor y la mostrará por pantalla.

 */
public class ej1Cliente {
    public static void main(String[] args) throws IOException {
        String host="localhost";
        int puerto=6000;
        Socket cliente=new Socket(host, puerto);
        Operacion operacion;
        Scanner entrada=new Scanner(System.in);
        int signo=0;
        int op1, op2;
        double resultado;
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(cliente.getOutputStream());;
        DataInputStream dataInputStream=new DataInputStream(cliente.getInputStream());;

        while(signo!=9){
            System.out.println("Que operacion vamos a realizar:" +
                    "\n1.- SUMAR" +
                    "\n2.- RESTAR" +
                    "\n3.- MULTIPLICAR" +
                    "\n4.- DIVIDIR" +
                    "\n9.- Fin del cliente");
            signo=entrada.nextInt();
            if(signo!=9){
                System.out.println("Operando numero 1:");
                op1= entrada.nextInt();
                System.out.println("Operando numero 2:");
                op2= entrada.nextInt();
                operacion=new Operacion(op1,op2,signo);
                System.out.println(operacion);

                objectOutputStream.writeObject(operacion);


                resultado=dataInputStream.readDouble();
                System.out.println("El resultado de la operacion es: "+resultado);

            }else{
                operacion=new Operacion(0,0,signo);
                System.out.println(operacion);

                objectOutputStream.writeObject(operacion);
            }


        }
        cliente.close();

    }
}
