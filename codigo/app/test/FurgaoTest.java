package app.test;

import app.veiculo.Furgao;
import app.veiculo.Rota;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FurgaoTest {

    static Furgao furgao;

    static {
        try {
            furgao = new Furgao(1000,"FRNG6X1");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void calculaIpvaCerto() {
        Assertions.assertEquals(30, furgao.getIpva());
    }

    @Test
    public void calculaSeguroCerto() {
        Assertions.assertEquals(30, furgao.calcularSeguro());
    }

    @Test
    public void adicionaRotaCorreta() throws Exception {
        Assertions.assertTrue(furgao.addRota(new Rota("04/11/2011", 400)));
        Assertions.assertFalse(furgao.addRota(new Rota("04/11/2011", 800)));
    }


}

