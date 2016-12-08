package singleton;

/**
 * Created by Jmanzano on 8/12/2016.
 */
public class ConectionSingleton {

    private static ConectionSingleton instanse= null;
    private ConectionSingleton(){

    }
    public static ConectionSingleton getInstanse(){
        if (instanse==null){
            instanse= new ConectionSingleton();
        }
        return instanse;
    }

    public static void main(String[] args) {

        ConectionSingleton conectionSingleton= ConectionSingleton.getInstanse();

    }

}
