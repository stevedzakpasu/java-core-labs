package week1.concurrency;

public class Resource {
    private final int id;

    public Resource(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
