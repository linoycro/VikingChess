import org.junit.platform.engine.support.descriptor.FileSystemSource;

import java.util.Arrays;
import java.util.Comparator;


    public class KillComparator {
        private ConcretePiece[][] board;
       private  ConcretePiece[] pieces;

        private ConcretePiece [] dead;

        private boolean winner1;
        public KillComparator(ConcretePiece [][] board, boolean winner1, ConcretePiece[] dead) {
           this.board=board;
           pieces = new ConcretePiece[37];
           this.winner1=winner1;
           this.dead=dead;
           makeArray();
        }

        public void makeArray() {
            int lp = 0;
            for(int i=0; i<=10; i++) {
                for(int j=0;j<=10; j++) {
                    if(board[i][j]!=null) {
                        pieces[lp]=board[i][j];
                        lp++;
                    }
                }
            }
            int j=0;
            for (int i=lp; i<pieces.length; i++) {
                pieces[i] = dead[j];
                j++;
            }
            Arrays.sort(pieces, new MyComparator2());
            Arrays.sort(pieces, new MyComparator());
            for(int i=0; i<10; i++) {
                if(pieces[i].getKills()==pieces[i+1].getKills()) {
                    if(pieces[i].getSerialNum()==pieces[i+1].getSerialNum())
                    {
                        if(!(pieces[i].getOwner().isPlayerOne()==winner1)) {
                            ConcretePiece temp = pieces[i];
                            pieces[i]=pieces[i+1];
                            pieces[i+1]=temp;
                        }
                    }
                }
            }
      }

        public void PrintArrayKills()
        {
            int i=0;
            while(i< pieces.length && pieces[i]!= null && pieces[i].getKills()>0){
                    if (pieces[i].getOwner().isPlayerOne()) {
                        System.out.println("D" + pieces[i].getSerialNum() + ": " + pieces[i].getKills() + " kills");
                    } else {
                        System.out.println("A" + pieces[i].getSerialNum() + ": " + pieces[i].getKills() + " kills");
                    }
                    i++;
            }
            for (i=0; i<74; i++){
                System.out.print("*");
            }
            System.out.println("*");
        }






}

    class MyComparator implements Comparator<ConcretePiece> {
        @Override
        public int compare(ConcretePiece a, ConcretePiece b) {
            // Custom comparison logic (descending order)
           if (a!=null&&b!=null)
                return b.getKills()-a.getKills();
           return 0;
        }

//        public int compareByWin(ConcretePiece a, ConcretePiece b){
//            if (())
//        }
}

class MyComparator2 implements Comparator<ConcretePiece> {
    @Override
    public int compare(ConcretePiece a, ConcretePiece b) {
        // Custom comparison logic (descending order)
        if (a!=null&&b!=null)
            return a.getSerialNum()-b.getSerialNum();
        return 0;
    }

}



