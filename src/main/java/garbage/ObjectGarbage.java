package garbage;

/**
 * Created by Jmanzano on 7/12/2016.
 */
public class ObjectGarbage extends  Object {

    @Override
    protected  void finalize(){
        System.out.println("print before garbage collector");
    }

    public static void main(String[] args) {

        ObjectGarbage objectGarbage= new ObjectGarbage();
        objectGarbage= null;
        System.gc();


    }
}
