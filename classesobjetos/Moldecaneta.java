package classesobjetos;

public class Moldecaneta{
    public String modelo;
    public String cor;
    private float ponta;
    protected int carga;
    private boolean tampada;

    public void status(){
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Uma caneta " + this.cor);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Carga: " + this.carga);
        if(this.tampada == true)
            System.out.println("Está tampada?  Sim" );
        else 
            System.out.println("Está tampada?  Não");
    }

    public void rabiscar(){
        if (this.tampada == true)
            System.out.println("ERRO! Não posso rabiscar");
        else 
            System.out.println("Estou Rabiscando");
    }

    protected  void tampar(){
        this.tampada = true;
    }

    protected void destampar(){
        this.tampada = false;
    }
}