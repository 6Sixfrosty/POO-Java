package classesobjetos;

public class Caneta {
    public static void main(String[] args) {
        Moldecaneta c1 = new Moldecaneta();
        c1.modelo = "BIC Cristal";
        c1.cor = "Azul";
        //c1.ponta = 0.5f;
        c1.carga = 80;
        c1.destampar();
        c1.status();
        c1.rabiscar();
    }
}
