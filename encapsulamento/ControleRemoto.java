package encapsulamento;

public class ControleRemoto implements Controlador {
    //Atributos:
    private int volume;
    private boolean ligado;
    private boolean tocando;

    //Constructor:
    public ControleRemoto() {
        this.volume = 50;
        this.ligado = false;
        this.tocando = false;
    }


    //Métodos acessores e modificadores:
    private int getVolume () { return this.volume; }
    private void setVolume (int v) { this.volume = v; }

    private boolean getLigado () { return this.ligado; }
    private void setLigado (boolean l) { this.ligado = l; }

    private boolean getTocando () { return this.tocando; }
    private void setTocando (boolean t) { this.tocando = t; }

    public void ligar() {
        if (!this.ligado)
            this.setLigado(true);
        else
            System.out.println("Já está ligado");
    }
    public void desligar() {
        if (this.ligado)
            this.setLigado(false);
        else
            System.out.println("Já está desligado");
    }


    //Métodos Abstratos

    @Override
    public void abrirMenu() {
        if (!this.getLigado()){
            System.out.println("Não e possivel mostrar o menu, com a tv desligada.");
        } else {
            System.out.println("A TV está: Ligada");
            System.out.println("Está Tocando? "+this.getTocando());
            System.out.print("Volume: "+this.getVolume()+" ");
                for (int i = 10; i <= this.getVolume(); i += 10)
                    System.out.print("|");
        }
        System.out.println();
    }
    @Override
    public void fecharMenu() {
        System.out.println("Fechando Menu...");
    }

    @Override
    public void maisVolume() {
        if (this.getLigado()){
            this.setVolume(this.getVolume() + 10);
        }
    }
    @Override
    public void menosVolume() {
        if (this.getLigado()){
            this.setVolume(this.getVolume() - 10);
        }
    }

    @Override
    public void ligarMudo() {
        if (this.getLigado() && this.getVolume() > 0)
            this.setVolume(0);
    }

    @Override
    public void desligarMudo() {
        if (this.getLigado() && this.getVolume() == 0)
            this.setVolume(50);
    }

    @Override
    public void play() {
        if (this.getLigado() && !this.getTocando())
            setTocando(true);
    }

    @Override
    public void pause() {
        if (this.getLigado() && this.getTocando())
            setTocando(false);
    }
}
