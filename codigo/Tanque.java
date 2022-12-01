import java.util.ArrayList;

public class Tanque {
    private double capacidadeMaxTanque;

    private Combustivel combustivel;

    private ArrayList<Combustivel> tiposCombustivel = new ArrayList<>();

    private double nivelTanque;

    public Tanque(double capacidadeTanque, Combustivel combustivel, ArrayList<String> tiposCombustivel) {
        this.capacidadeMaxTanque = capacidadeTanque;
        this.nivelTanque = capacidadeMaxTanque;
        this.tiposCombustivel.addAll(tiposCombustivel);
        tiposCombustivel.forEach(tc -> {
            if(tc.equals(combustivel.getNomeCombustivel()))
                this.combustivel = combustivel;
        });
    }

    public Combustivel getCombustivel() {
        return this.combustivel;
    }

    public void utilizarGasolina(double valorUtilizado) {
        this.nivelTanque -= valorUtilizado;
    }

    public double encherTanque(Combustivel tipoCombustivel, double quantidade) throws Exception {
        //alterar dados string to combustivel

        double qntTotal = 0;
        if(this.tiposCombustivel.contains(tipoCombustivel)){

         } else excecao;


        for( String tc : this.tiposCombustivel) {
            if (tc.equals(tipoCombustivel)) {
                if (this.combustivel.getNomeCombustivel().equals(tipoCombustivel) && this.nivelTanque != 0) {
                    qntTotal = this.capacidadeMaxTanque - this.nivelTanque;
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

            }
        }
        throw new Exception("Tipo não compativel");

    }

    public double getNivelTanque() {
        return this.nivelTanque;
    }

    public double getCapacidadeMaxTanque() {
        return capacidadeMaxTanque;
    }
}
