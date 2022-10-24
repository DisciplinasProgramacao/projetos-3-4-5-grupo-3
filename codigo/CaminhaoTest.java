import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaminhaoTest {
    Caminhao caminhao = new Caminhao(1000, 5);

    @Test
    public void calculaIpvaCerto() {
        assertEquals(10, caminhao.calcularIpva());
    }

    @Test
    public void calculaSeguroCerto() {
        assertEquals(2020, caminhao.getSeguro());
    }

    @Test
    public void adicionaRotaCorreta() {
        caminhao.incluirRota(new Rota(new Date(), 20000));
        assertEquals(20000, caminhao.kmPercorridos);
    }

    @Test
    public void calculaCustosCerto() {
        caminhao.incluirRota(new Rota(new Date(), 30000));
        caminhao.incluirRota(new Rota(new Date(), 10000));
        assertEquals(5000,caminhao.custosExtras);
    }
}
