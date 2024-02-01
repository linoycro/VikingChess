import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SquarsComparator {

    private ConcretePiece[][] board;
    private ConcretePiece[] pieces;
    private ConcretePiece[] dead;
    private ArrayList<Position> squars = new ArrayList<Position>();

    private Position[][] positions = new Position[11][11];

    public SquarsComparator(Position[][] positions) {
        this.positions = positions;
        makeArray();
    }

    public void makeArray() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (positions[i][j].getStepped() >= 2)
                    squars.add(positions[i][j]);
            }
        }
        Collections.sort(squars, new ComparatorY());
        Collections.sort(squars, new ComparatorX());
        Collections.sort(squars, new ComparatorSquars());
    }

    public void printArray(){
        if (squars != null && !squars.isEmpty()) {
            for (int i = 0; i < squars.size(); i++) {
                if (squars.get(i) != null)
                    System.out.println(squars.get(i).stringPos() + squars.get(i).getStepped() + " pieces");
            }
        }
        for (int i = 0; i < 75; i++) {
            System.out.print("*");
        }
    }
}

class ComparatorSquars implements Comparator<Position> {
    @Override
    public int compare(Position a, Position b) {
        if (a != null && b != null)
            return b.getStepped() - a.getStepped();
        return 0;
    }
}

class ComparatorX implements Comparator<Position> {
    @Override
    public int compare(Position a, Position b) {
        if (a != null && b != null)
            return a.getX() - b.getX();
        return 0;
    }
}

class ComparatorY implements Comparator<Position> {
    @Override
    public int compare(Position a, Position b) {
        if (a != null && b != null)
            return a.getY() - b.getY();
        return 0;
    }
}

