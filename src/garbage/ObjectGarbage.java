package garbage;

/**
 * Created by Jmanzano on 7/12/2016.
 */
public class ObjectGarbage extends  Object {

    @Override
    protected  void finalize(){
        System.out.println("print before garbage collector");
    }
}
