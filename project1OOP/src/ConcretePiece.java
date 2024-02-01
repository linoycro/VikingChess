import java.util.ArrayList;

public abstract class ConcretePiece implements Piece {

    private ConcretePlayer owner;
    private String type;
    private int kills;
    private int serialNum;
    private ArrayList<Position> steps;
    private int distance;
//    private static boolean winner1;


    public ConcretePiece(ConcretePlayer owner, String type, int serialNum) {
        this.owner = owner;
        this.type = type;
        this.serialNum= serialNum;
        kills = 0;
        steps = new ArrayList<>();
        distance=0;
//        this.winner1=winner1;
    }

    public ConcretePiece(ConcretePiece c) {
        this.owner = c.owner;
        this.type = c.type;
        this.serialNum= c.serialNum;
        kills = c.kills;
        distance=c.distance;
    }


    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public String getType() {
        return type;
    }

    public int getKills() {
        return kills;
    }
    public void setKills(){
        //System.out.println("Kill");
        kills = kills + 1;
    }
    public int getDistance() {
        return distance;
    }

    public ArrayList<Position> getSteps(){
        return steps;
    }

    public void printSteps(){
        if (steps != null && !steps.isEmpty()) {
            steps.get(0).printPos();
            for (int i = 1; i < steps.size(); i++) {
                System.out.print(", ");
                steps.get(i).printPos();
            }
        }
    }

    public boolean steppedOn(Position p){
        for (int i=0; i<steps.size(); i++)
            if(steps.get(i).getX()==p.getX()&&steps.get(i).getY()==p.getY())
                return true;
        return false;
    }

    public void addStep(Position p) {
        steps.add(p);
        int length = steps.size();
        if (length == 2) {
            if (p.getY() == steps.get(0).getY()) {
                distance = Math.abs(p.getX() - steps.get(0).getX());
            } else {
                distance = Math.abs(p.getY() - steps.get(0).getY());
            }
        } else if (length > 2) {
            if (p.getY() == steps.get(length - 2).getY()) {
                distance += Math.abs(p.getX() - steps.get(length - 2).getX());
            } else {
                distance += Math.abs(p.getY() - steps.get(length - 2).getY());
            }
        }
    }

    public void removeStep(Position p) {
        steps.remove(steps.size()-1);
        int length = steps.size();
        if (length == 2) {
            if (p.getY() == steps.get(0).getY()) {
                distance = Math.abs(p.getX() - steps.get(0).getX());
            } else {
                distance = Math.abs(p.getY() - steps.get(0).getY());
            }
        } else if (length > 2) {
            if (p.getY() == steps.get(length - 2).getY()) {
                distance += Math.abs(p.getX() - steps.get(length - 2).getX());
            } else {
                distance += Math.abs(p.getY() - steps.get(length - 2).getY());
            }
        }
    }
    public int getSerialNum() {
        return serialNum;
    }

    @Override
    public String toString()
    {
        return "" + getSerialNum();
    }
}



