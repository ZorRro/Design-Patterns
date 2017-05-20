import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by dev on 18/5/17.
 */
public class IteratorUtility {
    public static void main(String[] args) {
        BreakfastMenu bfMenu = new BreakfastMenu();
        DinerMenu dmenu = new DinerMenu();
        bfMenu.addItem(new MenuItem("Vada", 10, true));
        bfMenu.addItem(new MenuItem("Idli", 20, true));
        bfMenu.addItem(new MenuItem("Dosa", 35, true));
        bfMenu.addItem(new MenuItem("Pudi", 25, true));
        bfMenu.addItem(new MenuItem("Bacon", 70, false));


        dmenu.addItem(new MenuItem("Veg-Pulao", 125, true));
        dmenu.addItem(new MenuItem("Chicken-Biryani", 160, false));
        dmenu.addItem(new MenuItem("Fried-Rice", 110, true));
        dmenu.addItem(new MenuItem("Mutton Kofta", 180, false));
        dmenu.addItem(new MenuItem("Chicken Handi", 150, false));
        dmenu.addItem(new MenuItem("Kashmiri Pulao", 125, true));
        Crawler bfIterator = bfMenu.createIterator();
        Crawler dIterator = dmenu.createIterator();
        bfIterator.crawlAll();
        dIterator.crawlAll();
    }
}

class MenuItem {
    String name;
    int price;
    boolean veggie;
    public MenuItem(){
        this.name = "";
        this.price= 0;
        this.veggie = false;
    }

    public MenuItem(String name, int price, boolean veggie){
        this.name = name;
        this.price= price;
        this.veggie = veggie;
    }

    public String toString(){
        return this.getName() + ": " + this.getPrice() + ", " + (isVeggie() ? " Veg" : " Non-Veg.");
    }

    String getName(){
        return this.name;
    }
    int getPrice(){
        return this.price;
    }
    boolean isVeggie(){
        return this.veggie;
    }
}

interface Crawler {
    MenuItem getNext();
    boolean hasNext();
    void crawlAll();

}

class DinerMenuIterator implements Crawler {
    ArrayList<MenuItem> list;
    int currentItem ;
    DinerMenuIterator(ArrayList<MenuItem> items) {
        this.list = items;
        currentItem = -1;
    }

    @Override
    public MenuItem getNext() {
        if(currentItem == -1){
            return list.get(++currentItem);
        }else if (this.hasNext()){
            return list.get(++currentItem);
        }else{
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        if( currentItem < list.size()-1 )
            return true;
        else
            return false;
    }

    @Override
    public void crawlAll() {
        System.out.println("Diner Menu Items: ");
        while(this.hasNext())
            System.out.println(" :: " + this.getNext());
    }
}


class BreakFastIterator implements Crawler {
    MenuItem[] list;
    int currentItem ;
    BreakFastIterator(MenuItem[] items){
        this.list = items;
        currentItem = -1;
    }

    @Override
    public MenuItem getNext() {
        if (this.hasNext())
            return list[++currentItem];
        else
            return null;
    }

    @Override
    public boolean hasNext() {
        if(currentItem < list.length && list[currentItem+1] != null)
            return true;
        else
            return false;
    }

    @Override
    public void crawlAll() {
        System.out.println("BreakFast Menu Items: ");
        while(this.hasNext()) {
            System.out.println(":: " + this.getNext());
        }
    }
}

interface Menu {
    Crawler createIterator();
}



class DinerMenu implements Menu {
    ArrayList<MenuItem> items;

    DinerMenu(){
        this.items = new ArrayList<MenuItem>();
    }

    public void addItem(MenuItem m) {
        items.add(m);
    }

    @Override
    public Crawler createIterator() {
        return new DinerMenuIterator( items );
    }
}



class BreakfastMenu implements Menu {
    MenuItem[] items;
    int size ;

    BreakfastMenu(){
        items = new MenuItem[10];
        size = -1;
    }

    void addItem(MenuItem item) {
        if(size < 9)
            items[++size] = item;
        else
            System.out.println("No more items to accomodate.");
    }

    @Override
    public Crawler createIterator() {
        return new BreakFastIterator(items);
    }
}
