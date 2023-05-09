package prueba.ej1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class HiloServidor extends Thread{
    private Socket cliente;
    private ObjectInputStream objectInputStream;
    private DataOutputStream dataOutputStream;

    public HiloServidor(Socket cliente) {
        this.cliente = cliente;
        try {
            objectInputStream=new ObjectInputStream(cliente.getInputStream());
            dataOutputStream=new DataOutputStream(cliente.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        Operacion operacion;
        int salir=0;
        while (salir!=9){
            try {
                double resultado=0;

                operacion= (Operacion) objectInputStream.readObject();
                System.out.println("Servidor "+operacion);
                salir=operacion.getCodigoOperacion();
                if(salir!=9){
                    switch(operacion.getCodigoOperacion()){
                        case 1:
                            resultado= operacion.getOperando1()+operacion.getOperando2();
                            break;
                        case 2:
                            resultado= operacion.getOperando1()-operacion.getOperando2();
                            break;

                        case 3:
                            resultado= operacion.getOperando1()*operacion.getOperando2();
                            break;
                        case 4:
                            resultado= operacion.getOperando1()/operacion.getOperando2();
                            break;
                        default:
                            System.out.println("hola");



                    }
                    dataOutputStream.writeDouble(resultado);


                }else{
                    dataOutputStream.close();
                    objectInputStream.close();
                    cliente.close();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
