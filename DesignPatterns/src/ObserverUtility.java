import java.util.ArrayList;

/**
 * Created by dev on 28/4/17.
 */
public class ObserverUtility {
    public static void main(String[] args) {
        WeatherData wd = new WeatherData();
        Observer1 ob1 = new Observer1();
        Observer2 ob2 = new Observer2();
        wd.addObserver(ob1);
        wd.addObserver(ob2);

        wd.setState("36" , "12.5", "34");
        wd.setState("38" , "18.5", "36");
        wd.setState("39" , "20.5", "41");
        wd.setState("37.5" , "18.5", "36");
        wd.setState("30" , "16.5", "34");
    }
}

interface Subject {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}

class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    public String temp, pressure, humidity;
    public WeatherData() {
        temp = "Initial temp";
        humidity = "Initial Humidity";
        pressure = "Initial Pressure";
        observers = new ArrayList<>();
    }
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if ( i > 0 ) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        System.out.println("Notification sending ...");
        for (Observer o: observers
             ) {
            o.update(this);
        }
    }

    public void setState(String t, String p, String h){
        System.out.println("Setting a new state for the Subject.");
        this.temp = t;
        this.pressure = p;
        this.humidity = h;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Weather Data";
    }
}

interface Observer {
    public void update(WeatherData weatherData);
}

class Observer1 implements Observer {
    private String temp, pressure, humidity;
    public void update(WeatherData weatherData) {
        System.out.println("Observer 1 : Notification received from "
                + weatherData.toString());
        this.temp = weatherData.temp;
        this.pressure = weatherData.pressure;
        this.humidity = weatherData.humidity;
        display();
    }

    public void display(){
        System.out.println("T : " + this.temp + " P : " + this.pressure
                + " H : " + this.humidity);
    }
}


class Observer2 implements Observer {
    private String temp, pressure, humidity;
    public void update(WeatherData weatherData) {
        System.out.println("Observer 2 : Notification received from "
                + weatherData.toString());
        this.temp = weatherData.temp;
        this.pressure = weatherData.pressure;
        this.humidity = weatherData.humidity;
        display();
    }

    public void display(){
        System.out.println("Temperature : " + this.temp + " Pressure : "
                + this.pressure + " Humidity : " + this.humidity);
    }
}