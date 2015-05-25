package pavel.midtraining.model;

/**
 * Class represents model object, could be any kind of resource
 */
public class Resource {

    private final String name;
    private final int capacity;

    public Resource(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s {\n name : %s\n capacity : %d\n }",
                this.getClass().getSimpleName(), name, capacity);
    }
}
