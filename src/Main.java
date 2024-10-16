import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcion;

        do {
            System.out.println("+------------------------------------------------------+");
            System.out.println("|                 Gestión de Biblioteca                |");
            System.out.println("+------------------------------------------------------+");
            System.out.println("|                      Opciones                        |");
            System.out.println("+------------------------------------------------------+");
            System.out.println("| 1. Agregar libro                                     |");
            System.out.println("| 2. Buscar libro                                      |");
            System.out.println("| 3. Mostrar todos los libros                          |");
            System.out.println("| 4. Mostrar la cantidad de libros                     |");
            System.out.println("| 5. Actualizar información de un libro                |");
            System.out.println("| 6. Eliminar libro                                    |");
            System.out.println("| 7. Salir                                             |");
            System.out.println("+------------------------------------------------------+");
            System.out.print("Elige una opción: ");
            opcion = lectura.nextInt();
            lectura.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = lectura.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = lectura.nextLine();
                    System.out.print("Ingrese el ISBN del libro: ");
                    String isbn = lectura.nextLine();

                    Libro libro = new Libro(titulo, autor, isbn);
                    biblioteca.agregarLibro(libro);
                    break;

                case 2:
                    System.out.print("Ingrese el ISBN del libro a buscar: ");
                    String isbnBuscar = lectura.nextLine();
                    Libro libroEncontrado = biblioteca.buscarLibro(isbnBuscar);
                    if (libroEncontrado != null) {
                        System.out.println("Libro encontrado: " + libroEncontrado);
                    } else {
                        System.out.println("No se encontró un libro con el ISBN: " + isbnBuscar);
                    }
                    break;

                case 3:
                    biblioteca.mostrarLibros();
                    break;

                case 4:
                    biblioteca.mostrarTotalLibros();
                    break;

                case 5:
                    System.out.print("Ingrese el ISBN del libro a actualizar: ");
                    String isbnActualizar = lectura.nextLine();

                    if (biblioteca.buscarLibro(isbnActualizar) != null) {
                        System.out.print("Ingrese el nuevo título del libro: ");
                        String nuevoTitulo = lectura.nextLine();
                        System.out.print("Ingrese el nuevo autor del libro: ");
                        String nuevoAutor = lectura.nextLine();

                        biblioteca.actualizarLibro(isbnActualizar, nuevoTitulo, nuevoAutor); // Actualizar libro
                    } else {
                        System.out.println("No se encontró un libro con el ISBN: " + isbnActualizar);
                    }
                    break;



                case 6:
                    System.out.print("Ingrese el ISBN del libro a eliminar: ");
                    String isbnEliminar = lectura.nextLine();
                    biblioteca.eliminarLibro(isbnEliminar);
                    break;

                case 7:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;


                default:
                    System.out.println("Opción no válida. Por favor, elija una opción entre 1 y 5.");
                    break;
            }
        } while (opcion != 7);

    }
}
