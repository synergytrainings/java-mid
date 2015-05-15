package StaticNestedClasses;
public class Pizza
{
    private String Name;
    private String Structure;
    private String[] components;
    private boolean isSpicyPizza;
    
    private Pizza(){}

    public String getName(){
        return this.Name;
    }
    
    public String getStructure(){
        return this.Structure;
    }
    
    public  String[] getComponents () {
        return this.components;
    }
    
 	public boolean isSpicyPizza(){
      return this.isSpicyPizza;
    }
  
    public static PizzaBuilder newPizzaBuilder() {
        return new Pizza().new PizzaBuilder();
    }
    
    public class PizzaBuilder{
        private PizzaBuilder(){}
        
        public PizzaBuilder setName(String Name){
            Pizza.this.Name = Name;
            return this;
        }
        public PizzaBuilder setStructure(String[] components){
//            Pizza.this.components = components;
        	InterfaceSpicyFood checker = new InterfaceSpicyFood() {
                public boolean isSpicy(String[] components){
                    for(String item : components){
                        if(item.toLowerCase().equals("pepper")){
                            return true;
                            }
                    }
                    return false;
                }
            };
          	Pizza.this.isSpicyPizza = checker.isSpicy(components);

            return this;
        }
        
        public Pizza build() {
            return Pizza.this;
        }
    }
}