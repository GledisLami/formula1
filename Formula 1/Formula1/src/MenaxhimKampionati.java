import java.io.FileNotFoundException;
import java.util.Scanner;

public interface MenaxhimKampionati {
     void lexoGaruesF();
     void perditesoGaruesF() throws FileNotFoundException;
     void lexoGaratF();
     void perditesoGaratF() throws FileNotFoundException;
     void lexoDatatF();
     void perditesoDatatF() throws FileNotFoundException;
     void shtoGarues();
     void printoGaruesit();
     void hiqGarues();
     void ndryshoGarues();
     void teDhenaGarues();
     void perziejVendetGarues();
     void perziejVendetGaruesProbabilitet();
     void shtoPiket();
     Data krijoDate();
     void piketRendRrites();
     void piketRendZbrites();
     void fitoretRendZbrites();
     void krijoGareManualisht();
     void menu(Formula1MenaxhimKampionati formula1, Scanner sc) throws FileNotFoundException;
     void krijoGare();

}
