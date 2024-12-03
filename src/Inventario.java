import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Inventario {
    List<Producto> productos = new ArrayList<>();
    private final String archivo = "C:\\\\Users\\\\emarti4\\\\OneDrive - BANCO DE BOGOTA\\\\Escritorio\\\\BDB\\\\Cursos\\\\Fundamentos de programacion\\\\Taller productos tienda\\\\productos.txt\\\\";
    public void cargarInventario() {

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String categoria = datos[2];
                double precio = Double.parseDouble(datos[3]);
                int cantidad = Integer.parseInt(datos[4]);
                productos.add(new Producto(id, nombre, categoria, precio, cantidad));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Guardar inventario
    public void guardarInventario() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Producto producto : productos) {
                writer.write(producto.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo de inventario.");
        }
    }
    // Agregar un producto al inventario
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        guardarInventario();
    }

    // Actualizar un producto
    public void actualizarProducto(int id, Producto nuevoProducto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == id) {
                productos.set(i, nuevoProducto);
                guardarInventario();
                System.out.println("producto actualizado con exito");
                return;
            }
        }
    }
    // Eliminar un producto
    public void eliminarProducto(int id) {
        if (productos.removeIf(p -> p.getId() == id)) {
            guardarInventario();
            System.out.println("producto eliminado con exito");

        }
    }
    // Buscar productos
    public void buscarPorCategoria(String categoria) {
        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(producto);

            }
        }
    }
    public void buscarPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(producto);

            }
        }
    }
    public void buscarPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                System.out.println(producto);

            }
        }
    }
    // Calcular el producto más caro
    public void productoMasCaro() {

        Producto caro = Collections.max(productos, Comparator.comparingDouble(Producto::getPrecio));

        System.out.println("Producto más caro: " + caro);
        }

        //Generar reporte
    public void generarReporte() {
        double valorTotal = 0;
        for (Producto producto : productos) {
            valorTotal += producto.getPrecio() * producto.getCantidad();

        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\\\Users\\\\emarti4\\\\OneDrive - BANCO DE BOGOTA\\\\Escritorio\\\\BDB\\\\Cursos\\\\Fundamentos de programacion\\\\Taller productos tienda\\\\reporte_inventario.txt"))) {
            for (Producto producto : productos) {
                writer.write(producto.toString());

                writer.newLine();
            }
            writer.write("Valor total del inventario: " + valorTotal);

        } catch (IOException e) {
            System.err.println("Error al generar el reporte.");
        }
    }
    // Cantidad de productos por categoría
    public void cantidadPorCategoria(String categoria) {
        int total = 0;
        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {

                total += producto.getCantidad();

            }
        }
        System.out.println("Cantidad de productos en la categoría " + categoria + ": " + total);
    }


}








