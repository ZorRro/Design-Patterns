import java.util.ArrayList;

/**
 * Created by dev on 4/5/17.
 */
public class FactoryUtility {
    /**
     * This program demonstrates both factory and
     * abstract factory
     */

    public static void main(String[] args) {
        Address a = new Address("Ranjit" , "A3-602", "Handewadi Road");
        NYPizzaStore nyp = new NYPizzaStore();
        nyp.orderPizza("cheese", 3, a);
        nyp.orderPizza("clam", 1, a);
    }
}

class Address {
    String client;
    String flat;
    String road;

    private void setClient(String client) {
        this.client = client;
    }

    private void setFlat(String flat) {
        this.flat = flat;
    }

    private void setRoad(String road) {
        this.road = road;
    }

    public Address(String c, String f, String r){
        setClient(c);
        setFlat(f);
        setRoad(r);
    }

    @Override
    public String toString() {
        return "{ Client : " + client + ", Flat : " + flat + ", Road : " + road + "}";
    }
}

interface PizzaStore {
    public void orderPizza(String type, int quant, Address address);
    public ArrayList createPizza(String type, int quant);
    public void deliverPizza(ArrayList<Pizza> pizza, Address addr);
}

class NYPizzaStore implements PizzaStore {
    private ArrayList<Pizza> pizza;
    private IngredientFactory indf ;
    public NYPizzaStore(){
        this.indf = new NYIngredientFactory();
        this.pizza = null;
    }

    @Override
    public void orderPizza(String type, int quant, Address address) {
        this.pizza = createPizza(type, quant);
        deliverPizza(this.pizza, address);
    }

    @Override
    public ArrayList createPizza(String type, int quant) {
        ArrayList<Pizza> pizza = new ArrayList<Pizza>(quant);
        if("cheese".equals(type)){
            for (int i = 0; i < quant; i++) {
                System.out.println("Creating pizza: " + i);
                pizza.add( new CheesePizza(this.indf));
            }
        }else if("clam".equals(type)) {
            for (int i = 0; i < quant; i++) {
                System.out.println("Creating pizza: " + i);
                pizza.add( new ClamPizza(this.indf));
            }
        }
        return pizza;
    }

    @Override
    public void deliverPizza(ArrayList<Pizza> pizza, Address addr) {
        System.out.println(":: -- OUT FOR DELIVERY -- ::");
        System.out.println("Pizza : " + pizza );
        System.out.println("Address : " + addr );
        System.out.println("Quantity : " + pizza.size() );

    }

}


abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;
    public void bake(){
        System.out.println("Bake the pizza for 20 mins");
    }
    abstract void prepare();
    public void cut(){
        System.out.println("Cut the pizza into 6 pieces");
    }
    public void box(){
        System.out.println("Box the pizza");
    }
}

class CheesePizza extends Pizza {
    IngredientFactory inf;
    public CheesePizza(IngredientFactory inf) {
        this.inf = inf;
        this.name = "New York Style Cheese Pizza";
        this.prepare();
    }

    @Override
    void prepare() {
        this.dough = inf.createDough();
        this.cheese = inf.createCheese();
        this.sauce = inf.createSauce();
        System.out.println(this.name + " Created. ");
    }
}

class ClamPizza extends Pizza {
    IngredientFactory inf;
    public ClamPizza(IngredientFactory inf) {
        this.inf = inf;
        this.name = "New York Style Clam Pizza";
        this.prepare();
    }

    @Override
    void prepare() {
        this.cheese = inf.createCheese();
        this.sauce = inf.createSauce();
        System.out.println(this.name + " Created.");
    }
}

interface IngredientFactory {
    /**
     * This is the ABSTRACT FACTORY
     */

    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
}

interface Dough{}
interface Sauce{}
interface Cheese{}

class BigDough implements Dough {
    public BigDough(){
        System.out.println("Big Dough created");
    }
}

class SmallDough implements Dough {
    public SmallDough(){
        System.out.println("Small Dough created");
    }
}

class ThinSauce implements Sauce {
    public ThinSauce() {
        System.out.println("Thin Sauce applied");
    }
}

class ThickSauce implements Sauce {
    public ThickSauce() {
        System.out.println("Thick Sauce applied");
    }
}

class LightCheese implements Cheese {
    public LightCheese() {
        System.out.println("Light Cheese applied");
    }
}

class ExtraCheese implements Cheese {
    public ExtraCheese() {
        System.out.println("Extra Cheese applied");
    }
}

class NYIngredientFactory implements IngredientFactory {
    @Override
    public Dough createDough() {
        return new BigDough();
    }

    @Override
    public Sauce createSauce() {
        return new ThinSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ExtraCheese();
    }
}