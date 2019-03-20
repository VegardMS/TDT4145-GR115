package src;

import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main extends DBConn{
    Scanner sc = new Scanner(System.in);

    public void registrerTreningsokt() throws ParseException{
    	System.out.println("Registrer en ny trenings¯kt ved Â fylle inn disse feltene: ");
    	
    	//Henter inn dato fra bruker og oppretter nytt LocalDate-objekt
    	System.out.println("Dato (≈≈≈≈-MM-DD): ");
    	String datoString = sc.nextLine();
    	String[] numbers = datoString.split("-");
    	int[] ints = new int[numbers.length];
    	for(int c = 0; c < numbers.length; c++) ints[c] = Integer.parseInt(numbers[c]);
		LocalDate dato = LocalDate.of(ints[0], ints[1], ints[2]);
    	
		//Henter inn tidspunkt fra bruker og oppretter nytt Time-objekt
    	System.out.println("Klokkeslett (TT:MM:SS): ");
    	String tidString = sc.nextLine();
    	String[] numbers1 = tidString.split(":");
    	int[] ints1 = new int[numbers1.length];
    	for(int d = 0; d < numbers1.length; d++) ints1[d] = Integer.parseInt(numbers1[d]);
		Time tid = new Time(ints1[0], ints1[1], ints1[2]);
    	
    	System.out.println("Varighet (minutter): ");
    	int varighet = sc.nextInt();
    	
    	System.out.println("Personlig form (heltall mellom 0 og 10): ");
    	int form = sc.nextInt();
    	
    	System.out.println("Prestasjon (heltall mellom 0 og 10): ");
    	int prestasjon = sc.nextInt();
    	
    	sc.nextLine();
    	System.out.println("Notat (maks x symboler): ");
    	String notat = sc.nextLine();
    	
    	System.out.println();
    	
    	System.out.println("Du har registrert f¯lgende: \n \n" +
    						"Dato: " + dato + "\n" +
    						"Tid: " + tid + "\n" +
    						"Varighet: " + Integer.toString(varighet) + "\n" +
    						"Form: " + Integer.toString(form) + "\n" +
    						"Prestasjon: " + Integer.toString(prestasjon) + "\n" +
    						"Notat: "+ notat + "\n");
    	
    	Treningsokt treningsokt = new Treningsokt(dato, tid, varighet, form, prestasjon, notat);
    	
    	//SÂ mÂ man kunne legge ¯velser til ¯kta
    	System.out.println("Vil du legge til en ¯velse i ¯kta? (skriv 'nei' for Â avslutte)?");
    	while (sc.nextLine() != "nei") {
    		System.out.println("Hva heter ¯velsen du vil legge til?");
    		String ovelse = sc.nextLine();
    		treningsokt.leggTilOvelse(ovelse);
    	}
    }

    public void registrerApparat(){
    	System.out.println("Registrer et nytt apparat ved Â legge inn f¯lgende:");
    	System.out.println("Navn: ");
    	String navn = sc.nextLine();
    	System.out.println("Funksjon: ");
    	String funksjon = sc.nextLine();
    	
    System.out.println("Du har registrert f¯lgende: \n \n" +
				"Navn: " + navn + "\n" +
				"Funksjon: " + funksjon + "\n");
    	
    	Apparat a = new Apparat(navn, funksjon);

    }

    public void registrerOvelse(){
    	System.out.println("Registrer ¯velse med apparat (y) eller uten apparat (n):");
    	String input = sc.nextLine();
    	char apparat = input.charAt(0);
    	if (apparat == 'y') {
    		System.out.println("Legg inn f¯lgende: ");
    		System.out.println("Navn: ");
    		String navn = sc.nextLine();
    		System.out.println("Antall kilo: ");
    		int kilo = sc.nextInt();
    		System.out.println("Antall sett: ");
    		int sett = sc.nextInt();
    		
    		System.out.println("Du har registrert f¯lgende: \n \n" +
    				"Navn: " + navn + "\n" +
    				"Antall kilo: " + kilo + "\n" +
    				"Antall sett: " + sett + "\n");
    		
    		Ovelse o = new Ovelse(navn, kilo, sett);
    		}
    	if (apparat == 'n') {
    		System.out.println("Legg inn f¯lgende: ");
    		System.out.println("Navn: ");
    		String navn  = sc.nextLine();
    		System.out.println("Beskrivelse: ");
    		String beskrivelse = sc.nextLine();
    		
    		System.out.println("Du har registrert f¯lgende: \n \n" +
    				"Navn: " + navn + "\n" +
    				"Beskrivelse: " + beskrivelse + "\n");
    		
    		Ovelse o = new Ovelse (navn, beskrivelse);
    		}

    }
    
    public void hentResultater() {
    	
    }
    

    public void opprettOvelsesGruppe(){
    	System.out.println("Legg inn beskrivelse for ¯velsesgruppen du vil lage?");
    	String beskrivelse = sc.nextLine();
    	Ovelsesgruppe ovelsesgruppe = new Ovelsesgruppe(beskrivelse);
    }

    public void finnFavoritt(){
    		
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();

        while(true) {
            System.out.println("Hei, hva vil du gj¯re? \n");
            System.out.println("1 - Legg inn ny trenings¯kt i databasen");
            System.out.println("2 - Legg inn nytt apparat i databasen");
            System.out.println("3 - Legg inn ny ¯velse i databasen");
            System.out.println("4 - Hent resultater for ¯velse");
            System.out.println("5 - Opprett ¯velsesgruppe");
            System.out.println("6 - Finn dine favoritt¯velser");
            System.out.println("Velg 1, 2, 3, 4, 5 eller 6");
            int scase = Integer.parseInt(m.sc.nextLine());
            switch (scase) {
                case 1:
                    m.registrerTreningsokt();
                    break;
                case 2:
                    m.registrerApparat();
                    break;
                case 3:
                    m.registrerOvelse();
                    break;
                case 4:
                	m.hentResultater();
                	break;
                case 5:
                    m.opprettOvelsesGruppe();
                    break;
                case 6:
                    m.finnFavoritt();
                    break;
            }
        }
    }
}

