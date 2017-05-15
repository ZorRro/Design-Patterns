/**
 * Created by dev on 14/5/17.
 */
public class AdapterUtility {
    public static void main(String[] args) {
        Dam d = new Dam(100);
        PublicDistribution pd = new PublicDistribution(d.capacity);
        Dam disAdapter = new Adapter(pd);
        disAdapter.release();
    }
}

class Dam {
    int capacity;

    public Dam(){
        this.capacity = 20;
    }

    public Dam(int cap) {
        this.capacity = cap;
    }

    public void release(){
        System.out.println("Releasing water from Dam: " + this.capacity);
    }
}

class PublicDistribution {
    int capacity;
    Integer[] plines;
    public PublicDistribution(int capacity){
        this.capacity = capacity;
        this.plines = new Integer[10];
    }


    public void distribute(){
        for(int i=0; ; i++){
            if( this.capacity == 0 ) break;
            plines[i] = new Integer(10);
            System.out.println("Distributing to public lines : " + this.capacity);
            this.capacity -= 10;
        }
    }
}


class Adapter extends Dam {
    PublicDistribution pd;
    public Adapter(PublicDistribution pd) {
        this.pd = pd;
    }

    public void release () {
        pd.capacity = this.capacity;
        pd.distribute();
    }
}
