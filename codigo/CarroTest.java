import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarroTest {

    static Carro carro = new Carro(1000, 5);

    @Test
    public void calculaIpvaCerto() {
        assertEquals(40, carro.getIpva());
    }

    @Test
    public void calculaSeguroCerto() {
        assertEquals(350, carro.calcularSeguro());
    }

    @Test
    public void adicionaRotaCorreta() {
        assertTrue(carro.addRota(new Rota("04/11/2011", 250)));
        assertFalse(carro.addRota(new Rota("04/11/2011", 500)));
    }

    @Test
    public void calculaCustosCerto() {
        for (int i = 0; i < 40; i++) {
            carro.addRota(new Rota("04/11/2011", 250));
        }
        assertEquals(80, carro.getOutrosCustos());
    }
}
