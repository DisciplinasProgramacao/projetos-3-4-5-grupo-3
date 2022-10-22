import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Veiculo {
    protected double valorVeiculo;
    protected double capacidadeTanque;

    protected double autonomiaDiaria;
    protected ArrayList<Rota> listaRotas;
    protected double quilometragremMedia;
    protected double ipva;
    protected double seguro;
    protected double kmPercorridos;

    protected abstract double calcularIpva();

    protected abstract double calcularSeguro();

    protected abstract double calcularOutrosCustos();

    public double calculaDistanciaTotal() {
        double distanciaTotal = 0;
        for (Rota rota : listaRotas) {
            distanciaTotal += rota.getDistancia();
        }
        return distanciaTotal;
    }

    public void incluirRota(Rota novaRota) {
        listaRotas.add(novaRota);
    }


}
