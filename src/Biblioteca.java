import java.util.HashMap;

public class Biblioteca {
    private HashMap<String, Libro> libros;

    public Biblioteca(){
        libros= new HashMap<>();
    }

    public void agregarLibro(Libro libro){
        libros.put(libro.getIsbn(), libro);
        System.out.println("Libro agregado:  "+ libro.getTitulo());
    }

    public void eliminarLibro(String isbn) {
        Libro libro = libros.remove(isbn);
        if (libro != null) {
            System.out.println("Libro eliminado: " + libro.getTitulo());
        } else {
            System.out.println("No se encontró un libro con el ISBN: " + isbn);
        }
    }

    public Libro buscarLibro(String isbn){
        return libros.get(isbn);
    }

    public void mostrarLibros(){
        if(libros.isEmpty()){
            System.out.println("La biblioteca esta vacia. ");
        }else{
            System.out.println("Libros en la Biblioteca: ");
            for(Libro libro: libros.values()){
                System.out.println(libro);
            }
        }
    }
}
