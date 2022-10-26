import java.util.Date;

public class Rota {
    //#region Atributos
    private Date data;
    private final double distancia;

    //#endregion
    //#region Construtor
    Rota(String data, double distancia) {
        String[] vetorData = data.split("/");
        this.data = new Date(Integer.parseInt(vetorData[2]), Integer.parseInt(vetorData[1]), Integer.parseInt(vetorData[0]));
        this.distancia = distancia;
    }

    //endregion
    public double getDistancia() {
        return distancia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ("Data: " + data.getDay() + "/" + data.getMonth() + "/" + data.getYear()+" Distancia: " +distancia);
    }

}
