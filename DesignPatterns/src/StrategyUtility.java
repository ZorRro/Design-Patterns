/**
 * Created by dev on 27/4/17.
 *
 * ENCAPSUALATE ASPECTS THAT CHANGE
 * PREFER COMPOSITION OVER INHERITANCE
 * PROVIDES A FAMILY OF ALGORITHMS WHICH
 * IT ENCAPSULATES AND CAN VARY INDEPENDENTLY
 * FROM THE CLIENT THAT USES IT
 *
 * WEAPON BEHAVIOR IS THE ASPECT THAT VARIES
 * STRATEGYUTILITY IS THE CLIENT THAT USES
 */
public class StrategyUtility {
    public static void main(String[] args) {
        Character king = new King();
        king.fight();

        Character queen = new Queen("Queen" , "Self Protect");
        queen.introduce();
        queen.fight();

        Character troll = new Troll("Jhar'jhal" , "Gorilla Warefare");
        troll.introduce();
        troll.fight();

        king.setWeapon(new Axe());
        king.introduce();
        king.fight();
    }
}

/**
 * Base class for all the characters
 */
abstract class Character {
    public Character() {
    }

    protected WeaponBehavior weapon;
    public String address;
    public String skill;

    public Character(String address, String skill) {
        this.address = address;
        this.skill = skill;
    }

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }

    public void introduce(){}

    public void fight () {
        weapon.use();
    }
}

class King extends Character {
    public King(){
        this.weapon = new Sword();
    }
    public King(String address, String skill) {
        super(address, skill);
        this.weapon = new Sword();

    }

    @Override
    public void introduce() {
        System.out.println("I'm the King of the States.");
        System.out.println("Skills : " + this.skill);
    }

}

class Queen extends Character {
    public Queen() {
        this.weapon = new Knife();
    }
    public Queen(String address, String skill) {
        super(address, skill);
        this.weapon = new Knife();
    }

    @Override
    public void introduce() {
        System.out.println("I'm the Queen of the States.");
        System.out.println("Skills : " + this.skill );
    }
}

class Troll extends Character {
    public Troll() {
        this.weapon = new Axe();
    }
    public Troll(String address, String skill) {
        super(address, skill);
        this.weapon = new Axe();
    }

    @Override
    public void introduce() {
        System.out.println("I'm the Troll of the Lands.");
        System.out.println("Skills : " + this.skill );
    }
}

interface WeaponBehavior {
    public void use();
}

class Axe implements WeaponBehavior {
    @Override
    public void use() {
        System.out.println("Chop the guts out !1");
    }
}

class Sword implements WeaponBehavior {
    @Override
    public void use() {
        System.out.println("Cut them down !!");
    }
}

class Knife implements WeaponBehavior {
    @Override
    public void use() {
        System.out.println("Stab it hard !!");
    }
}