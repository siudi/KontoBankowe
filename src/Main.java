import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount("1233334444555566667777",5000);
        System.out.println(bankAccount);

        System.out.println("Twoj nr konta \n" + bankAccount.getAccountNumber());
        bankAccount.setAccountBalance(-5500);
        System.out.println(bankAccount.getAccountBalance());

        bankAccount.deposit(500);
        System.out.println("Saldo po wpłacie: " + bankAccount.getAccountBalance());

        bankAccount.payCheck(1000);
        System.out.println("Saldo po wypacie: " + bankAccount.getAccountBalance());


        int timeDeposit = 2;
        double amountDeposit = 2000;
        double termPercent = 10;
        LocalTime startTime = LocalTime.now();
//        System.out.println(startTime);
        LocalTime endTime = startTime.plusMinutes(timeDeposit);
//        System.out.println(endTime);


        //załozenie lokaty
        TermDeposit termDeposit = new TermDeposit(timeDeposit,amountDeposit,termPercent,startTime);

        //odjęcie kwoty lokaty od stanu konta
        bankAccount.setAccountBalance(bankAccount.getAccountBalance() - amountDeposit);
        System.out.printf("Stan konta po założeniu lokaty %.2f\n",bankAccount.getAccountBalance());

        String end = "";
        Scanner scanner = new Scanner(System.in);
        while(!end.equals("stop")){
            System.out.printf("Poczekaj %d minut i potem wpisz 'stop'\n", timeDeposit);
            end = scanner.nextLine();
        }


        LocalTime timeNow = LocalTime.now();
        if(timeNow.isBefore(endTime)) {
            System.out.println("Lokata terminowa jeszcze trwa");
        }else{
            bankAccount.setAccountBalance(bankAccount.getAccountBalance() + termDeposit.calculateProfit());
        }

        //stan konta po zakończeniu lokaty
        System.out.printf("Saldo z lokatą terminową: %.2f", bankAccount.getAccountBalance());

    }
}