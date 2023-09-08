package co.edu.uptc.logic;

public class GameController {


    public static Double calculateVictory(ThreadCount runOne, ThreadCount runTwo, ThreadCount runThree, Bet currentBet) {
        if (runOne.getImageName().equals(runTwo.getImageName()) && runOne.getImageName().equals(runThree.getImageName())){
            currentBet.setAmountWinned(currentBet.getAmountToBet()*3);
        } else if (runOne.getImageName().equals(runTwo.getImageName()) || runOne.getImageName().equals(runThree.getImageName())
                   || runTwo.getImageName().equals(runThree.getImageName()) ) {
            currentBet.setAmountWinned(currentBet.getAmountToBet()*2);
        }else{
            currentBet.setAmountWinned(0);
        }
        return currentBet.getAmountWinned();
    }

    public boolean isTheGameOver(ThreadCount runOne, ThreadCount runTwo, ThreadCount runThree) {
        if (runOne.isState() && runTwo.isState() && runThree.isState()){
            return false;
        }
        return true;
    }
}
