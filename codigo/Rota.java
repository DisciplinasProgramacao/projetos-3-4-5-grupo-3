import java.util.Date;

public class Rota {
    
    private Date data;
    private final double distancia;

    Rota(Date data, double distancia) {
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
