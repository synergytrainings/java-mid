package pavel.midtraining;

/**
 * Class that represents use case of builder
 */
public class Runner {

    public static void main(String[] args){
        Vehicle vehicle = new Vehicle.Builder("Car").model("Ferrari").wheels(4).doors(2).build();
        System.out.print(vehicle);
    }
}
