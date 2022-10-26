import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FurgaoTest {

    static Furgao furgao = new Furgao(1000,"FRNG6X1", 5);

    @Test
    public void calculaIpvaCerto() {
        assertEquals(30, furgao.getIpva());
    }

    @Test
    public void calculaSeguroCerto() {
        assertEquals(30, furgao.calcularSeguro());
    }

    @Test
    public void adicionaRotaCorreta() {
        assertTrue(furgao.addRota(new Rota("04/11/2011", 400)));
        assertFalse(furgao.addRota(new Rota("04/11/2011", 800)));
    }

    @Test
    public void calculaCustosCerto() {
        double distanciaRota = 300;
        for (int i = 0; i <= 34; i++) {
            furgao.addRota(new Rota("04/11/2011", distanciaRota));
        }
        assertEquals(620, furgao.getOutrosCustos());
    }
}

