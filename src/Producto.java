import java.util.Objects;

public class Producto {

    private int id;
    private static int ids=0;
    private String marca;
    private String modelo;
    private double precio;
    private int stock;


    // CONSTRUCTOR
    public Producto(String marca, String modelo, double precio, int stock) {
        this.id = ++ids;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
    }

    // GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    // EQUALS Y HASCODE

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(marca, producto.marca) || Objects.equals(modelo, producto.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo);
    }


    // TO STRING


    @Override
    public String toString() {
        return "Producto{" +
                 id + "," +
                 marca + "," +
                modelo + "," +
                precio + "€ ," +
                 stock +
                '}';
    }
}
