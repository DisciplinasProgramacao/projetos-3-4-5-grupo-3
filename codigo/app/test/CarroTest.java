package app.test;

import app.veiculo.Carro;
import app.veiculo.Rota;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.rmi.UnexpectedException;

import static org.junit.jupiter.api.Assertions.*;

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
    public void adicionaRotaCorreta() throws Exception {
        Assertions.assertTrue(carro.addRota(new Rota("04/12/2011", 250)));
        Assertions.assertFalse(carro.addRota(new Rota("04/12/2011", 500)));
    }

    @Test
    public void gastoInvalido() throws Exception {
        try {
            carro.adicionarGasto("vistoria", 1500);
        } catch(Exception error) {
            Assertions.assertEquals("Tipo de gasto invalido para o carro", error.getMessage());
        }

    }

}
