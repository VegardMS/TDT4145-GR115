package src;

import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    public void registrerTreningsøkt(){
    	System.out.println("Registrer en ny treningsøkt ved å fylle inn disse feltene:");
    	System.out.println("Dato (ÅÅÅÅ-MM-DD): ");
    	String dato = sc.nextLine();
    	System.out.println("Klokkeslett (TT:MM:SS): ");
    	String tid = sc.nextLine();
    	System.out.println("Varighet (Minutter): ");
    	int varighet = sc.nextInt();
    	System.out.println("Personlig form (Heltall mellom 0 og 10): ");
    	int form = sc.nextInt();
    	System.out.println("Prestasjon (Heltall mellom 0 og 10): ");
    	int prestasjon = sc.nextInt();
    	System.out.println("Notat: ");
    	String notat = sc.nextLine();
    	System.out.println();
    	
    	System.out.println(dato+tid+Integer.toString(varighet)+ Integer.toString(form) + Integer.toString(prestasjon) + notat);
    	
    	

    }

    public void registrerApparat(){

    }

    public void registrerØvelse(){

    }
    
    public void hentResultater() {
    	
    }
    

    public void registrerØvelsesGruppe(){

    }

    public void finnFavoritt(){

    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();

        while(true) {
            System.out.println("Hei");
            System.out.println("1 - Legg inn ny treningsøkt i databasen");
            System.out.println("2 - Legg inn nytt apparat i databasen");
            System.out.println("3 - Legg inn ny øvelse i databasen");
            System.out.println("4 - Hent resultater for øvelse");
            System.out.println("5 - Registrer øvelsesgruppe");
            System.out.println("6 - Finn dine favorittøvelser");
            System.out.println("Velg 1, 2, 3, 4, 5 eller 6");
            int scase = Integer.parseInt(m.sc.nextLine());
            switch (scase) {
                case 1:
                    m.registrerTreningsøkt();
                    break;
                case 2:
                    m.registrerApparat();
                    break;
                case 3:
                    m.registrerØvelse();
                    break;
                case 4:
                		m.hentResultater();
                		break;
                case 5:
                    m.registrerØvelsesGruppe();
                    break;
                case 6:
                    m.finnFavoritt();
                    break;
            }
        }
    }
}

