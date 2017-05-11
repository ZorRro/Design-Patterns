import jdk.internal.dynalink.MonomorphicCallSite;

/**
 * Created by dev on 29/4/17.
 */
public class DecoratorUtility {
    public static void main(String[] args) {
        Beverage bv = new HouseBlend();
        Beverage bv1 = new MochaDecorator(bv, 2);
        System.out.println(bv1);


        Beverage bv2 = new DarkRoast();
        Beverage bv3 = new MilkDecorator(bv2, 1);
        System.out.println(bv3);
    }

}


abstract class Beverage {
    public float cost;
    public String description;
    public abstract String getDescription();
    public abstract float getCost();
    @Override
    public String toString() {
        return this.description;
    }
}

class HouseBlend extends Beverage {
    public HouseBlend(){
        this.description = "HouseBlend Hot";
        this.cost = 10.0f;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public float getCost() {
        return this.cost;
    }
}

class DarkRoast extends Beverage {
    public DarkRoast(){
        this.description = "DarkRoast Hot";
        this.cost = 15.0f;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public float getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return this.description;
    }
}

class Decaf extends Beverage {
    public Decaf(){
        this.description = "Decaf Hot";
        this.cost = 20;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public float getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return this.description;
    }
}


class MilkDecorator extends Beverage {
    private Beverage beverage;
    int quant;
    public MilkDecorator(Beverage beverage, int quant) {
        this.beverage = beverage;
        this.cost = quant * 5;
        this.description = ""+quant + " Milk";
        this.description = beverage.getDescription() + this.description;
    }

    @Override
    public float getCost() {
        return this.beverage.getCost() + this.cost;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}

class MochaDecorator extends Beverage {
    private Beverage beverage;
    int quant;
    public MochaDecorator(Beverage beverage, int quant) {
        this.beverage = beverage;
        this.cost = quant * 3;
        this.description = ""+quant + " Mocha";
        this.description = beverage.getDescription() + this.description;
    }

    @Override
    public float getCost() {
        return this.beverage.getCost() + this.cost;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}


