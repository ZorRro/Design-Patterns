

/**
 * Created by dev on 19/4/17.
 */
public class SingletonUtility {
    public static void main(String[] args) {
        Singleton inst = Singleton.getInstance();
        System.out.println("Hashcode for first instance " + inst.hashCode());
        Singleton inst2 = Singleton.getInstance();
        System.out.println("Hashcode for second instance " + inst2.hashCode());

    }
}

/**
 * Singleton class with volatile instance variable
 */
class Singleton {
    private static volatile Singleton _instance = null;
    private Singleton(){}
    public static Singleton getInstance() {
        if ( _instance == null ) {
            /* This can be used for
            * THREAD SAFETY
            */
            //synchronize(Singleton.class)
            //if (_instance == null)
            System.out.println("Creating a new instance");
            _instance = new Singleton();
        }
        return _instance;
    }
}
