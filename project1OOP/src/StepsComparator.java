import java.util.Arrays;
import java.util.Comparator;

public class StepsComparator {

    private ConcretePiece[] pieces;
    private ConcretePiece[][] board;
    private ConcretePiece[] dead;
    private boolean winner1;

    public StepsComparator(ConcretePiece[][] board, ConcretePiece[] dead, boolean winner1) {
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
        Arrays.sort(pieces, new MyComparator3());
    }


    public void PrintArraySteps() {
        String w, l;
        if (winner1) {
            w = "D";
            l = "A";
        } else {
            w = "A";
            l = "D";
        }
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i] != null && pieces[i].getOwner().isPlayerOne() == winner1 && pieces[i].getSteps() != null && !pieces[i].getSteps().isEmpty()) {
                System.out.print(w + pieces[i].getSerialNum() + ": [");
                pieces[i].printSteps();
                System.out.println("]");
            }
        }
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i] != null && pieces[i].getOwner().isPlayerOne() != winner1 &&  pieces[i].getSteps() != null && !pieces[i].getSteps().isEmpty() ) {
                System.out.print(l + pieces[i].getSerialNum() + ": [");
                pieces[i].printSteps();
                System.out.println("]");
            }
        }
        for (int i = 0; i < 74; i++) {
            System.out.print("*");
        }
        System.out.println("*");
    }
}

    class MyComparator3 implements Comparator<ConcretePiece> {
        @Override
        public int compare(ConcretePiece a, ConcretePiece b) {
            // Custom comparison logic (descending order)
            if (a != null && b != null)
                return a.getSerialNum() - b.getSerialNum();
            return 0;
        }
    }



