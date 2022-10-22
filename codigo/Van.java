import java.util.ArrayList;

public class Van extends Veiculo {
    private static final double IPVA_VAN = 0.03;
    private static final double SEGURO_VAN = 0.03;
    private static final double VISTORIA = 500;
    private static final double ALINHAMENTO = 120;

    Van(double valorVeiculo, double quilometragremMedia) {
        this.valorVeiculo = valorVeiculo;
        this.capacidadeTanque = 60;
        this.quilometragremMedia = quilometragremMedia;
        this.ipva = calcularIpva();
        this.seguro = calcularSeguro();
        autonomiaDiaria = quilometragremMedia * capacidadeTanque;
        ArrayList<Rota> listaRotas;
        kmPercorridos = 0;
    }

    @Override
    protected double calcularIpva() {
        return valorVeiculo * IPVA_VAN;
    }

    @Override
    protected double calcularSeguro() {
        return valorVeiculo * SEGURO_VAN;
    }

    @Override
    protected double calcularOutrosCustos() {
        return (ALINHAMENTO * retornaAcadaXMilQuilometros(10000)) + (VISTORIA * retornaAcadaXMilQuilometros(10000));
    }

}
