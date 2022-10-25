import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaminhaoTest {
    static Caminhao caminhao = new Caminhao(1000, 5);
    //@BeforeAll
    //public static void inicializa(){
        //caminhao = new Caminhao(1000, 5);
    //}

    @Test
    public void calculaIpvaCerto() {
        assertEquals(10, caminhao.getIpva());
    }

    @Test
    public void calculaSeguroCerto() {
        assertEquals(2020, caminhao.getPrecoSeguro());
    }

    @Test
    public void adicionaRotaCorreta() {
        assertTrue(caminhao.addRota(new Rota(new Date(), 1250)));
        assertFalse(caminhao.addRota(new Rota(new Date(), 1500)));
    }

    @Test
    public void calculaCustosCerto() {
        
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        caminhao.addRota(new Rota(new Date(), 1250));
        assertEquals(2000,caminhao.getOutrosCustos());
    }
}
