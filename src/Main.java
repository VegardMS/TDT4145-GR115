
public class Main {
    Scanner sc = new Scanner(System.in);

    privat void registrerTreningsøkt(){

    }

    privat void registrerApparat(){

    }

    privat void registrerØvelse(){

    }

    privat void registrerØvelsesGruppe(){

    }

    privat void finnFavoritt(){

    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();

        while(true) {
            System.out.println("Hei");
            System.out.println("1 - Legg inn ny treningsøkt");
            System.out.println("2 - Legg inn nytt apparat i databasen");
            System.out.println("3 - Legg inn ny øvelse i databasen");
            System.out.println("4 - Registrer øvelsesgruppe");
            System.out.println("5 - Finn dine favorittøvelser");
            System.out.println("Velg 1, 2, 3, 4 eller 5");
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
                    m.registrerØvelsesGruppe();
                    break;
                case 5:
                    m.finnFavoritt();
                    break;
            }
        }
    }

