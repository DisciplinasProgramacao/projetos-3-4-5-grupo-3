import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FrotaTest {
    static Frota frota = new Frota();

    @Test
    void procurar() throws Exception {
        frota.insereNaFrota("Carro;FRNG6X1;1000;100000");
        frota.insereNaFrota("Caminhao;FRNG6X2;1000;100000");
        frota.insereNaFrota("Furgao;FRNG6X3;1000;100000");
        frota.insereNaFrota("Van;FRNG6X4;1000;100000");

        Assertions.assertNotEquals(null, frota.procurar("FRNG6X1"));
    }

    @Test
    void maisRotas() throws Exception {
        frota.insereNaFrota("Carro;FRNG6X1;1000;100000");
        frota.insereNaFrota("Caminhao;FRNG6X2;1000;100000");
        frota.insereNaFrota("Furgao;FRNG6X3;1000;100000");
        frota.insereNaFrota("Van;FRNG6X4;1000;100000");

        ArrayList<Veiculo> listaResposta = new ArrayList<>();
        listaResposta.add(frota.procurar("FRNG6X2"));
        listaResposta.add(frota.procurar("FRNG6X3"));
        listaResposta.add(frota.procurar("FRNG6X4"));


        frota.listaVeiculos.forEach(veiculo -> {
            switch (veiculo.tipo) {
                case "Carro" -> veiculo.listaRotas.add(new Rota("01/01/2022", 100));
                case "Furgao" -> {
                    veiculo.listaRotas.add(new Rota("01/02/2022", 95));
                    veiculo.listaRotas.add(new Rota("01/03/2022", 95));
                }
                case "Van" -> {
                    veiculo.listaRotas.add(new Rota("01/03/2022", 95));
                    veiculo.listaRotas.add(new Rota("01/03/2022", 95));
                }
                case "Caminhao" -> {{
                    veiculo.listaRotas.add(new Rota("01/02/2022", 85));
                    veiculo.listaRotas.add(new Rota("01/03/2022", 95));
                }}
            }
        });

        Assertions.assertEquals(listaResposta, frota.maisRotas());
    }

    @Test
    void custoDecrescente() throws Exception {
        frota.insereNaFrota("Carro;FRNG6X1;1000;100000");
        frota.insereNaFrota("Caminhao;FRNG6X2;1000;100000");
        frota.insereNaFrota("Furgao;FRNG6X3;1000;100000");
        frota.insereNaFrota("Van;FRNG6X4;1000;100000");

        ArrayList<Veiculo> listaResposta = new ArrayList<>();
        listaResposta.add(frota.procurar("FRNG6X2"));
        listaResposta.add(frota.procurar("FRNG6X3"));
        listaResposta.add(frota.procurar("FRNG6X4"));


        frota.listaVeiculos.forEach(veiculo -> {
            switch (veiculo.tipo) {
                case "Carro" -> veiculo.listaRotas.add(new Rota("01/01/2022", 100));
                case "Furgao" -> {
                    veiculo.listaRotas.add(new Rota("01/02/2022", 95));
                    veiculo.listaRotas.add(new Rota("01/03/2022", 95));
                }
                case "Van" -> {
                    veiculo.listaRotas.add(new Rota("01/03/2022", 95));
                    veiculo.listaRotas.add(new Rota("01/03/2022", 95));
                }
                case "Caminhao" -> {{
                    veiculo.listaRotas.add(new Rota("01/02/2022", 85));
                    veiculo.listaRotas.add(new Rota("01/03/2022", 95));
                }}
            }
        });

        Assertions.assertEquals(listaResposta, frota.maisRotas());
    }

    @Test
    void rotasPorData() throws Exception {
        frota.insereNaFrota("Carro;FRNG6X1;1000;100000");
        frota.insereNaFrota("Caminhao;FRNG6X2;1000;100000");
        frota.insereNaFrota("Furgao;FRNG6X3;1000;100000");
        frota.insereNaFrota("Van;FRNG6X4;1000;100000");

        ArrayList<Veiculo> listaResposta = new ArrayList<>();
        listaResposta.add(frota.procurar("FRNG6X2"));
        listaResposta.add(frota.procurar("FRNG6X3"));
        listaResposta.add(frota.procurar("FRNG6X4"));


        frota.listaVeiculos.forEach(veiculo -> {
            switch (veiculo.tipo) {
                case "Carro" -> veiculo.listaRotas.add(new Rota("01/01/2022", 100));
                case "Furgao" -> {
                    veiculo.listaRotas.add(new Rota("01/02/2022", 95));
                    veiculo.listaRotas.add(new Rota("01/03/2022", 95));
                }
                case "Van" -> {
                    veiculo.listaRotas.add(new Rota("01/03/2022", 95));
                    veiculo.listaRotas.add(new Rota("01/03/2022", 95));
                }
                case "Caminhao" -> {{
                    veiculo.listaRotas.add(new Rota("01/02/2022", 85));
                    veiculo.listaRotas.add(new Rota("01/03/2022", 95));
                }}
            }
        });

        Calendar c = Calendar.getInstance();
        c.set(2022, Calendar.MARCH, 1);
        Date data = c.getTime();

        //Formata a data
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        frota.rotasPorData(dataFormat.parse("01/03/2022"));
    }


    @Test
    void test() throws Exception {
        frota.insereNaFrota("carro;FRNG6X1;1000;100000");

        frota.listaVeiculos.forEach(System.out::println);
    }
}
