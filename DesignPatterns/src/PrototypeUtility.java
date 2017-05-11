/**
 * Created by dev on 19/4/17.
 */
public class PrototypeUtility {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p1 = new Prototype("Tina" , "female");
        Prototype p2 = p1.replicate();
        System.out.println("Person 1 " + p1 + "Cloned : " + p2);

    }
}

class Prototype implements Cloneable {
    private String name, gender;

    public Prototype(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    protected Prototype replicate() throws CloneNotSupportedException {
        Prototype p = (Prototype)(this.clone());
        return p;
    }
}