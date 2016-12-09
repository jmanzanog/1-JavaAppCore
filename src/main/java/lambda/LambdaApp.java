package lambda;

/**
 * Created by Jmanzano on 8/12/2016.
 */
public class LambdaApp {


    public void calcular() {
		/*Operacion operacion = new Operacion() {
			@Override
			public double calcularPromedio(double n1, double n2) {
				return (n1 + n2) / 2;
			}
		};
		System.out.println(operacion.calcularPromedio(2, 3));*/

        Operacion operacion = (double x, double y) -> (x+y)/2;
        System.out.println(operacion.calcular(2, 3));
    }



    public static void main(String[] args) {
        LambdaApp app = new LambdaApp();
        //app.ordernar();
        app.calcular();
    }
}
