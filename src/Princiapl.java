import java.util.Collections;
import java.util.Scanner;

public class Princiapl {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el limite de la tarjeta");
        double limite = lectura.nextDouble();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);

        int salir = 1;
        while (salir !=0 ){
            System.out.println("Escriba la descripcion de la compra");
            String descripcion = lectura.next();

            System.out.println("Escriba el valor de la compra");
            double valor = Double.valueOf(lectura.next());

            Compra compra = new Compra(valor, descripcion);
            boolean compraRealizado = tarjeta.lanzarCompra(compra);

            if(compraRealizado){
                System.out.println("Compra realizada");
                System.out.println("Escriba 0 para salir  o 1 para continuar");
                salir = lectura.nextInt();
            }   else {
                System.out.println("Saldo Insuficiente");
                salir = 0;
            }
        }
        System.out.println("*********************************");
        System.out.println("COMPRAS REALIZADAS\n");
        Collections.sort(tarjeta.getListaCompra());
        for(Compra compra: tarjeta.getListaCompra()){
            System.out.println(compra.getDescripcion() + " - " + compra.getValor());
        }
        System.out.println("\n********************************");
        System.out.println("\nSaldo de tarjeta " + tarjeta.getSaldo());
    }

}
