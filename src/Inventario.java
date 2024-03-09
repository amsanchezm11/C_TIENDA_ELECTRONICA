import java.util.*;

public class Inventario {

    //  METODOS

    // MOSTRAR PRODUCTOS

    public static void mostrarProductos(List<Producto>lista){
        for (Producto p:lista){
            System.out.println(p);
        }
    }

    // AGREGAR PRODUCTOS

    public static void agregarProducto(List<Producto> listaProductos){

        Scanner teclado = new Scanner(System.in);

        System.out.print("MARCA--> ");
        String marca = teclado.nextLine();

        System.out.println("MODELO--> ");
        String modelo = teclado.nextLine();

        System.out.print("PRECIO--> ");
        double precio = teclado.nextDouble();
        teclado.nextLine();

        System.out.print("CANTIDAD--> ");
        int cantidad = teclado.nextInt();
        teclado.nextLine();

        Producto productoAux = new Producto(marca,modelo,precio,cantidad);

        if (listaProductos.contains(productoAux)){
            System.out.println("[EL PRODUCTO YA EXISTE EN EL INVENTARIO][INTENTALO DE NUEVO]");
        }else {
            listaProductos.add(productoAux);
            System.out.println("[EL PRODUCTO HA SIDO AGREGADO CORRECTAMENTE]");
        }

    }

    //  BUSCAR PRODUCTOS
    public static void buscarProducto(List<Producto> listaProductos){

        String modelo, marca;

        System.out.println("¿PORQUE QUIERES BUSCAR? --> [1-MARCA][2-MODELO] ");
        Scanner teclado = new Scanner(System.in);

        switch (teclado.nextInt()){

            case 1 ->{
                teclado.nextLine();
                System.out.print("SELECCIONA LA MARCA-->");
                marca = teclado.nextLine();
                for (Producto p: listaProductos){
                    if (p.getMarca().equals(marca)){
                        System.out.println(p);
                    }
                }
            }
            case 2 ->{
                teclado.nextLine();
                System.out.print("SELECCIONA EL MODELO--> ");
                modelo = teclado.nextLine();
                for (Producto p: listaProductos){
                    if (p.getModelo().equals(modelo)){
                        System.out.println(p);
                    }
                }
            }
            default -> System.out.println("ERROR - OPCION NO VALIDA");

        }
    }

    // VENDER OBJETO

    public static void eliminarProducto(List<Producto>listaP){
        Scanner teclado = new Scanner(System.in);

        mostrarProductos(listaP);
        System.out.println("SELECCIONA EL PRODUCTO QUE SE HA VENDIDO:");
        int id = teclado.nextInt();

        Iterator<Producto> iter = listaP.iterator();

        while(iter.hasNext()){
            Producto p = iter.next();
            if (p.getId()==id){
                iter.remove();
            }
        }
    }

    //  VALOR TOTAL INVENTARIO

    public static void totalPrecioInventario(List<Producto>listaP){
        double total = 0;
        for (Producto p :listaP){
            total+=p.getPrecio();
        }
        System.out.println(total);
    }

    //  ACTUALIZAR PRECIO
    public static void actualizarPrecio(List<Producto>listaP){

        Scanner teclado = new Scanner(System.in);

        mostrarProductos(listaP);

        System.out.println("INDICA EL ID DEL PRODUCTO QUE QUIERES ACTUALIZAR:");
        int id = teclado.nextInt();

        for (Producto p:listaP){
            if (p.getId()==id){
                System.out.println("NUEVO PRECIO:");
                double nuevoPrecio = teclado.nextDouble();
                p.setPrecio(nuevoPrecio);
                System.out.println("[PRECIO ACTUALIZADO]");
                System.out.println("INFORMACION DEL PRODUCTO--> " + p);
            }
        }
    }

    //  VENDER PRODUCTO

    public static void venderProducto(List<Producto>listaP){
        Scanner teclado = new Scanner(System.in);

        mostrarProductos(listaP);
        System.out.println("\nINDICA EL ID PRODUCTO QUE SE QUIERE VENDER");

        int id = teclado.nextInt();

        for (Producto p: listaP){
            if (p.getId()==id){
                if (p.getStock()<=0){
                    System.out.println("NO HAY EXISTENCIAS SUFICIENTES");
                    System.out.println("INFORMACION DEL PRODUCTO--> " + p);
                }else {
                    p.setStock(p.getStock()-1);
                    System.out.println("Eliminando 1 unidad de Producto " + p.getId() + " del Stock");
                    System.out.println("INFORMACION DEL PRODUCTO--> " + p);
                }
            }
        }
    }

    //  VENDER PRODUCTO CON CANTIDAD
    public static void venderProducto2(List<Producto>listaP){
        Scanner teclado = new Scanner(System.in);

        mostrarProductos(listaP);
        System.out.print("\nINDICA EL ID PRODUCTO QUE SE QUIERE VENDER--> ");
        int id = teclado.nextInt();
        System.out.print("INDICA LA CANTIDAD QUE SE HA VENDIDO--> ");
        int cantidad = teclado.nextInt();

        for (Producto p: listaP){
            if (p.getId()==id){
                if (p.getStock()-cantidad<0){
                    System.out.println("NO HAY EXISTENCIAS SUFICIENTES");
                    System.out.println("INFORMACION DEL PRODUCTO--> " + p);
                }else {
                    p.setStock(p.getStock()-cantidad);
                    System.out.println("Eliminando " + cantidad + " unidades de Producto " + p.getId() + " del Stock");
                    System.out.println("INFORMACION DEL PRODUCTO--> " + p);
                }
            }
        }
    }

    public static void main(String[] args) {

        List<Producto> listaProductos = new ArrayList<>();

        Producto p1 = new Producto("Samsung", "Galaxy", 222.08, 8);
        Producto p2 = new Producto("Iphone", "Pro 12", 1500.08, 6);
        Producto p3 = new Producto("Realme", "Little 15", 2215.08, 10);
        Producto p4 = new Producto("Huawei", "Little 17", 356.22, 0);

        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4);


        // MENU PRINCIPAL

        Scanner teclado = new Scanner(System.in);

        boolean salir=false;

        do {
            System.out.println("-----MENU----");
            System.out.println("[1] - AGREGAR PRODUCTO");
            System.out.println("[2] - BUSCAR PRODUCTO");
            System.out.println("[3] - VENDER UN PRODUCTO");
            System.out.println("[4] - VENDER VARIAS CANTIDADES DE UN PRODUCTO");
            System.out.println("[5] - MOSTRAR INVENTARIO");
            System.out.println("[6] - VALOR TOTAL DE INVENTARIO");
            System.out.println("[7] - ACTUALIZAR PRECIO PRODUCTO");
            System.out.println("[8] - ELIMINAR UN PRODUCTO DEL INVENTARIO");
            System.out.println("[9] - SALIR");

            System.out.print("\n ELIGE UNA OPCION-->");

            switch (teclado.nextInt()){
                case 1 -> agregarProducto(listaProductos);
                case 2 -> buscarProducto(listaProductos);
                case 3 -> venderProducto(listaProductos);
                case 4 -> venderProducto2(listaProductos);
                case 5 -> mostrarProductos(listaProductos);
                case 6 -> totalPrecioInventario(listaProductos);
                case 7 -> actualizarPrecio(listaProductos);
                case 8 -> eliminarProducto(listaProductos);
                case 9 -> salir=true;
            }
        }while (!salir);


    }
}
