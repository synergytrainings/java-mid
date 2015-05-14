package BuilderPattern;

/**
 * Created by Anna on 15.05.2015.
 */
public class App {
    public static void main(String[] args) {
        System.out.println(new  User.UserBuilder("Anna", "Petrosyan")
                .age(26)
                .phone("phone")
                .address("address")
                .build());
    }
}
