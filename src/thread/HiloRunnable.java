package thread;


/**
 * Created by Jmanzano on 7/12/2016.
 */
public class HiloRunnable implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i <10 ; i++) {
            System.out.println("hilo Runnable");
        }

    }

}
