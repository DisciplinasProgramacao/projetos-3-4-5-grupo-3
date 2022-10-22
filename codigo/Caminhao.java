import java.util.ArrayList;

public class Caminhao extends Veiculo {
    private static final double IPVA_CAMINHAO = 0.01;
    private static final double SEGURO_CAMINHAO = 0.02;
    private static final double MANUTENCAO = 1000;
    private static final double VISTORIA = 1000;

    Caminhao(
            double valorVeiculo, double quilometragremMedia) {
        this.valorVeiculo = valorVeiculo;
        this.capacidadeTanque = 250;
        this.quilometragremMedia = quilometragremMedia;
        this.ipva = calcularIpva();
        this.seguro = calcularSeguro();
        autonomiaDiaria = quilometragremMedia * capacidadeTanque;
        ArrayList<Rota> listaRotas;
        kmPercorridos = 0;
    }

    @Override
    protected double calcularIpva() {
        return 0;
    }

    @Override
    protected double calcularSeguro() {
        return 0;
    }

    @Override
    protected double calcularOutrosCustos() {
        return MANUTENCAO* retornaAcadaXMilQuilometros(20000) + VISTORIA *retornaAcadaXMilQuilometros(30000);
    }

}
