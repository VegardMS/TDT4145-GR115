package src;

import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main extends DBConn{
    Scanner sc = new Scanner(System.in);

    public void registrerTreningsokt() throws ParseException{
	    	System.out.println("Registrer en ny treningsøkt ved å fylle inn disse feltene: ");
	    	
	    	//Henter inn dato fra bruker og oppretter nytt LocalDate-objekt
	    	System.out.println("Dato (ÅÅÅÅ-MM-DD): ");
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
	    	System.out.println("Notat (maks 100 symboler): ");
	    	String notat = sc.nextLine();
	    	
	    	System.out.println();
	    	
	    	System.out.println("Du har registrert følgende: \n \n" +
	    						"Dato: " + dato + "\n" +
	    						"Tid: " + tid + "\n" +
	    						"Varighet: " + Integer.toString(varighet) + "\n" +
	    						"Form: " + Integer.toString(form) + "\n" +
	    						"Prestasjon: " + Integer.toString(prestasjon) + "\n" +
	    						"Notat: "+ notat + "\n");
	    	
	    	Treningsokt treningsokt = new Treningsokt(dato, tid, varighet, form, prestasjon, notat);
	    	
	    System.out.println("Vil du legge til en øvelse i økta? (ja/nei)?");
	    	while (!sc.nextLine().equals("nei")) {
	    		System.out.println("Hva heter øvelsen du vil legge til?");
	    		String ovelse = sc.nextLine();
	    		treningsokt.leggTilOvelse(ovelse);
	    		System.out.println("Vil du legge til enda en øvelse i økta? (ja/nei)?");
	    		}
	    	}
	  
    public void registrerApparat(){
	    	System.out.println("Registrer et nytt apparat ved å legge inn følgende:");
	    	System.out.println("Navn: ");
	    	String navn = sc.nextLine();
	    	System.out.println("Funksjon: ");
	    	String funksjon = sc.nextLine();
	    	
	    System.out.println("Du har registrert følgende: \n \n" +
					"Navn: " + navn + "\n" +
					"Funksjon: " + funksjon + "\n");
	    	
	    	Apparat a = new Apparat(navn, funksjon);

    }

    public void registrerOvelse(){
	    	System.out.println("Registrer øvelse med apparat (y) eller uten apparat (n):");
	    	String input = sc.nextLine();
	    	char apparat = input.charAt(0);
	    	if (apparat == 'y') {
	    		System.out.println("Legg inn følgende: ");
	    		System.out.println("Navn: ");
	    		String navn = sc.nextLine();
	    		System.out.println("Antall kilo: ");
	    		int kilo = sc.nextInt();
	    		System.out.println("Antall sett: ");
	    		int sett = sc.nextInt();
	    		
	    		System.out.println("Du har registrert følgende: \n \n" +
	    				"Navn: " + navn + "\n" +
	    				"Antall kilo: " + Integer.toString(kilo) + "\n" +
	    				"Antall sett: " + Integer.toString(sett) + "\n");
	    		
	    		Ovelse o = new Ovelse(navn, kilo, sett);
	    		}
	    	if (apparat == 'n') {
	    		System.out.println("Legg inn følgende: ");
	    		System.out.println("Navn: ");
	    		String navn  = sc.nextLine();
	    		System.out.println("Beskrivelse: ");
	    		String beskrivelse = sc.nextLine();
	    		
	    		System.out.println("Du har registrert følgende: \n \n" +
	    				"Navn: " + navn + "\n" +
	    				"Beskrivelse: " + beskrivelse + "\n");
	    		
	    		Ovelse o = new Ovelse (navn, beskrivelse);
	    		}
	
	    }
    
    public void hentResultater() {
    		System.out.println("Hent ut resultater for øvelse (navn på øvelse): ");
    		String øvelse = sc.nextLine();
    		System.out.println("Er øvelsen med apparat (y) eller uten apparat (n)? ");
    		String input = sc.nextLine();
    		char apparat = input.charAt(0);
    		System.out.println("Periode fra (ÅÅÅÅ-MM-DD): ");
    		String dato = sc.nextLine();
    		String fraÅr = dato.substring(0, 4);
    		String fraMåned = dato.substring(5, 7);
    		String fraDag = dato.substring(8, 10);
    		System.out.println("Til(ÅÅÅÅ-MM-DD): ");
    		String tid = sc.nextLine();
    		String tilÅr = tid.substring(0, 4);
    		String tilMåned = tid.substring(5, 7);
    		String tilDag = tid.substring(8, 10);
    		
    		LocalDate fra = LocalDate.of(Integer.parseInt(fraÅr),Integer.parseInt(fraMåned),Integer.parseInt(fraDag));
    		LocalDate til = LocalDate.of(Integer.parseInt(tilÅr),Integer.parseInt(tilMåned),Integer.parseInt(tilDag));
    		
    		Resultatlogg r = new Resultatlogg (øvelse, fra, til, apparat);
    }
    

    public void opprettOvelsesGruppe(){
    		System.out.println("Legg inn beskrivelse for øvelsesgruppen du vil lage?");
    		String beskrivelse = sc.nextLine();
    		Ovelsesgruppe ovelsesgruppe = new Ovelsesgruppe(beskrivelse);

    }

    public void finnFavoritt(){
    		System.out.println("Hvor mange av dine favorittøvelser vil du se?");
	    String tall = sc.nextLine();
	    Favorittovelser fav = new Favorittovelser(Integer.parseInt(tall));
    }
    
    public void hentOkter() {
		System.out.println("Hvor mange økter vil du hente ut?");
		String antall = sc.nextLine();
		hentØkter h = new hentØkter(Integer.parseInt(antall));
    }
    
    public void visØvelserIGruppe() {
    		System.out.println("Hvilken øvelsesgruppe vil du se? ");
    		String gruppe = sc.nextLine();
    		ØvelserIGruppe g = new ØvelserIGruppe(gruppe);
    		System.out.println("\n");
    		
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();

        while(true) {
            System.out.println("Hei, hva vil du gjøre? \n");
            System.out.println("1 - Legg inn ny treningsøkt i databasen");
            System.out.println("2 - Legg inn nytt apparat i databasen");
            System.out.println("3 - Legg inn ny øvelse i databasen");
            System.out.println("4 - Hent resultater for øvelse");
            System.out.println("5 - Registrer øvelsesgruppe");
            System.out.println("6 - Finn dine favorittøvelser");
            System.out.println("7 - Hent ut dine siste økter");
            System.out.println("8 - Vis hvilke øvelser som tilhører øvelsesgruppe");
            System.out.println("Velg 1, 2, 3, 4, 5, 6, 7 eller 8");

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
                case 7:
                		m.hentOkter();
                		break;
                case 8:
                		m.visØvelserIGruppe();
                		break;
            }
        }
    }
}

