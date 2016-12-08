package thread;


/**
 * Created by Jmanzano on 7/12/2016.
 */
public class Hilo implements Runnable {

    @Override
    public void run() {
        System.out.println("run hilo");
    }
    public static void main(String[] args) throws InterruptedException {
        Hilo hilo= new Hilo();
       Thread thread= new Thread(hilo);
       thread.start();
       thread.sleep(3*1000);

        System.out.println("despues");

    }
}
