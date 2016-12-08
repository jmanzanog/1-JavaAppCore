package generico;

/**
 * Created by Jmanzano on 7/12/2016.
 */
public class ClassGenerica<T> {
    private T objeto;

    public ClassGenerica(T objeto) {
        this.objeto = objeto;
     }
    public void printTipo(){
        System.out.println(objeto.getClass().getCanonicalName());
    }
    public  static <T> String metodoGen(T x){
        if (x instanceof String){
            System.out.println("es de tipo String");
        }

        return "no es de tipo String";
    }
    public static void main(String[] args) {
            ClassGenerica <Object> classGenerica= new ClassGenerica<Object>("s");
            classGenerica.printTipo();
            System.out.println(ClassGenerica.metodoGen(333));
        }

    }
