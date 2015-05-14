package pavel.midtraining;

/**
 * This is a sample implementation of Builder pattern
 */
public class Vehicle {
    private final String type;
    private final String model;
    private final int wheels;
    private final int doors;
    private final int seats;

    private Vehicle(Builder builder) {
        this.type = builder.type;
        this.model = builder.model;
        this.wheels = builder.wheels;
        this.doors = builder.doors;
        this.seats = builder.seats;
    }

    @Override
    public String toString() {
        return String.format("%s {\n type : %s\n model : %s\n wheels : %d\n doors : %d\n seats : %d\n }",
                            this.getClass().getSimpleName(), type, model, wheels, doors, seats);
    }

    public static class Builder {
        private final String type;
        private String model = "Default_Model";
        private int wheels = 0;
        private int doors = 0;
        private int seats = 1;

        public Builder(String type) {
            this.type = type;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder wheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public Builder doors(int doors) {
            this.doors = doors;
            return this;
        }

        public Builder seats(int seats) {
            this.seats = seats;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
