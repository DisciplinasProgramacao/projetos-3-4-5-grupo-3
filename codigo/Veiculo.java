import java.util.ArrayList;

public abstract class Veiculo {
    
    protected int id;
    protected double valor;
    protected double capacidadeTanque;
    protected final double quilometragremMediaPorLitro;
    protected ArrayList<Rota> listaRotas;
    protected double kmPercorridos;
    protected final double taxaIPVA;
    protected final double taxaSeguro;

    public Veiculo(double valorVeiculo, double kmMedia, double capacidadeTanque, double taxaIPVA, double taxaSeguro) {
        this.capacidadeTanque = capacidadeTanque;
        this.valor = valorVeiculo;
        listaRotas = new ArrayList<>();
        this.quilometragremMediaPorLitro = kmMedia;
        this.taxaIPVA = taxaIPVA;
        this.taxaSeguro = taxaSeguro;
    }

    public boolean addRota(Rota rota){
        if(getAutonomiaDIaria() < rota.getDistancia())
            return false;

        return listaRotas.add(rota);
    }

    protected double getIpva() {
        return taxaIPVA * valor;
    }

    protected double calcularSeguro(){
        return taxaSeguro * valor;
    }

    protected abstract double getOutrosCustos();

    protected double getDistanciaTotal() {
        
        double distanciaTotal = 0;
        
        for (Rota rota : this.listaRotas) {
            distanciaTotal += rota.getDistancia();
        }

        return distanciaTotal;
    }

    public abstract double getPrecoSeguro();

    public double getAutonomiaDIaria() {
        return capacidadeTanque * quilometragremMediaPorLitro;
    }

    public double getKmcorridos(){
        double kmPercorridos = 0;
        for (Rota rota : listaRotas) {
            kmPercorridos += rota.getDistancia();
        }
        return kmPercorridos;
    }
    protected int retornaAcadaXMilQuilometros(double quantidadeKm) {
        return (int) (getKmcorridos() /quantidadeKm);
    }

    @Override
    public String toString() {
        return this.getClass() + "Tanque: " + capacidadeTanque + " IPVA: " + getIpva() + " Seguro: " + getPrecoSeguro() + " Outros Custos: " + getOutrosCustos();
    }

}
