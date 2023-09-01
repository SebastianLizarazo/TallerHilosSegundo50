package co.edu.uptc.logic;

public class Bet {
    private double amountToBet;
    private double amountWinned;

    public Bet(double amountToBet) {
        this.amountToBet = amountToBet;
        this.amountWinned = 0;
    }

    public double getAmountToBet() {
        return amountToBet;
    }

    public void setAmountToBet(double amountToBet) {
        this.amountToBet = amountToBet;
    }

    public double getAmountWinned() {
        return amountWinned;
    }

    public void setAmountWinned(double amountWinned) {
        this.amountWinned = amountWinned;
    }


}
