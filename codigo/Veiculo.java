import java.util.ArrayList;

public abstract class Veiculo {
    private static int quantidadeVeiculos;
    protected int id;
    protected double valor;
    protected double capacidadeTanque;
    protected double autonomiaDiaria;
    protected ArrayList<Rota> listaRotas = new ArrayList<>();
    protected double quilometragremMedia;
    protected double ipva;
    protected double precoSeguro;
    protected double kmPercorridos;
    protected double custosExtras;


    protected Veiculo(double valorVeiculo, double kmMedia, double capacidadeTanque) {
        aumentaQuantidadeVeiculos();
        this.capacidadeTanque = capacidadeTanque;
        this.valor = valorVeiculo;
        this.quilometragremMedia = kmMedia;
        autonomiaDiaria = quilometragremMedia * capacidadeTanque;
        ArrayList<Rota> listaRotas = new ArrayList<>();
        this.custosExtras = calcularOutrosCustos();
        this.ipva = calcularIpva();
        this.precoSeguro = calcularSeguro();
    }


    protected abstract double calcularIpva();

    protected abstract double calcularSeguro();

    protected abstract double calcularOutrosCustos();

    protected double calculaDistanciaTotal() {
        double distanciaTotal = 0;
        for (Rota rota : this.listaRotas) {
            distanciaTotal += rota.getDistancia();
        }
        calcularOutrosCustos();
        return distanciaTotal;
    }

    public void incluirRota(Rota novaRota) {
        listaRotas.add(novaRota);
        kmPercorridos = calculaDistanciaTotal();
        this.custosExtras = calcularOutrosCustos();
    }

    protected double retornaAcadaXMilQuilometros(double quantidadeKm) {
        return Math.ceil((int) kmPercorridos / quantidadeKm);
    }

    public static void aumentaQuantidadeVeiculos() {
        Veiculo.quantidadeVeiculos++;
    }

    @Override
    public String toString() {
        return this.getClass() + "Tanque: " + capacidadeTanque + "IPVA: " + ipva + "Seguro: " + precoSeguro + "Outros Custos: " + custosExtras;
    }

}
