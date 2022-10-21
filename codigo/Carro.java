import java.util.ArrayList;

public class Carro extends Veiculo {
    private static final double TAXA_IPVA = 0.4;
    private static final double TAXA_SEGURO = 0.05;

    Carro(double valorVeiculo, double quilometragremMedia) {
        this.valorVeiculo = valorVeiculo;
        this.capacidadeTanque = 50;
        this.quilometragremMedia = quilometragremMedia;
        this.ipva = calcularIpva();
        this.seguro = calcularSeguro();
        autonomiaDiaria = quilometragremMedia * capacidadeTanque;
        ArrayList<Rota> listaRotas;
        kmPercorridos = 0;
    }

    @Override
    protected double calcularIpva() {
        return valorVeiculo * TAXA_IPVA;
    }

    @Override
    protected double calcularSeguro() {
        return valorVeiculo * TAXA_SEGURO + 300;
    }

    @Override
    protected double calcularOutrosCustos() {
        return 80 * (calculaDistanciaTotal() % 1000);
    }
}
