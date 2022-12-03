import java.util.ArrayList;

public class Tanque {
    private double capacidadeMaxTanque;

    private Combustivel combustivel;

    private ArrayList<Combustivel> tiposCombustivel = new ArrayList<>();

    private double nivelTanque;

    public Tanque(double capacidadeTanque, Combustivel combustivel, ArrayList<Combustivel> tiposCombustivel) throws Exception {
        this.capacidadeMaxTanque = capacidadeTanque;
        this.tiposCombustivel.addAll(tiposCombustivel);
        this.encherTanque(combustivel, capacidadeTanque);
    }

    public Combustivel getCombustivel() {
        return this.combustivel;
    }

    public void utilizarGasolina(double valorUtilizado) {
        this.nivelTanque -= valorUtilizado;
    }

    public double encherTanque(Combustivel tipoCombustivel, double quantidade) throws Exception {
        double qntTotal = this.capacidadeMaxTanque - this.nivelTanque;

        if(this.tiposCombustivel.contains(tipoCombustivel)) {
            if (this.combustivel.equals(tipoCombustivel) && this.nivelTanque != 0) {
                if (qntTotal < quantidade) {
                    this.nivelTanque += qntTotal;
                    return qntTotal;
                } else {
                    this.nivelTanque += quantidade;
                    return quantidade;
                }
            } else {
                this.nivelTanque += quantidade;
                return quantidade;
            }
        } else {
            throw new Exception("Tipo não compativel");
        }
    }

    public double getNivelTanque() {
        return this.nivelTanque;
    }

    public double getCapacidadeMaxTanque() {
        return capacidadeMaxTanque;
    }
}
