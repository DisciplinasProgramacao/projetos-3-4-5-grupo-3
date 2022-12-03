package app.veiculo;

import java.util.ArrayList;

public class Tanque {
    //region #Attributes
    private double capacidadeMaxTanque;

    private Combustivel combustivel;

    private ArrayList<Combustivel> tiposCombustivel = new ArrayList<>();

    private double nivelTanque;

    /* Construtor que tem como parametro a capacidade atual do tanque, o combustivel a ser abastecido
    e os tipos de combustiveis possíveis de abastecimento
     */

    public Tanque(double capacidadeTanque, Combustivel combustivel, ArrayList<Combustivel> tiposCombustivel) throws Exception {
        this.capacidadeMaxTanque = capacidadeTanque;
        this.nivelTanque = capacidadeMaxTanque;
        this.tiposCombustivel.addAll(tiposCombustivel);
        this.combustivel = combustivel;
        this.encherTanque(combustivel, capacidadeTanque);
    }

    public Combustivel getCombustivel() {
        return this.combustivel;
    }

    /* método para calcular o nível atual de combustivel no tanque do app.veiculo */
    public void utilizarGasolina(double valorUtilizado) {
        this.nivelTanque -= valorUtilizado;
    }

    public double encherTanque(Combustivel combustivel, double quantidade) throws Exception {
        double qntTotal = this.capacidadeMaxTanque - this.nivelTanque;
        if(this.tiposCombustivel.contains(combustivel)){
            if (this.combustivel.equals(combustivel) && this.nivelTanque != 0) {
                if (qntTotal < quantidade) {
                    this.nivelTanque += qntTotal;
                    return qntTotal;
                } else {
                    this.nivelTanque += quantidade;
                    return quantidade;
                }
            } else {
                this.nivelTanque = this.capacidadeMaxTanque;
                return this.capacidadeMaxTanque;
            }

        } else {
            throw new Exception("Tipo não compativel");
        }
    }

    //get para nivel do tanque e capacidade máxima do tanque
    public double getNivelTanque() {
        return this.nivelTanque;
    }

    public double getCapacidadeMaxTanque() {
        return capacidadeMaxTanque;
    }
}
