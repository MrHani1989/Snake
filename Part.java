public class Part {
    int x;
    int y;
    private Part next = null;
    private Part previous = null;

    public Part(int x, int y) {
        // @todo assign the argument x to the object's x

        // @todo assign the argument y to the object's y

    }

    public void setPrevious(Part previous) {
        this.previous = previous;
    }

    public Part getPrevious() {
        return previous;
    }

    public void setNext(Part next) {

        this.next = next;
    }

    public Part getNext() {
        //@todo return next
    }
}
