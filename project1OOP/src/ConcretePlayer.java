

public class ConcretePlayer implements Player{

    private boolean player1;
    private int wins;

    public ConcretePlayer(boolean player1){
        this.player1=player1;
        wins=0;
    }

    @Override
    public boolean isPlayerOne() {
        return player1;
    }

    @Override
    public int getWins() {
        return wins;
    }

    public void addWIn(){
        wins++;
    }

    public void setPlayer1(){
        player1 = !player1;
    }


}
