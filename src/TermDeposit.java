import java.time.LocalTime;

public class TermDeposit {
    private int timeDeposit;
    private double amountDeposit;
    private double termPercent;
    private LocalTime startTime;

    public TermDeposit(int timeDeposit, double amountDeposit, double termPercent, LocalTime startTime) {
        this.timeDeposit = timeDeposit;
        this.amountDeposit = amountDeposit;
        this.termPercent = termPercent;
        this.startTime = startTime;
    }

    public double calculateProfit(){
        return amountDeposit * (1 + termPercent/100 * timeDeposit/12);
    }
}
