import javafx.scene.layout.StackPane;

/**
 * Created by dev on 21/5/17.
 * The state pattern is similar to strategy pattern
 *
 */
public class StateUtility {


}

interface Person {
    String getName();
}

interface State {
    void dial(String number);
    void hangup();
    void putCoin(int count);
    void ejectCoin();
}
// STATES OF THE PHONE : ON-CALL, IDLE, RINGING


class Phone {
    State state;
    int balance;

    public void Phone(State state){
        this.state = state;
    }

    public void dial(String number){
        state.dial(number);
    }

    public void hangup(){
        state.hangup();
    }

    public void putCoin(int count) {
        state.putCoin(count);
    }

    public void ejectCoin() {
        state.ejectCoin();
    }

    private setState(State state){
        this.state = state;
    }
}

class OncallState implements State {
    Phone phone;
    OncallState(Phone phone){
        this.phone = phone;
    }

    @Override
    public void dial(String number) {
        System.out.println("You are still in a call. End the current call to dial " + number);
    }

    @Override
    public void hangup() {
        System.out.println("Thank you for using the Phone Service !!");
        if(phone.balance > 0) {
            System.out.println("Collect the remaining balance :" + phone.balance);
        } else {
            System.out.println("The amount was fully utilized.");
        }
        phone.setState(phone.idleState);
    }

    @Override
    public void putCoin(int count) {
        System.out.println("Your balance is Rs" + count + "/- . Continue the call...");
    }

    @Override
    public void ejectCoin() {
        System.out.println("The coins will be returned once the call ends.");
    }
}

class PhoneIdleState implements State {
    private Phone phone;
    PhoneIdleState(Phone phone){
        this.phone = phone;
    }
    @Override
    public void dial(String number) {
        if ()
    }

    @Override
    public void hangup() {

    }

    @Override
    public void putCoin(int count) {

    }

    @Override
    public void ejectCoin() {

    }
}

class PhoneRingingState implements State {
    @Override
    public void dial(String number) {

    }

    @Override
    public void hangup() {

    }

    @Override
    public void putCoin(int count) {

    }

    @Override
    public void ejectCoin() {

    }
}

