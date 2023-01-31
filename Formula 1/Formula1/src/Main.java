import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Formula1MenaxhimKampionati formula1 = new Formula1MenaxhimKampionati();
        Scanner sc = new Scanner(System.in);
        new Swing();
        formula1.menu(formula1, sc);

    }
}