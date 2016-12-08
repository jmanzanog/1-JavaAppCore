package generico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public static void listarObjetos(List<? extends Object> lista){//List<? super Object
        for (Object o:lista){
            System.out.println(o.getClass().toString());
        }
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

            List list= new ArrayList();
            list.add(new Date());
            ClassGenerica.listarObjetos(list);
        }

    }
