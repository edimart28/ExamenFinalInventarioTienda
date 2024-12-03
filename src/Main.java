import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Inventario inventario = new Inventario();
        inventario.cargarInventario();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Buscar producto");
            System.out.println("5. Generar reporte");
            System.out.println("6. Cantidad de productos por categoría");
            System.out.println("7. Producto más caro");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("La sub opcion que ingresaste no existe, intentalo nuevamente");
                sc.next();
                System.out.println("Ingrese una sub opcion");
            }
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // Agregar producto
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Categoría: ");
                    String categoria = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    Producto nuevoProducto = new Producto(id, nombre, categoria, precio, cantidad);
                    inventario.agregarProducto(nuevoProducto);
                    System.out.print("producto agregado con exito ");
                    break;

                case 2:
                    // Actualizar producto
                    System.out.print("ID del producto a actualizar: ");
                    int idActualizar = sc.nextInt();
                    sc.nextLine(); // consumir nueva línea
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nueva categoría: ");
                    String nuevaCategoria = sc.nextLine();
                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = sc.nextDouble();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = sc.nextInt();
                    Producto productoActualizado = new Producto(idActualizar, nuevoNombre, nuevaCategoria, nuevoPrecio, nuevaCantidad);
                    inventario.actualizarProducto(idActualizar, productoActualizado);
                    System.out.println("************************************************************************************************");
                    System.out.println("                                                                                                ");
                    break;
                case 3:
                    // Eliminar producto
                    System.out.print("ID del producto a eliminar: ");
                    int idEliminar = sc.nextInt();
                    inventario.eliminarProducto(idEliminar);
                    break;
                case 4:
                    //Buscar producto
                    do {
                        System.out.println("\nDesea buscar por:");
                        System.out.println("1. Categoria");
                        System.out.println("2. Nombre");
                        System.out.println("3. Id");
                        System.out.println("4. Volver");
                        System.out.println("5. Salir");

                        while (!sc.hasNextInt()) {
                            System.out.println("La sub opcion que ingresaste no existe, intentalo nuevamente");
                            sc.next();
                            System.out.println("Ingrese una sub opcion");
                        }
                        int subOpcion = 0;
                        subOpcion = sc.nextInt();
                        switch (subOpcion) {
                            case 1:
                                // Buscar por categoría
                                System.out.print("Ingrese categoria: ");
                                sc.nextLine();
                                String categoriaBuscar = sc.nextLine();
                                inventario.buscarPorCategoria(categoriaBuscar);
                                break;
                            case 2:
                                //Buscar por nombre
                                System.out.print("Ingrese nombre: ");
                                sc.nextLine();
                                String nombreBuscar = sc.nextLine();
                                inventario.buscarPorNombre(nombreBuscar);
                                break;
                            case 3:
                                //Buscar por Id
                                System.out.print("Ingrese ID: ");
                                sc.nextLine();
                                int IdBuscar = sc.nextInt();
                                inventario.buscarPorId(IdBuscar);
                                break;
                            case 4:
                                System.out.println("----------------------------------------------------------------------------------------");
                                System.out.println("                           Volver al menu anterior                                     -");
                                System.out.println("----------------------------------------------------------------------------------------");
                                break;
                            case 5:
                                // Salir
                                System.out.println("Saliendo del sistema...");
                                sc.close();
                                return;
                            default:
                                System.out.println("opcion no valida");
                                return;


                        }


                    } while (opcion != 4);

                    break;
                case 5:
                    // Generar reporte
                    inventario.generarReporte();
                    System.out.println("Reporte generado en 'C:\\\\Users\\\\emarti4\\\\OneDrive - BANCO DE BOGOTA\\\\Escritorio\\\\BDB\\\\Cursos\\\\Fundamentos de programacion\\\\Taller productos tienda\\\\reporte_inventario.txt'");
                    break;
                case 6:
                    // Cantidad por categoría
                    System.out.print("Categoría: ");
                    sc.nextLine();
                    String categoriaCantidad = sc.nextLine();
                    inventario.cantidadPorCategoria(categoriaCantidad);
                    break;
                case 7:
                    // Producto más caro
                    inventario.productoMasCaro();
                    break;
                case 8:
                    // Salir
                    System.out.println("Saliendo del sistema...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.print("Presione enter para continuar...");
            sc.nextLine();
            sc.nextLine();
        }
    }
}







