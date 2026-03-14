public class ContaBanco {
    public    int     numConta;
    protected String  tipo;
    private   String  dono;
    private   float   saldo;
    private   boolean status;

    // pagar mensalidade cc 12 cp 20

    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
    }

    public int getNumConta () { return this.numConta; }
    public void setNumConta (int numConta) { this.numConta = numConta;}

    public String getTipo () { return this.tipo; }
    public void setTipo (String tipo) { this.tipo = tipo;}

    public String getDono () { return this.dono; }
    public void setDono (String dono) { this.dono = dono; }

    public float getSaldo () { return this.saldo; }
    public void setSaldo (float saldo, int option) { 
        if (option==1)
            this.saldo += saldo;
        else
            this.saldo -= saldo;
    }

    public boolean getStatus () { return this.status; }
    public void setStatus (boolean status) { this.status = status; }

    public void abrirConta() {
        this.setStatus(true);

        switch(tipo) {
            case "cc" -> {
                System.out.printf("Parabéns %s, por você ter criado uma conta corrente %nrecebeu R$ 50.00  como bônus%n%n", dono);
                this.saldo += 50f;
            }
            case "cp" -> {
                System.out.printf("Parabéns %s, por você ter criado uma conta corrente %nrecebeu R$ 150.00 como bônus%n%n", dono);
                this.saldo += 150f;
            }
        }

    }
    public void fecharConta() {
        if (this.saldo < 0){
            System.out.printf("Não e possivel fechar a sua conta%nseu Saldo está negativo: %.2f", saldo);
        } else {
            this.setStatus(false);
        }
    }

    public void depositar(float deposito) {
        if (this.status == true){
            this.saldo += deposito;
            System.out.printf("Deposito de: %.2f, foi realizado com sucesso%nSaldo atual: %.2f", deposito, this.saldo);
        } else {
            System.out.printf("Não foi possivel depositar em sua conta%n Ela está fechada");
        }
    }

    public void sacar(float saque) {
        if (this.status && this.saldo > 0) {
            if(this.saldo < saque){
                System.out.println("Saldo insuficiente");
                 System.out.printf("Saldo atual: %.2f%nValor a ser sacado: %.2f", this.saldo, saque);
            } else {
                this.setSaldo(saque, 0);
                System.out.printf("Valor de: %.2f foi sacado com sucesso%nSaldo atual: %.2f", saque, this.saldo);
            }
        } else {
            System.out.println("Não foi possível sacar — conta fechada ou sem saldo");
        }
    }
    public void pagarMensal() {}

    public void status() {
        System.out.printf("Tipo   da conta: %S%n", this.tipo);
        System.out.printf("Dono   da conta: %s%n", this.dono);
        System.out.printf("Saldo  da conta: %.2f%n", this.saldo);
        System.out.printf("Status da conta: %B%n", this.status);
    }
}
// conta corrente 50 | conta poupança 150