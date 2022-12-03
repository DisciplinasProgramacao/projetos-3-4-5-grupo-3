package app.veiculo;

import java.util.Date;
import java.util.Objects;

public class Rota {


    //#region Atributos
    private final Date data;
    private final double distancia;

    //#endregion
    //#region Construtor
    public Rota(String data, double distancia) {
        String[] vetorData = data.split("/");
        this.data = new Date(Integer.parseInt(vetorData[2]), Integer.parseInt(vetorData[1]), Integer.parseInt(vetorData[0]));
        this.distancia = distancia;
    }

    //endregion
    public double getDistancia() {
        return distancia;
    }


    @Override
    public String toString() {
        return ("Data: " + data.getDay() + "/" + data.getMonth() + "/" + data.getYear() + " Distancia: " + distancia);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        final Rota obj = (Rota) o;
        return Objects.equals(this.data, obj.data);
    }
    public Date getData() {
        return data;
    }
}
