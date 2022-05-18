import java.util.Random;

public class Food {
    int x;
    int y;
    int size = 5;

    public Food(){
        // @todo call newPosition function

        // @todo call newSize function

    }

    public void newPosition(){
        this.x  = (new Random()).nextInt(650-10)+10;
        this.y  = (new Random()).nextInt(450-10)+10;
        System.out.format("X={%d},Y={%d}\n",this.x,this.y);
    }

    public void newSize(){
        this.size  = (new Random()).nextInt(15)+1;
    }
}
