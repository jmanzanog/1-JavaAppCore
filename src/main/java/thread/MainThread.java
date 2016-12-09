package thread;

/**
 * Created by Jmanzano on 8/12/2016.
 */
public class MainThread {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1= new Thread(new HiloRunnable());
        thread1.start();
        //thread1.sleep(3000);
        HiloThread thread2 = new HiloThread();
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {

                    System.out.println("hilo Anonimo");
                }
            }
        });
        thread3.start();
        thread3.join();//asegurar que el hilo 3 se ejecute antes que el siguiente for

  //      thread3.sleep(10);
        for (int i = 0; i <10 ; i++) {
            System.out.println("hilo Main");
        }

        /* ExecutorService executorService= Executors.newFixedThreadPool(1);
        Future<?> taFuture= executorService.submit(thread2);
       while (taFuture.isDone()){
            System.out.println("tarea 2 terminada");
            break;
        }*/

    }
}
