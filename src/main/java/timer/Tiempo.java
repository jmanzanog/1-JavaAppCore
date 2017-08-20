package timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Jmanzano on 20/08/2017.
 */
public class Tiempo  {

    private Timer timer = new Timer();
    private int segundos=0;

    public static void main(String[] args) {
        Tiempo t = new Tiempo();
        t.Contar();
        while (t.getSegundos()<60){
            System.out.println(t.getSegundos());
        }

    }

    //Crea un timer, inicia segundos a 0 y comienza a contar
    public void Contar()
    {
        this.segundos=0;
        timer = new Timer();
        timer.schedule(new Contador(), 0, 1000);
    }
    //Detiene el contador
    public void Detener() {
        timer.cancel();
    }
    //Metodo que retorna los segundos transcurridos
    public int getSegundos()
    {
        return this.segundos;
    }

    //Clase interna que funciona como contador
    class Contador extends TimerTask {
        public void run() {
            segundos++;
            System.out.println("segundo: " + segundos);
        }
    }
}
