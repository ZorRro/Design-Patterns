import java.rmi.Remote;

/**
 * Created by dev on 11/5/17.
 * COMMAND PATTERN
 */

public class CommandUtility {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl rc = new RemoteControl(light);
        rc.keyPressed();
        rc.keyPressed();
        rc.undoPressed();
        rc.keyPressed();
        rc.keyPressed();
        rc.undoPressed();
        rc.keyPressed();
    }
}


interface Command{
    void execute();
    void undo();
}

class Light{
    public void on(){
        System.out.println("The Light is ON.");
    }

    public void off(){
        System.out.println("The Light is OFF.");
    }
}

class LightOnCommand implements Command {
    Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }


}

class LightOffCommand implements Command {
    Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}

class NoCommand implements Command {
    @Override
    public void execute() {
//        do nothing
    }

    @Override
    public void undo() {
//        do nothing
    }
}

class RemoteControl {

    Command slot, undo;
    boolean state;
    Light light;
    public RemoteControl(Light light) {
        this.state = false;
        this.slot = new NoCommand();
        this.undo = new NoCommand();
        this.light = light;
    }
    public void setCommand(Command command) {
        this.slot = command;
    }

    public void keyPressed(){
        if(state) {
            state = false;
            this.setCommand(new LightOffCommand(this.light));
            slot.execute();
        }else{
            state = true;
            this.setCommand(new LightOnCommand(this.light));
            slot.execute();
        }
    }

    public void undoPressed(){
        state = !state;
        slot.undo();
    }

}

