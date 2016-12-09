package thread;

/**
 * Created by Jmanzano on 8/12/2016.
 */
public class HiloThread extends Thread {
    @Override
    public void run() {
        try {
            this.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("se durmio el hilo 3 seg");
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println("hilo Thread");
        }

    }
}
