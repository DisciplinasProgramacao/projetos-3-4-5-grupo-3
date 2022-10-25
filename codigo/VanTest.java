import org.junit.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VanTest {
    
    static Van Van = new Van(1000, 5);

    @Test
    public void calculaIpvaCerto() {
        assertEquals(30, Van.getIpva());
    }

    @Test
    public void calculaSeguroCerto() {
        assertEquals(30, Van.getPrecoSeguro());
    }

    @Test
    public void adicionaRotaCorreta() {
        assertTrue(Van.addRota(new Rota(new Date(), 300)));
        assertFalse(Van.addRota(new Rota(new Date(), 500)));
    }

    @Test
    public void calculaCustosCerto() {
        
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));       
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300)); 
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        Van.addRota(new Rota(new Date(), 300));
        assertEquals(620,Van.getOutrosCustos());
    }
}
