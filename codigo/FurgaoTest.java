import org.junit.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FurgaoTest {
    
    static Furgao Furgao = new Furgao(1000, 5);

    @Test
    public void calculaIpvaCerto() {
        assertEquals(30, Furgao.getIpva());
    }

    @Test
    public void calculaSeguroCerto() {
        assertEquals(30, Furgao.getPrecoSeguro());
    }

    @Test
    public void adicionaRotaCorreta() {
        assertTrue(Furgao.addRota(new Rota(new Date(), 400)));
        assertFalse(Furgao.addRota(new Rota(new Date(), 800)));
    }

    @Test
    public void calculaCustosCerto() {
        
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));       
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300)); 
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        Furgao.addRota(new Rota(new Date(), 300));
        assertEquals(620,Furgao.getOutrosCustos());
    }
}

