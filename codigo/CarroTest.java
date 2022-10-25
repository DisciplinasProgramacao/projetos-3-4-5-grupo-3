import org.junit.Test;
import java.util.Date;

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
        assertEquals(350, carro.getPrecoSeguro());
    }

    @Test
    public void adicionaRotaCorreta() {
        assertTrue(carro.addRota(new Rota(new Date(), 250)));
        assertFalse(carro.addRota(new Rota(new Date(), 500)));
    }

    @Test
    public void calculaCustosCerto() {
        
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));
        carro.addRota(new Rota(new Date(), 250));

        assertEquals(80,carro.getOutrosCustos());
    }
}
