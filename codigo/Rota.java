import java.util.Date;

public class Rota {
    private Date data;


    private double distancia;

    Rota(Date data, double distancia) {
        this.data = data;
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }

}
