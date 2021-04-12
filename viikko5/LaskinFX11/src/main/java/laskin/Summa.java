
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
    private int viimeinen;
    
    public Summa(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, plus, miinus, nollaa, undo, sovellus);
        this.viimeinen = 0;
    }

    @Override
    public void suorita() {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            return;
        }
        this.viimeinen = sovellus.tulos();
        sovellus.plus(arvo);
        int tulos = sovellus.tulos();
        tuloskentta.setText(String.valueOf(tulos));
        syotekentta.setText("");
        
        if (tulos != 0) {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
        
    }

    @Override
    public void peru() {
        tuloskentta.setText(String.valueOf(this.viimeinen));
        sovellus.asetaTulos(viimeinen);
        undo.disableProperty().set(true);
    }
}
