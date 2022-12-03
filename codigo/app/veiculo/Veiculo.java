package app.veiculo;

import java.util.ArrayList;

public abstract class Veiculo implements Comparable<Veiculo> {
    //#region Atributos
    protected final String tipo;
    protected final String placa;
    protected double valor;
    protected Tanque tanque;

    public ArrayList<Rota> listaRotas;
    protected ArrayList<Gasto> gastos;

    protected final double taxaIPVA;
    protected final double taxaSeguro;


    //#endregion
    //#region Construtor
    protected Veiculo(
            String tipo,
            String placa,
            double valorVeiculo,
            double capacidadeTanque,
            double taxaIPVA,
            double taxaSeguro,
            Combustivel combustivel,
            ArrayList<Combustivel> tiposCombustivel
    ) throws Exception {
        this.tipo = tipo;
        this.placa = placa;
        this.tanque = new Tanque(capacidadeTanque, combustivel, tiposCombustivel);
        this.valor = valorVeiculo;
        this.gastos = new ArrayList<>();
        listaRotas = new ArrayList<>();
        this.taxaIPVA = taxaIPVA;
        this.taxaSeguro = taxaSeguro;
    }
    //#endregion
    //#region Métodos
    //#region Metodos Protegidos


    /**
     * Método que calcula o IPVA do app.veiculo.Veiculo de acordo com sua Categoria
     *
     * @return Um double referente ao valor calculado do IPVA
     */
    public double getIpva() {
        return taxaIPVA * valor;
    }

    /**
     * Método que calcula o seguro do app.veiculo.Veiculo de acordo com sua Categoria
     *
     * @return Um double referente ao valor calculado do Seguro
     */
    public double calcularSeguro() {
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


    //endregion
    //#region Metodos Públicos

    /**
     * Método que adiciona uma app.veiculo.Rota ao Veículo
     *
     * @param rota A rota a ser adicionada ao app.veiculo.Veiculo
     * @return TRUE se a KM total com a adição da rota for menor que a autonomia diária, False se com a adição da rota, a KM total for maior que a autonomia do Veículo
     */
    public boolean addRota(Rota rota) throws Exception {
        if (getAutonomia() >= rota.getDistancia()) {
            listaRotas.add(rota);
            double valorUtilizado = rota.getDistancia() / this.tanque.getCombustivel().getConsumo();
            this.tanque.utilizarGasolina(valorUtilizado);
            System.out.println(this.tanque.getNivelTanque());
            adicionarGasto("combustivel", (this.tanque.getCombustivel().getPreco() * valorUtilizado));
            return true;
        }
        System.out.println("Gasolina insuficiente favor abastecer o tanque");
        return false;
    }

    private double getAutonomia() {
        return this.tanque.getCombustivel().getConsumo() * this.tanque.getNivelTanque();
    }

    /**
     * Método que calcula a Quilometragem máxima que o veículo percorre com seu tanque.
     *
     * @return Um double referente a Quantidade de Quilometros
     */


    @Override
    public String toString() {
        return tipo + " " + placa + " Gastos totais: " + getGastoTotal() + "Rotas: " + listaRotas.size() + "\n";
    }

    public boolean abastecer(double distanciaRota, Combustivel combustivel, double quantidade) throws Exception {
        double distanciaPossivel = this.tanque.getNivelTanque() * this.tanque.getCombustivel().getConsumo();
        if (distanciaPossivel < distanciaRota) {
            double valorAbastecer = this.tanque.encherTanque(combustivel, quantidade) * this.tanque.getCombustivel().getPreco();
            adicionarGasto("combustivel", valorAbastecer);
        }
        return false;
    }

    public boolean adicionarGasto(String tipoGasto, double valorGasto) throws Exception {
        Gasto gasto = new Gasto(tipoGasto, valorGasto);
        gastos.add(gasto);
        return false;
    }

    public double getGastoTotal() {
        double GastoTotal = 0;
        for (Gasto gasto : gastos) {
            GastoTotal += gasto.getValor();
        }

        return GastoTotal;
    }

    public double getNumRotas() {
        return this.listaRotas.size();
    }

    @Override
    public int compareTo(Veiculo veiculo) {
        if (this.getGastoTotal() > veiculo.getGastoTotal()) {
            return -1;
        }
        if (this.getGastoTotal() < veiculo.getGastoTotal()) {
            return 1;
        }
        return 0;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getPlaca() {
        return this.placa;
    }

    //endregion
    //endregion
}
