
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento{
    
    private int viimeinen;
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, plus, miinus, nollaa, undo, sovellus);
        this.viimeinen = 0;
    }

    @Override
    public void suorita() {
        this.viimeinen = sovellus.tulos();
        sovellus.nollaa();
        int tulos = sovellus.tulos();
        tuloskentta.setText(String.valueOf(tulos));
        undo.disableProperty().set(false);
        
        
    }

    @Override
    public void peru() {
        tuloskentta.setText(String.valueOf(this.viimeinen));
        sovellus.asetaTulos(viimeinen);
        undo.disableProperty().set(true);
    }
    
}
