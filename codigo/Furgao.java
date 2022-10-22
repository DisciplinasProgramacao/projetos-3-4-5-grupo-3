import java.util.ArrayList;

public class Furgao extends Veiculo {
    private static final double IPVA_FURGAO = 0.03;
    private static final double SEGURO_FURGAO = 0.03;
    private static final double ALINHAMENTO_FURGAO = 120;
    private static final double VISTORIA_FURGAO = 500;

    Furgao(
            double valorVeiculo, double quilometragremMedia) {
        this.valorVeiculo = valorVeiculo;
        this.capacidadeTanque = 80;
        this.quilometragremMedia = quilometragremMedia;
        this.ipva = calcularIpva();
        this.seguro = calcularSeguro();
        autonomiaDiaria = quilometragremMedia * capacidadeTanque;
        ArrayList<Rota> listaRotas;
        kmPercorridos = 0;
    }

    @Override
    protected double calcularIpva() {
        return valorVeiculo * IPVA_FURGAO;
    }

    @Override
    protected double calcularSeguro() {
        return valorVeiculo * SEGURO_FURGAO;
    }

    @Override
    protected double calcularOutrosCustos() {
        return (ALINHAMENTO_FURGAO * retornaAcadaXMilQuilometros(10000)) + (VISTORIA_FURGAO + retornaAcadaXMilQuilometros(10000));
    }
}
