package app.test;

import app.veiculo.Carro;
import app.veiculo.Rota;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarroTest {

    static Carro carro;

    static {
        try {
            carro = new Carro(1000,"FRNG6X1");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void calculaIpvaCerto() {
        Assertions.assertEquals(40, carro.getIpva());
    }

    @Test
    public void calculaSeguroCerto() {
        Assertions.assertEquals(350, carro.calcularSeguro());
    }

    @Test
    public void adicionaRotaCorreta() {
        Assertions.assertTrue(carro.addRota(new Rota("04/12/2011", 250)));
        Assertions.assertFalse(carro.addRota(new Rota("04/12/2011", 500)));
    }

}
