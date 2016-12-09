package thread;

/**
 * Created by Jmanzano on 8/12/2016.
 */
public class HiloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("hilo Thread");
        }

    }
}
