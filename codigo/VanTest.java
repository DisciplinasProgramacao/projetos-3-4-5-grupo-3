import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VanTest {

    static Van van = new Van(1000,"FRNG6X1", 5);

    @Test
    public void calculaIpvaCerto() {
        assertEquals(30, van.getIpva());
    }

    @Test
    public void calculaSeguroCerto() {
        assertEquals(30, van.calcularSeguro());
    }

    @Test
    public void adicionaRotaCorreta() {
        assertTrue(van.addRota(new Rota("04/11/2011", 300)));
        assertFalse(van.addRota(new Rota("04/11/2011", 500)));
    }

    @Test
    public void calculaCustosCerto() {
        int distanciaRota = 300;
        for (int i = 0; i <= 34; i++) {
            van.addRota(new Rota("4/11/2011", distanciaRota));
        }
        assertEquals(620, van.getOutrosCustos());
    }
}
