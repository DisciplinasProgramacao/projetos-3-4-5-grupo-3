import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaminhaoTest {

    static Caminhao caminhao = new Caminhao(1000,"FRNG6X1", 5);

    @Test
    public void calculaIpvaCerto() {
        assertEquals(10, caminhao.getIpva());
    }

    @Test
    public void calculaSeguroCerto() {
        assertEquals(2020, caminhao.calcularSeguro());
    }

    @Test
    public void adicionaRotaCorreta() {
        assertTrue(caminhao.addRota(new Rota(("04/11/2011"), 1250)));
        assertFalse(caminhao.addRota(new Rota("04/11/2011", 1500)));
    }

    @Test
    public void calculaCustosCerto() {
        double distanciaRota = 1250;
        for (int i = 0; i <= 23; i++) {
            caminhao.addRota(new Rota("04/11/2011", distanciaRota));
        }
        assertEquals(2000, caminhao.getOutrosCustos());
    }
}
