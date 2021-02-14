package ohtu;

import ohtu.verkkokauppa.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Kauppa kauppa = ctx.getBean(Kauppa.class);
        Viitegeneraattori viitegen = ctx.getBean(Viitegeneraattori.class);
//        Kirjanpito kirjanpito = new Kirjanpito();
        Kirjanpito kirjanpito = ctx.getBean(Kirjanpito.class);
//        Varasto varasto = new Varasto(kirjanpito);
        Varasto varasto = ctx.getBean(Varasto.class);
//        Pankki pankki = new Pankki(kirjanpito);
        Pankki pankki = ctx.getBean(Pankki.class);
//        Kauppa kauppa = new Kauppa(varasto, pankki, viitegen);
        

        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");
        
        ctx.getBean(Kirjanpito.class);
        // kirjanpito
//        for (String tapahtuma : kirjanpito.getTapahtumat()) {
//            System.out.println(tapahtuma);
//        }
    }
}
