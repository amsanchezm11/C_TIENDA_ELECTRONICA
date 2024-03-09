import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Inventario {

    private Scanner teclado = new Scanner(System.in);

    //  METODOS

    // AGREGAR PRODUCTOS

    public void agregarProducto(List<Producto> listaProductos){
        System.out.println("MARCA: ");
        String marca = teclado.nextLine();

        System.out.println("MODELO: ");
        String modelo = teclado.nextLine();

        System.out.println("PRECIO: ");
        double precio = teclado.nextDouble();

        System.out.println("CANTIDAD: ");
        int cantidad = teclado.nextInt();

        Producto productoAux = new Producto(marca,modelo,precio,cantidad);

        if (listaProductos.contains(productoAux)){
            System.out.println("El producto ya está registrado. Intentalo de nuevo.");
        }else {
            listaProductos.add(productoAux);
            System.out.println("EL producto ha sido agregado correctamente.");
        }



    }

    //  BUSCAR PRODUCTOS
    public void buscarProducto(List<Producto> listaProductos, String modelo, String marca){

        //Comparator<Producto> comparador = Comparator.comparing(Producto::getMarca).thenComparing(Producto::getModelo);

        for (Producto p: listaProductos){
            if (p.getMarca().equals(marca) || p.getModelo().equals(modelo)){
                System.out.println(p);
            }
        }
    }


    public static void main(String[] args) {
        List<Producto> listaProductos = new ArrayList<>();
    }
}
