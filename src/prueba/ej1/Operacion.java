package prueba.ej1;

import java.io.Serializable;

public class Operacion implements Serializable {
    private int operando1;
    private int operando2;
    private int codigoOperacion;

    public Operacion(int operando1, int operando2, int codigoOperacion) {
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.codigoOperacion = codigoOperacion;
    }

    public int getOperando1() {
        return operando1;
    }

    public void setOperando1(int operando1) {
        this.operando1 = operando1;
    }

    public int getOperando2() {
        return operando2;
    }

    public void setOperando2(int operando2) {
        this.operando2 = operando2;
    }

    public int getCodigoOperacion() {
        return codigoOperacion;
    }

    public void setCodigoOperacion(int codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "operando1=" + operando1 +
                ", operando2=" + operando2 +
                ", codigoOperacion=" + codigoOperacion +
                '}';
    }
}
