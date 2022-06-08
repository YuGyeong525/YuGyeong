abstract class Shape {
    private Shape next = null;

    public Shape() {
    }

    public void setNext(Shape obj) {
        this.next = obj;
    }

    public Shape getNext() {
        return this.next;
    }

    public abstract void draw();
}