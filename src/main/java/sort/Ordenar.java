package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Jmanzano on 8/12/2016.
 */
public class Ordenar {
    public static void ordenar(){
        List<String> listaNombres = new ArrayList<>();
        listaNombres.add("Dago");
        listaNombres.add("Yofana");
        listaNombres.add("Maria");
        listaNombres.add("Ana");

        Collections.sort(listaNombres, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String nombre:listaNombres ) {
            System.out.println(nombre);
        }
    }

    public static void main(String[] args) {
        Ordenar.ordenar();
    }
}
