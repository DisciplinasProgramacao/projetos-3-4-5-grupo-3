package app.test;

import app.veiculo.Caminhao;
import app.veiculo.Rota;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaminhaoTest {

    static Caminhao caminhao;

    static {
        try {
            caminhao = new Caminhao(1000,"FRNG6X1");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void calculaIpvaCerto() {
        Assertions.assertEquals(10, caminhao.getIpva());
    }

    @Test
    public void calculaSeguroCerto() {
        Assertions.assertEquals(2020, caminhao.calcularSeguro());
    }

    @Test
    public void adicionaRotaCorreta() throws Exception {
        Assertions.assertTrue(caminhao.addRota(new Rota(("04/11/2011"), 1250)));
        Assertions.assertFalse(caminhao.addRota(new Rota("04/11/2011", 150000)));
    }

    @Test
    public void gastoInvalido() throws Exception {
        try {
            caminhao.adicionarGasto("vistoria", 1500);
        } catch(Exception error) {
            Assertions.assertEquals("Tipo de gasto invalido para o caminhao", error.getMessage());
        }

    }

}
