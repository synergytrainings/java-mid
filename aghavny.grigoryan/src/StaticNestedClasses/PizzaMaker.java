package StaticNestedClasses;

public class PizzaMaker
{
    public static void main(String[] args){
    String [] components = {"Pepper", "Sausage" , "Cheese","Shanpinoen"};
   Pizza myPizza  = Pizza.newPizzaBuilder().setName("Diavolo").setStructure(components).build();
        String isSpicy = myPizza.isSpicyPizza() ? "spicy" : "not spicy";
        System.out.println(isSpicy);
    }
}