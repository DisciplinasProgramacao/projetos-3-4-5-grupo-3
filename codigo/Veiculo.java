import java.util.ArrayList;

public abstract class Veiculo {
    //#region Atributos
    protected final String tipo;
    protected final String placa;
    protected double valor;
    protected double capacidadeTanque;
    protected double tanque;
    protected final double quilometragremMediaPorLitro;
    protected final double autonomia;
    protected ArrayList<Rota> listaRotas;
    protected ArrayList<Gasto> gastos;
    protected final double taxaIPVA;
    protected final double taxaSeguro;

    protected final Combustivel combustivel;

    //#endregion
    //#region Construtor
    protected Veiculo(String tipo, String placa, double valorVeiculo, double kmMedia, double capacidadeTanque, double taxaIPVA, double taxaSeguro) {
        this.tipo = tipo;
        this.placa = placa;
        this.capacidadeTanque = capacidadeTanque;
        this.valor = valorVeiculo;
        listaRotas = new ArrayList<>();
        this.quilometragremMediaPorLitro = kmMedia;
        this.autonomia = quilometragremMediaPorLitro * this.capacidadeTanque;
        this.taxaIPVA = taxaIPVA;
        this.taxaSeguro = taxaSeguro;
    }
    //#endregion
    //#region Métodos
    //#region Metodos Protegidos

    /**
     * Método que calcula o valor dos "Outros Custos" de acordo com os atributos do Veiculo
     *
     * @return Um double referente ao custo calculado
     */
    protected abstract double getOutrosCustos();

    /**
     * Método que calcula o IPVA do Veiculo de acordo com sua Categoria
     *
     * @return Um double referente ao valor calculado do IPVA
     */
    protected double getIpva() {
        return taxaIPVA * valor;
    }

    /**
     * Método que calcula o seguro do Veiculo de acordo com sua Categoria
     *
     * @return Um double referente ao valor calculado do Seguro
     */
    protected double calcularSeguro() {
        return taxaSeguro * valor;
    }

    /**
     * Método que soma as distâncias de todas as rotas, e retorna a distância total
     *
     * @return Um double referente a Quilometragem total percorrida pelo veículo.
     */
    protected double getDistanciaTotal() {
        double distanciaTotal = 0;

        for (Rota rota : this.listaRotas) {
            distanciaTotal += rota.getDistancia();
        }
        return distanciaTotal;
    }

    /**
     * Método utilizado como ferramenta para facilitar o cálculo da Quantidade de serviços serão prestados diante de uma quilometragem total.
     *
     * @param quantidadeKm Quantidade de KM necessária para fazer um serviço
     * @return Um inteiro referente a quantidade de serviços que serão prestados
     */
    protected int quantidadeServicoKMTotal(double quantidadeKm) {
        return (int) (getDistanciaTotal() / quantidadeKm);
    }

    //endregion
    //#region Metodos Públicos

    /**
     * Método que adiciona uma Rota ao Veículo
     *
     * @param rota A rota a ser adicionada ao Veiculo
     * @return TRUE se a KM total com a adição da rota for menor que a autonomia diária, False se com a adição da rota, a KM total for maior que a autonomia do Veículo
     */
    public boolean addRota(Rota rota) {
        if (autonomia >= (rota.getDistancia())) {
            listaRotas.add(rota);
            return true;
        } else return false;
    }

    /**
     * Método que calcula a Quilometragem máxima que o veículo percorre com seu tanque.
     *
     * @return Um double referente a Quantidade de Quilometros
     */


    @Override
    public String toString() {
        return tipo + " Tanque: " + capacidadeTanque + " IPVA: " + getIpva() + " Seguro: " + calcularSeguro() + " Outros Custos: " + getOutrosCustos();
    }

    public void abastecer(Integer distancia) {
        Integer distanciaPossivel = combustivel.consumo/this.tanque;
        if(distancia > distanciaPossivel)
            return;
        Double qntCombustivel = capacidadeTanque - this.tanque;
        Gasto gasolina = new Gasto(qntCombustivel, "combustivel");
        gastos.add(gasolina);
        this.tanque = capacidadeTanque;
    }

    //endregion
    //endregion
}
