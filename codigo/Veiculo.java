import java.util.ArrayList;

public abstract class Veiculo {
    protected static double idVeiculo = 0;
    protected double valorVeiculo;
    protected double capacidadeTanque;
    protected double autonomiaDiaria;
    protected ArrayList<Rota> listaRotas;
    protected double quilometragremMedia;
    protected double ipva;
    protected double seguro;
    protected double kmPercorridos;
    protected double custosExtras;

    protected abstract double calcularIpva();

    protected abstract double calcularSeguro();

    protected abstract double calcularOutrosCustos();

    protected double calculaDistanciaTotal() {
        double distanciaTotal = 0;
        for (Rota rota : this.listaRotas) {
            distanciaTotal += rota.getDistancia();
        }
        return distanciaTotal;
    }

    public void incluirRota(Rota novaRota) {
        listaRotas.add(novaRota);
        kmPercorridos = calculaDistanciaTotal();
    }

    protected double retornaAcadaXMilQuilometros(double quantidadeKm) {
        return kmPercorridos % quantidadeKm;
    }

    @Override
    public String toString() {
        return this.getClass() + "Tanque: " + capacidadeTanque + "IPVA: " + ipva + "Seguro: " + seguro + "Outros Custos: " + custosExtras;
    }
}
