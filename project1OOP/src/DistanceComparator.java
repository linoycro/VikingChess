import java.util.Arrays;
import java.util.Comparator;

public class DistanceComparator {
    private ConcretePiece[] pieces;
    private ConcretePiece[][] board;
    private ConcretePiece[] dead;
    private boolean winner1;

    public DistanceComparator(ConcretePiece[][] board, ConcretePiece[] dead, boolean winner1) {
        this.board = board;
        this.dead = dead;
        this.winner1 = winner1;
        pieces = new ConcretePiece[38];
        makeArray();
    }

    public void makeArray() {
        int lp = 0;
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (board[i][j] != null) {
                    pieces[lp] = board[i][j];
                    lp++;
                }
            }
        }
        int j = 0;
        for (int i = lp; i < pieces.length; i++) {
            pieces[i] = dead[j];
            j++;
        }
        Arrays.sort(pieces, new MyComparator5());
        Arrays.sort(pieces, new MyComparator4());
        for (int i = 0; i < 10; i++) {
            if (pieces[i].getDistance() == pieces[i + 1].getDistance()) {
                if (pieces[i].getSerialNum() == pieces[i + 1].getSerialNum()) {
                    if (!(pieces[i].getOwner().isPlayerOne() == winner1)) {
                        ConcretePiece temp = pieces[i];
                        pieces[i] = pieces[i + 1];
                        pieces[i + 1] = temp;
                    }
                }
            }
        }
    }
    public void PrintPlayerDistance() {
        int i=0;
        while(i< pieces.length && pieces[i]!= null && pieces[i].getDistance()>0){
            if (pieces[i].getOwner().isPlayerOne()) {
                if (pieces[i].getSerialNum() == 7)
                    System.out.println("K" + pieces[i].getSerialNum() + ": " + pieces[i].getDistance() + " squares");
                else System.out.println("D" + pieces[i].getSerialNum() + ": " + pieces[i].getDistance() + " squares");
            } else {
                System.out.println("A" + pieces[i].getSerialNum() + ": " + pieces[i].getDistance() + " squares");
            }
            i++;
        }
        for (i=0; i<74; i++){
            System.out.print("*");
        }
        System.out.println("*");
    }

}

class MyComparator4 implements Comparator<ConcretePiece> {
    @Override
    public int compare(ConcretePiece a, ConcretePiece b) {
        // Custom comparison logic (descending order)
        if (a != null && b != null)
            return b.getDistance() - a.getDistance();
        return 0;
    }
}
class MyComparator5 implements Comparator<ConcretePiece> {
    @Override
    public int compare(ConcretePiece a, ConcretePiece b) {
        // Custom comparison logic (descending order)
        if (a != null && b != null)
            return a.getSerialNum() - b.getSerialNum();
        return 0;
    }
}