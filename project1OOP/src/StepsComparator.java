import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.ToIntFunction;

public class StepsComparator {

    private ArrayList <ConcretePiece> attacker, deffenser;
    private ConcretePiece[][] board;
    private ConcretePiece[] dead;
    private ConcretePiece k;
    static boolean winner1;

    public StepsComparator(ConcretePiece[][] board, ConcretePiece[] dead, boolean winner1) {
        this.board = board;
        this.dead = dead;
        this.winner1 = winner1;
        attacker = new ArrayList <ConcretePiece>();
        deffenser = new ArrayList <ConcretePiece>();
        makeArray();
    }


    public void makeArray() {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].getOwner().isPlayerOne()) {
                        if (board[i][j].getSerialNum() == 7)
                            k = board[i][j];
                        deffenser.add(board[i][j]);
                    }
                    else attacker.add(board[i][j]);
                }
            }
        }
        for (int i = 0; i < dead.length; i++) {
            if (dead[i] != null) {
                if (dead[i].getOwner().isPlayerOne())
                    deffenser.add(dead[i]);
                else attacker.add(dead[i]);
            }
        }
        Collections.sort(attacker, new MyComparator3());
        Collections.sort(deffenser, new MyComparator3());



    }


    public void PrintArraySteps() {

        if (winner1) {
            System.out.print("K7: [");
            k.printSteps();
            System.out.println("]");
            for (int i = 0; i < deffenser.size(); i++) {
                if (deffenser.get(i)!= null && deffenser.get(i).getSteps()!= null && !deffenser.get(i).getSteps().isEmpty() && deffenser.get(i).getSerialNum() != 7) {
                    System.out.print("D" + deffenser.get(i).getSerialNum() + ": [");
                    deffenser.get(i).printSteps();
                    System.out.println("]");
                }

            }
            for (int i = 0; i < attacker.size(); i++) {
                if (attacker.get(i)!= null && attacker.get(i).getSteps()!= null && !attacker.get(i).getSteps().isEmpty()) {
                    System.out.print("A" + attacker.get(i).getSerialNum() + ": [");
                    attacker.get(i).printSteps();
                    System.out.println("]");
                }
            }
        }

        else {
            for (int i = 0; i < attacker.size(); i++) {
                if (attacker.get(i)!= null && attacker.get(i).getSteps()!= null && !attacker.get(i).getSteps().isEmpty()) {
                    System.out.print("A" + attacker.get(i).getSerialNum() + ": [");
                    attacker.get(i).printSteps();
                    System.out.println("]");
                }

            }
            System.out.print("K7: [");
            k.printSteps();
            System.out.println("]");
            for (int i = 0; i < deffenser.size(); i++) {
                if (deffenser.get(i)!= null && deffenser.get(i).getSteps()!= null && !deffenser.get(i).getSteps().isEmpty() && deffenser.get(i).getSerialNum() != 7) {
                    System.out.print("D" + deffenser.get(i).getSerialNum() + ": [");
                    deffenser.get(i).printSteps();
                    System.out.println("]");
                }
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

//            if (a != null && b != null)
               if (a.getSteps() != null && b.getSteps() != null)
                  if (!a.getSteps().isEmpty() && !b.getSteps().isEmpty()) {
                      if (a.getSteps().size() == b.getSteps().size())
                      {
                          return -Integer.compare(a.getSerialNum(),b.getSerialNum());
                      }
                      return Integer.compare(a.getSteps().size(), b.getSteps().size());
                  }
            return 0;
        }
    }
//class MyComparatorWinner implements Comparator<ConcretePiece> {
//    @Override
//    public int compare(ConcretePiece a, ConcretePiece b) {
//        if (!a.getSteps().isEmpty() && !b.getSteps().isEmpty()) {
//                    if (a.getSteps().size() > b.getSteps().size())
//                        return 1;
//                    if (a.getSteps().size() == b.getSteps().size())
//                        return a.getSerialNum() - b.getSerialNum();
//                    return -1;
//                }
//        return 0;
//    }
//}
//

class MyComparatorByNum implements Comparator<ConcretePiece> {

    @Override
    public int compare(ConcretePiece a, ConcretePiece b) {

        if (a != null && b != null)
             {
                 if (a.getSerialNum()< b.getSerialNum())
                     return -1;
                 if (b.getSerialNum()<a.getSerialNum())
                     return 1;
             }

        return 0;
    }
}