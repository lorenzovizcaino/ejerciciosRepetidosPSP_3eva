package boletin2Sockets.ej1;

import boletin2Sockets.ej1.modelo.Profesor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String host="localhost";
        int puerto=6000;
        Scanner entrada=new Scanner(System.in);
        String idProfesor="";
        DataOutputStream dataOutputStream = null;
        ObjectInputStream objectInputStream = null;
        Profesor profesor;
        try {
            Socket cliente=new Socket(host,puerto);
            while(!idProfesor.equalsIgnoreCase("*")){
                System.out.println("Id del profesor a consultar");
                idProfesor= entrada.nextLine();
                dataOutputStream=new DataOutputStream(cliente.getOutputStream());
                dataOutputStream.writeUTF(idProfesor);
                if(!idProfesor.equalsIgnoreCase("*")){
                    objectInputStream=new ObjectInputStream(cliente.getInputStream());
                    profesor= (Profesor) objectInputStream.readObject();
                    System.out.println(profesor.toString());


                }else{
                    System.out.println("El cliente se va a cerrar...");

                }



            }
            dataOutputStream.close();
            objectInputStream.close();
            cliente.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
