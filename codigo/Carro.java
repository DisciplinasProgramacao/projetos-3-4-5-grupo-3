import java.util.ArrayList;

public class Carro extends Veiculo {
    private static final double IPVA_CARRO = 0.4;
    private static final double TAXA_SEGURO = 0.05;

    Carro(double valorVeiculo, double quilometragremMedia) {
        idVeiculo++;
        this.valorVeiculo = valorVeiculo;
        this.capacidadeTanque = 50;
        this.quilometragremMediaPorLitro = quilometragremMedia;
        this.ipva = calcularIpva();
        this.seguro = calcularSeguro();
        autonomiaDiaria = quilometragremMedia * capacidadeTanque;
        ArrayList<Rota> listaRotas;
        kmPercorridos = 0;
    }

    @Override
    protected double calcularIpva() {
        return valorVeiculo * IPVA_CARRO;
    }

    @Override
    protected double calcularSeguro() {
        return valorVeiculo * TAXA_SEGURO + 300;
    }

    @Override
    protected double getOutrosCustos() {
        return 80 * (calculaDistanciaTotal() % 1000);
    }
}
