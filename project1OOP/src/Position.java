public class Position {

    private int x, y;
    private int stepped;
    public Position (int x, int y){
        this.x=x;
        this.y=y;
        stepped=0;
    }

    public Position (int x, int y, int stepped){
        this.x=x;
        this.y=y;
        this.stepped=stepped;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }


    public void setY(int y){
        this.y = y;
    }

    public void addStep(){
        stepped++;
    }

    public void removeStep(){
        stepped--;
    }


    public int getStepped(){
        return stepped;
    }

    public void printPos(){
        System.out.print("(" + x + ", " + y + ")");
    }


}
