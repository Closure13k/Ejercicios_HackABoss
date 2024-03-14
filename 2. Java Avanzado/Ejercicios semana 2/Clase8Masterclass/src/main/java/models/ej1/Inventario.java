package models.ej1;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Inventario<T extends Producto> {

    private List<T> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(T producto) {
        productos.add(producto);
    }

    public List<T> getProductos() {
        return productos;
    }

    public void setProductos(List<T> productos) {
        this.productos = productos;
    }

    public void mostrarInventario() {
        System.out.println("Productos en inventario:");
        for (T producto : productos) {
            System.out.println(producto);
        }
    }

}
