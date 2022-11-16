import java.text.BreakIterator;

public enum Combustivel {
   
    GASOLINA,
    ETANOL,
    DIESEL;

    private double consumo;


    public double consMedio(Combustivel combustivel){
           switch (combustivel){

            case GASOLINA:
            consumo = 12;

            case ETANOL:
            consumo = 8;
            
            case DIESEL:
            consumo = 3.5;
        }
        return consumo;
    }

    public double precoEncherTanque(Veiculo capacidaTanqVeiculo, Combustivel combustivel){
        switch (combustivel){

            case GASOLINA:
            consumo = 4.8;

            case ETANOL:
            consumo = 3.65;
            
            case DIESEL:
            consumo = 6.65;
        }
        return (capacidaTanqVeiculo * consumo);
    }
}
