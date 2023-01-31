import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Formula1MenaxhimKampionati implements MenaxhimKampionati{

    //Implementojme listat per te dhenat qe do manipulohen gjate programit
    List<ShoferiFormula1> listaGaruesve = new ArrayList<>();
    List<ShoferiFormula1> garuesTemp = new ArrayList<>();
    List<Data> listaDatave = new ArrayList<>();
    List<List<ShoferiFormula1>> historiaGarave = new ArrayList<>();


    //krijojme objektet per leximin e te dhenave nga file
    Scanner sc = new Scanner(System.in);
    File fileGarues = new File("shoferetData.txt");
    File fileGarat = new File("garat.txt");
    File fileDatat = new File("data.txt");
    Scanner lexoGarues = new Scanner(fileGarues);
    Scanner lexoGarat = new Scanner(fileGarat);
    Scanner lexoDatat = new Scanner(fileDatat);

    int i, j; //variabla indexesh ne ciklet for

    public Formula1MenaxhimKampionati() throws FileNotFoundException {
    }
    /*
    Implementohen metodat per te lexuar dhe shkruar te dhenat nga secili file.
     */
    public void lexoGaruesF() {
        while (lexoGarues.hasNextLine()) {
            ShoferiFormula1 garues = new ShoferiFormula1();
            listaGaruesve.add(garues);
            String emri = lexoGarues.next();
            garues.setEmri(emri);
            String skuadra = lexoGarues.next();
            garues.setSkuadra(skuadra);
            int nrVend1 = Integer.parseInt(lexoGarues.next());
            garues.setNrVendPare(nrVend1);
            int nrVend2 = Integer.parseInt(lexoGarues.next());
            garues.setNrVendiDyte(nrVend2);
            int nrVend3 = Integer.parseInt(lexoGarues.next());
            garues.setNrVendiTrete(nrVend3);
            int piket = Integer.parseInt(lexoGarues.next());
            garues.setPiket(piket);
            int garat = Integer.parseInt(lexoGarues.next());
            garues.setNrGarave(garat);
        }
    }
    public void perditesoGaruesF() throws FileNotFoundException {
        PrintWriter shkruaj = new PrintWriter(fileGarues);
        //print ne index i-1 qe te mos krijoje \n ne file
        for (i = 0; i< listaGaruesve.size(); i++){
            if (i == listaGaruesve.size()-1){
                shkruaj.print((listaGaruesve.get(i).getEmri()+" "+ listaGaruesve.get(i).getSkuadra() + " " +
                        listaGaruesve.get(i).getNrVendPare() + " " + listaGaruesve.get(i).getNrVendiDyte() + " "
                        + listaGaruesve.get(i).getNrVendiTrete() + " " + listaGaruesve.get(i).getPiket() + " " +
                        listaGaruesve.get(i).getNrGarave()));
                break;
            }
            shkruaj.println(listaGaruesve.get(i).getEmri()+" "+ listaGaruesve.get(i).getSkuadra() + " " +
                    listaGaruesve.get(i).getNrVendPare() + " " + listaGaruesve.get(i).getNrVendiDyte() + " "
                    + listaGaruesve.get(i).getNrVendiTrete() + " " + listaGaruesve.get(i).getPiket() + " " +
                    listaGaruesve.get(i).getNrGarave());
        }
        shkruaj.close();
    }

    public void lexoGaratF(){
        while (lexoGarat.hasNextLine()) {
            List<ShoferiFormula1> listaTempGarues = new ArrayList<>();
            //arraylist qe mban cdo shofer per 1 gare
            int nrGarues = Integer.parseInt(lexoGarat.next());
            for (i = 0; i < nrGarues; i++) {
                //marrim te dhenat per cdo shofer dhe pozicionet ne nje gare
                ShoferiFormula1 garues = new ShoferiFormula1();
                String emri = lexoGarat.next();
                garues.setEmri(emri);
                String skuadra = lexoGarat.next();
                garues.setSkuadra(skuadra);
                //ja fusim listes
                listaTempGarues.add(garues);
                //shtohet cdo rresht / shofer me skuadren ne listen e pare
                //pasi mbaron gara e 1, krijohet temp gare tjeter, i shtohen te dhenat dhe
                // futet ne listen e garave
            }
            //listen e shtojme ne arrayListin qe permban te tere garat
            historiaGarave.add(listaTempGarues);
        }
    }
    public void perditesoGaratF() throws FileNotFoundException {
        PrintWriter shkruaj = new PrintWriter(fileGarat);
        int counter = 0;
        for (i = 0; i < historiaGarave.size(); i++){
            counter++;
            if (counter>1){
                shkruaj.print("\n");
            }
            shkruaj.println(historiaGarave.get(i).size());
            for (j = 0; j < historiaGarave.get(i).size(); j++){
                if (j == historiaGarave.get(i).size()-1) {
                    shkruaj.print(historiaGarave.get(i).get(j).getEmri() + " " +
                            historiaGarave.get(i).get(j).getSkuadra());

                }else shkruaj.println(historiaGarave.get(i).get(j).getEmri() + " " +
                        historiaGarave.get(i).get(j).getSkuadra());
            }
        }
        shkruaj.close();
    }

    public void lexoDatatF(){
        while (lexoDatat.hasNextLine()) {
            Data data = new Data();
            listaDatave.add(data);
            int dita = Integer.parseInt(lexoDatat.next());
            data.setDita(dita);
            int muaji = Integer.parseInt(lexoDatat.next());
            data.setMuaji(muaji);
            int viti = Integer.parseInt(lexoDatat.next());
            data.setViti(viti);
        }
    }
    public void perditesoDatatF() throws FileNotFoundException {
        PrintWriter shkruaj = new PrintWriter(fileDatat);
        for (i = 0; i < listaDatave.size(); i++){
            if (i == listaDatave.size()-1){
                shkruaj.print(listaDatave.get(i).getDita() + " " + listaDatave.get(i).getMuaji() + " " +
                        listaDatave.get(i).getViti());
                break;
            }
            shkruaj.println(listaDatave.get(i).getDita() + " " + listaDatave.get(i).getMuaji() + " " +
                    listaDatave.get(i).getViti());
        }
        shkruaj.close();
    }

    //kerkohet garuesi nese ndodhet. ne te kundert shtohet ne liste
    public void shtoGarues(){
        if (listaGaruesve.size()==10){
            System.err.println("Nuk mund te kete me shume se 10 shofere ne gare");
        }else {
            ShoferiFormula1 garues = new ShoferiFormula1();
            System.out.println("Fusni emrin: ");
            garues.setEmri(sc.next());
            System.out.println("Fusni skuadren: ");
            garues.setSkuadra(sc.next());
            boolean shoferiGjendet = false;
            for (i = 0; i< listaGaruesve.size(); i++){
                if (garues.getSkuadra().equalsIgnoreCase(listaGaruesve.get(i).getSkuadra())){
                    System.err.println("Skuadra plot! Fut emer tjeter\n");
                    shoferiGjendet = true;
                    break;
                }
            }

            if(!shoferiGjendet){
                listaGaruesve.add(garues);
            }

            System.out.println();
        }
    }

    public void hiqGarues(){
        if (listaGaruesve.size()>0) {
            System.out.println("Fusni emrin e shoferit qe doni te hiqni");
            String emriGaruesit = sc.next();
            for (i = 0; i < listaGaruesve.size(); i++) {
                if (emriGaruesit.equalsIgnoreCase(listaGaruesve.get(i).getEmri())) {
                    listaGaruesve.remove(i);
                    System.out.println("Shoferi u hoq me sukses\n");
                    break;
                }
            }
        }else System.err.println("Nuk ka asnje shofer te rregjistruar!");
    }

    //gjen garuesin dhe e ndryshon
    public void ndryshoGarues(){
        if (listaGaruesve.size()>0) {
            System.out.println("Ne cilen skuader do ta ndryshoni shoferin? ");
            String skuadra = sc.next();
            //nese gjehet skuadra ndryshojme emrin
            for (i = 0; i < listaGaruesve.size(); i++) {
                if (skuadra.equalsIgnoreCase(listaGaruesve.get(i).getSkuadra())) {//ne momentin qe ekziston skuadra
                    System.out.println("Fusni emrin e shoferit te ri");
                    listaGaruesve.get(i).setEmri(sc.next());
                    System.out.println("Shoferi u ndryshua me sukses!\n");
                    break;
                }
            }
        }else System.err.println("Nuk ka asnje shofer te rregjistruar!");
    }

    //afishon me ane te toString garuesin e kerkuar
    public void teDhenaGarues(){
        if (listaGaruesve.size()>0) {
            System.out.println("Fut emrin e shoferit per te cilin do te shohesh statistikat");
            String emri = sc.next();
            boolean shoferiGjendet = false;
            for (i = 0; i < listaGaruesve.size(); i++) {
                if (emri.equalsIgnoreCase(listaGaruesve.get(i).getEmri())) {
                    System.out.println(listaGaruesve.get(i).toString() + "\n");
                    shoferiGjendet = true;
                    break;
                }
            }
            if (!shoferiGjendet){
                System.err.println("Shoferi nuk u gjet");
            }
        }else System.err.println("0 shofere\n");
    }

    //afishon te gjithe garusit
    public void printoGaruesit(){
        if (listaGaruesve.size()>0) {
            System.out.println("--------------------------------------------------------------" +
                    "------------------------------------------------------------------");
            for (i = 0; i < listaGaruesve.size(); i++) {
                System.out.println("Garuesi " + (i+1) + ": " + listaGaruesve.get(i).toString());
            }
            System.out.println();
        }else System.err.println("0 shofere\n");
    }

    //afishon te gjithe garuesit ne nderfaqen grafike
    public String printoGaruesitGui(){
        StringBuilder teksti = new StringBuilder();
        if (listaGaruesve.size()>0) {
            teksti.append("--------------------------------------------------------------------------------------------------------------------------------");
            teksti.append("\n");
            for (i = 0; i < listaGaruesve.size(); i++) {
                teksti.append("Shoferi ").append(i + 1).append(": ").append(listaGaruesve.get(i).toString());
            }
            teksti.append("\n");
        }else teksti.append("0 shofere\n");
        return teksti.toString();
    }

    /*
    metoda me posht perzien pozicionet e garuesve me anen e nje objekti random,
    popullon listen temp me shoferet e perzier dhe ne fund i kalon ne listen origjinale.
    Tempi zbrazet me 1 nga 2 menyrat e shkruara
     */
    public void perziejVendetGarues(){
        Random rand = new Random();
        int counter = listaGaruesve.size();
        for (i = 0; i< counter; i++){
            int random = rand.nextInt(listaGaruesve.size());
            garuesTemp.add(listaGaruesve.get(random));
            listaGaruesve.remove(random);
        }
        for (i = 0; i < garuesTemp.size(); i++){
            listaGaruesve.add(garuesTemp.get(i));
        }
        for (i = garuesTemp.size(); i>0; i--){
            garuesTemp.remove(0);
        }
        //listaShofereveTemp = new ArrayList<>();
    }

    //I njejti funksionalitet si metoda me siper, por garuesi qe e fiton zgjidhet me probabilitet
    public void perziejVendetGaruesProbabilitet(){
        double shoferiShans = Math.random(); //0-1
        if (shoferiShans > 0 && shoferiShans <= 0.4) {
            garuesTemp.add(listaGaruesve.get(0));
            listaGaruesve.remove(0);
        } else if (shoferiShans > 0.4 && shoferiShans <= 0.7) {
            garuesTemp.add(listaGaruesve.get(1));
            listaGaruesve.remove(1);
        } else if (shoferiShans > 0.7 && shoferiShans <= 0.8) {
            garuesTemp.add(listaGaruesve.get(2));
            listaGaruesve.remove(2);
        } else if (shoferiShans > 0.8 && shoferiShans <= 0.9) {
            garuesTemp.add(listaGaruesve.get(3));
            listaGaruesve.remove(3);
        } else if (shoferiShans > 0.9 && shoferiShans <= 0.92) {
            garuesTemp.add(listaGaruesve.get(4));
            listaGaruesve.remove(4);
        } else if (shoferiShans > 0.92 && shoferiShans <= 0.94) {
            garuesTemp.add(listaGaruesve.get(5));
            listaGaruesve.remove(5);
        } else if (shoferiShans > 0.94 && shoferiShans <= 0.96) {
            garuesTemp.add(listaGaruesve.get(6));
            listaGaruesve.remove(6);
        } else if (shoferiShans > 0.96 && shoferiShans <= 0.98) {
            garuesTemp.add(listaGaruesve.get(7));
            listaGaruesve.remove(7);
        } else {
            garuesTemp.add(listaGaruesve.get(8));
            listaGaruesve.remove(8);
        }
        perziejVendetGarues();
    }

    /*Metode qe do perdoret pasi kryhet nje gare. I shton piket, numrin e garave,
    dhe statistikat per vendin e pare, te dyte dhe te trete.
     */
    public void shtoPiket(){
        for (i = 0; i< listaGaruesve.size(); i++){
            listaGaruesve.get(i).setNrGarave(listaGaruesve.get(i).getNrGarave()+1);
        }
        int[] piket = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        for (i = 0; i < listaGaruesve.size(); i++){
            listaGaruesve.get(i).setPiket(listaGaruesve.get(i).getPiket() + piket[i]);
        }
        if (listaGaruesve.size()>=1){
            listaGaruesve.get(0).setNrVendPare(listaGaruesve.get(0).getNrVendPare()+1);
            if (listaGaruesve.size()>=2){
                listaGaruesve.get(1).setNrVendiDyte(listaGaruesve.get(1).getNrVendiDyte()+1);
            }if (listaGaruesve.size()>=3){
                listaGaruesve.get(2).setNrVendiTrete(listaGaruesve.get(2).getNrVendiTrete()+1);
            }
        }
    }

    /* gjeneron nje date random, mund te perdoret libraria localDateTime per te
    marre garen ne momentin qe kriohet gara */
    public Data krijoDate(){
        Random rand = new Random();
        Data data = new Data();
        data.setDita(rand.nextInt(31)+1);
        data.setViti(rand.nextInt(25)+2015);
        data.setMuaji(rand.nextInt(12)+1);
        //System.out.println(data.toString());
        return data;
    }

    /*krijon nje gare duke perdorur metoden krijoDate()
     i shton ne listat perkatese garen dhe daten.
     Printon rezultatet


     */
    public void krijoGare(){
        Data data;
        data = krijoDate();
        listaDatave.add(data);
        System.out.println(data);
        System.out.println("\nRezultatet: ");
        for (i = 0; i < listaGaruesve.size(); i++){
            garuesTemp.add(listaGaruesve.get(i));
            }
        for (i = 0; i< garuesTemp.size(); i++){
            System.out.println((i+1) + ": " + garuesTemp.get(i).getEmri());
        }
        shtoPiket();
        historiaGarave.add(garuesTemp);
        garuesTemp = new ArrayList<>();
        System.out.println();
    }

    public String krijoGareGui(){
        StringBuilder teksti = new StringBuilder();
        Data data = krijoDate();
        listaDatave.add(data);
        teksti.append(data);
        teksti.append("\nPozicionet perfundimtare: ");
        for (i = 0; i < listaGaruesve.size(); i++){
            garuesTemp.add(listaGaruesve.get(i));
        }
        for (i = 0; i< garuesTemp.size(); i++){
            teksti.append(i + 1).append(": ").append(garuesTemp.get(i).getEmri());
            teksti.append("\n");
        }
        shtoPiket();
        historiaGarave.add(garuesTemp);
        garuesTemp = new ArrayList<>();
        teksti.append("\n");
        return teksti.toString();
    }

    //Metodat me poshte sherbejne per renditjen e garuesve sipas kritereve te pikeve ose fitoreve.
    public void piketRendRrites(){
        for (i = 0; i< listaGaruesve.size(); i++) {
            for (j = i + 1; j < listaGaruesve.size(); j++) {
                if (listaGaruesve.get(i).getPiket() > listaGaruesve.get(j).getPiket()) {
                    Collections.swap(listaGaruesve, i, j);
                }else if (listaGaruesve.get(i).getPiket() == listaGaruesve.get(j).getPiket()){
                    if (listaGaruesve.get(i).getNrVendPare() < listaGaruesve.get(j).getNrVendPare()) {
                        Collections.swap(listaGaruesve, i, j);
                    }
                }
            }
        }
    }
    public void piketRendZbrites(){
        for (i = 0; i< listaGaruesve.size(); i++) {
            for (j = i + 1; j < listaGaruesve.size(); j++) {
                if (listaGaruesve.get(i).getPiket() < listaGaruesve.get(j).getPiket()) {
                    Collections.swap(listaGaruesve, i, j);
                }else if (listaGaruesve.get(i).getPiket() == listaGaruesve.get(j).getPiket()){
                    if (listaGaruesve.get(i).getNrVendPare() < listaGaruesve.get(j).getNrVendPare()) {
                        Collections.swap(listaGaruesve, i, j);
                    }
                }
            }
        }
    }
    public void fitoretRendZbrites(){
        for (i = 0; i< listaGaruesve.size(); i++) {
            for (j = i + 1; j < listaGaruesve.size(); j++) {
                if (listaGaruesve.get(i).getNrVendPare() < listaGaruesve.get(j).getNrVendPare()) {
                    Collections.swap(listaGaruesve, i, j);
                }
            }
        }
    }
    //kerkon nje garues dhe i afishon te dhenat ne nderfaqen grafike
    public String kerkoGarues(String emri){
        StringBuilder teskti = new StringBuilder();
        for (i = 0; i < historiaGarave.size(); i++){
            for (j = 0; j< historiaGarave.get(i).size(); j++){
                if (emri.equalsIgnoreCase(historiaGarave.get(i).get(j).getEmri())){
                    teskti.append(listaDatave.get(i).toString()).append("\nPozicioni ").append((j+1)).append("\n");
                    teskti.append("\n");
                    break;
                }
            }
        }
        return teskti.toString();
    }

    //Metode qe rendit garat ne rend rrites sipas datave.
    public void datatRendRrites(){
        for (i = 0; i< listaDatave.size(); i++) {
            for (j = i + 1; j < listaDatave.size(); j++) {
                if (listaDatave.get(i).getViti() > listaDatave.get(j).getViti()) {
                    Collections.swap(listaDatave, i, j);
                    Collections.swap(historiaGarave, i, j);
                }else if(listaDatave.get(i).getViti() == listaDatave.get(j).getViti()){
                    if (listaDatave.get(i).getMuaji() > listaDatave.get(j).getMuaji()){
                        Collections.swap(listaDatave, i, j);
                        Collections.swap(historiaGarave, i, j);
                    }else if(listaDatave.get(i).getMuaji() == listaDatave.get(j).getMuaji()){
                        if (listaDatave.get(i).getDita() > listaDatave.get(j).getDita()){
                            Collections.swap(listaDatave, i, j);
                            Collections.swap(historiaGarave, i, j);
                        }
                    }
                }
            }
        }
    }

    //Krijon nje string qe do te afishohet ne gui per historikun e te gjitha garave
    public String printoGaratGui(){
        StringBuilder teksti = new StringBuilder();
        for (i = 0; i < historiaGarave.size(); i++) {
            teksti.append("Data  ").append(listaDatave.get(i).toString()).append(":\nRezultatet: \n");
            for (j = 0; j < historiaGarave.get(i).size(); j++) {
                teksti.append(j + 1).append(". ").append(historiaGarave.get(i).get(j).getEmri()).append(" ").append(historiaGarave.get(i).get(j).getSkuadra());
                teksti.append("\n");
            }
            teksti.append("\n");
        }
        return teksti.toString();
    }

    //Metode me te cilen perdoruesi mund te krijoje manualisht nje gare
    public void krijoGareManualisht(){
        Data data = new Data();
        System.out.println("Vendos daten");
        System.out.print("Viti: ");
        do {
            data.setViti(sc.nextInt());
            if (data.getViti()<=1950 || data.getViti()>=2040){
                System.out.println("Ju lutem fusni nje vit pozitiv nga 1950 deri ne 2040");
            }
        }while (data.getViti()<=1950);
        System.out.print("\nMuaji: ");
        do {
            data.setMuaji(sc.nextInt());
            if (data.getMuaji()<=0 || data.getMuaji() >12){
                System.out.println("Ju lutem fusni nje muaj nga 1-12");
            }
        }while (data.getMuaji()<=0 || data.getMuaji()>12);
        System.out.print("\nDita: ");
        do {
            data.setDita(sc.nextInt());
            if (data.getDita()<=0 || data.getDita() >31){
                System.out.println("Ju lutem fusni nje date nga 1-31");
            }
        }while (data.getDita()<=0 || data.getDita()>31);
        printoGaruesit();
        System.out.println("Zgjidh rezultatet e gares: ");
        int count = listaGaruesve.size();
        for (int i = 0; i< count; i++){
            System.out.println("Vendi i " + (i+1) + ": ");
            int j;
            do {
                j = sc.nextInt();
                if (j<0 || j > listaGaruesve.size()){
                    System.err.println("Ju lutem zgjidhni shoferet nga 1 deri ne " + listaGaruesve.size());
                }
            }while (!(j>0 && j <= listaGaruesve.size()));
            garuesTemp.add(listaGaruesve.get(j-1));
            listaGaruesve.remove(j-1);
            if (listaGaruesve.size()>0) {
                printoGaruesit();
            }
        }
        for (int i = 0; i < garuesTemp.size(); i++){
            listaGaruesve.add(garuesTemp.get(i));
        }
        for (int i = garuesTemp.size(); i>0; i--){
            garuesTemp.remove(0);
        }
        shtoPiket();
        printoGaruesit();
        listaDatave.add(data);
        historiaGarave.add(listaGaruesve);
    }
    public void menu(Formula1MenaxhimKampionati formula1, Scanner sc) throws FileNotFoundException {
        formula1.lexoGaruesF();
        formula1.lexoGaratF();
        formula1.lexoDatatF();
        int ch;
        System.out.println("Pershendetje!\n");
        do {
            System.out.println("\nZgjidh nje opsion\n1. Krijo nje shofer\n2. Fshi nje shofer\n" +
                    "3. Ndrysho shoferin e nje skuadre\n4. Shfaq te dhenat per 1 shofer\n" +
                    "5. Shfaq te gjithe shoferet\n6. Simulo nje gare\n7. Simulo gare me shans\n" +
                    "8. Fut nje gare manualisht\n9. Dil nga programi\n\nOpsioni i zgjedhur: ");
            ch = 0;
            ch = exception(sc, ch);
            switch (ch){
                case 1: {
                    formula1.shtoGarues();
                    break;
                }
                case 2: {
                    formula1.hiqGarues();
                    break;
                }
                case 3: {
                    formula1.ndryshoGarues();
                    break;
                }
                case 4: {
                    formula1.teDhenaGarues();
                    break;
                }
                case 5: {
                    formula1.piketRendZbrites();
                    formula1.printoGaruesit();
                    formula1.perditesoGaruesF();
                    break;
                }
                case 6: {
                    if (listaGaruesve.size()==0){
                        System.out.println("Nuk mund te simulosh gare me 0 shofere");
                    }else{
                        formula1.perziejVendetGarues();
                        formula1.krijoGare(); //brenda ndodhet updateStatistikat();
                        formula1.perditesoGaratF();
                        formula1.perditesoDatatF();
                        formula1.perditesoGaruesF();
                    }
                    break;
                }
                case 7: {
                    if (listaGaruesve.size()==0){
                        System.out.println("Nuk mund te simulosh gare me 0 shofere");
                    }else{
                        formula1.perziejVendetGaruesProbabilitet();
                        formula1.krijoGare();
                        formula1.perditesoGaratF();
                        formula1.perditesoDatatF();
                        formula1.perditesoGaruesF();
                    }
                    break;
                }
                case 8: {
                    if(listaGaruesve.size()==0){
                        System.out.println("Nuk mund te simulosh gare me 0 shofere");
                    }else{
                        formula1.krijoGareManualisht();
                        formula1.perditesoGaratF();
                        formula1.perditesoDatatF();
                        formula1.perditesoGaruesF();
                    }
                    break;
                }
                case 9: {
                    System.out.println("Zhvilluar nga: \nGledis Lami\n Aleksander Loli\n Emila Filipi\n" +
                            "Lorna Lelcaj\n Lorena Celami\n\nMirupafshim!");
                    formula1.perditesoGaruesF();
                    formula1.perditesoGaratF();
                    break;
                }
            }
        }while (ch!=9);
    }

    //exception handling per te gjithe inputet numerike nga perdoruesi
    public static int exception(Scanner sc, int input){
        boolean Error = false;
        while (!Error){
            try {
                input = sc.nextInt();
                Error=true;
            } catch (InputMismatchException ime){
                System.err.println("Ju lutem fusni nje numer");
                sc.nextLine();
            }
        }
        return input;
    }
}