import java.awt.Color;
import java.awt.Graphics;

public class Snake {
    Part head = null;
    Part tail = null;
    Color color = Color.green;
    static int speed = 5;
    Food food = new Food();
    static int partsCount = 0;

    static int direction = 37;

    public Snake() {
        head = new Part(780 / 2, 500 / 2);
        tail = head;
        ++partsCount;
    }

    public void draw(Graphics g) {
        //loop inside each part and draw it
        //@todo check if the object's head is null then return;

        //fill the food
        g.setColor(Color.cyan);
        g.fillRect(food.x, food.y, food.size * 5, food.size * 5);
        //fill first part
        g.setColor(Color.YELLOW);
        g.fillRect(head.x, head.y, 10, 10);
        //look for another part to draw
        Part next = head.getNext();
        g.setColor(color);
        while (next != null) {
            //draw the next part
            g.fillRect(next.x, next.y, 10, 10);
            //update next var to have next part
            next = next.getNext();
        }
        //stop the game after coloring with red
        if (color.equals(Color.red)) {
            //@todo assign the value false to the Main's run property
        }
    }

    public void move() {
        //check if the snake head on the position of food
        if ((food.x >= head.x - food.size * 5 && food.x <= head.x + food.size * 5) &&
                (food.y >= head.y - food.size * 5 && food.y <= head.y + food.size * 5)
        ) {
            //prize will be received based on its size
            int count = 0;
            do {
                //add new part to the tail of snake based on the snake direction
                //define & init a new part as a prize from eating the food
                Part prize = new Part(tail.x, tail.y);
                //set the previous as the current tail
                prize.setPrevious(tail);
                //set the next for the tail to the prize
                tail.setNext(prize);
                //now update the tail to be the prize which is the last part added to the snake
                tail = prize;
                //@todo increase the count by one

                //@todo increase the partsCount by one

            } while (count < food.size);
            //make the game harder
            if (Main.threadSpeed - food.size / 5 > 0)
                Main.threadSpeed -= food.size / 5;
            else
                Main.threadSpeed = 1;
            //write the result to the text
            Window.text.setText("Game Speed is (" + Main.threadSpeed +  ")\t\tSnake Parts (" + Snake.partsCount + ")");
            //relocate the food again
            food.newPosition();
            food.newSize();
        }

        //each part should take the position of the previous part like a history
        Part last = tail;
        while (last != null && last.getPrevious() != null) {
            last.x = last.getPrevious().x;
            last.y = last.getPrevious().y;
            //move to next part
            last = last.getPrevious();
        }

        //update the head location toward the direction
        switch (direction) {
            case 37:
                head.x -= speed;
                break;
            case 38:
                head.y -= speed;
                break;
            case 39:
                head.x += speed;
                break;
            case 40:
                head.y += speed;
                break;
        }

        //correct the position of x & y if there is an overflow out ot the board size
        if (head.x > 780)
            head.x = 0;
        if (head.x < 0)
            head.x = 780;

        if (head.y > 500)
            head.y = 0;
        if (head.y < 0)
            head.y = 500;

        //check if the head position cross over another part then stop the game
        Part next = head.getNext();
        while (next != null) {
            if (head.x == next.x && head.y == next.y) {
                this.color = Color.red;
                food.size = 0;
            }
            next = next.getNext();
        }
    }
}
