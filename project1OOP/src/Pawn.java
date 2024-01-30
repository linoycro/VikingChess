public class Pawn extends ConcretePiece{

    public Pawn(ConcretePlayer owner, String type, int serialNum) {
        super(owner, type, serialNum);
    }

    public Pawn(ConcretePiece c){
        super(c);
    }
}




