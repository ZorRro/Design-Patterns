/**
 * Created by dev on 16/5/17.
 */
public class TemplateUtility {
    public static void main(String[] args) {
        System.out.println("Preparing a Veg pizza");
        SamplePizza vegPizza = new VeggieSamplePizza();
        vegPizza.prepareSamplePizza();

        System.out.println("Preparing a Non-Veg Pizza");
        SamplePizza nonVegPizza = new NonVegSamplePizza();
        nonVegPizza.prepareSamplePizza();
    }
}

abstract class SamplePizza {

    final void prepareSamplePizza(){
        pickBread();
        warmUpBread();
        putIngredients();
        bakeWithCheese();
    }

    abstract public void pickBread();
    public final void warmUpBread(){
        System.out.println("Put the bread to warm up in the oven for 1 minute.");
    }
    public abstract void putIngredients();
    public void bakeWithCheese(){
        System.out.println("Bake the SamplePizza for 5 minutes with cheese.");
    }
}

class VeggieSamplePizza extends SamplePizza {
    @Override
    public void putIngredients() {
        System.out.println("Put Cabbage, Paneer .");
    }

    @Override
    public void pickBread(){
        System.out.println("Pick a thick bread.");
    }
}

class NonVegSamplePizza extends SamplePizza{
    @Override
    public void putIngredients() {
        System.out.println("Put meat, chicken .");
    }

    @Override
    public void pickBread(){
        System.out.println("Pick a thin bread.");
    }

}

