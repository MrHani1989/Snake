public class Main {
    static int threadSpeed = 50;
    static boolean run = true;

    /**
     * Main function
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        run();
    }

    /**
     * Here were the game will start till run is false
     * @throws InterruptedException
     */
    public static void run() throws InterruptedException{
        Window window = new Window();
        while (run) {
            window.revalidate();
            window.repaint();
            Thread.sleep(threadSpeed);
        }
    }
}
