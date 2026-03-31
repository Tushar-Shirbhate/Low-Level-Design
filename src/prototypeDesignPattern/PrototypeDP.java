package prototypeDesignPattern;

/**
 * Prototype interface defines the cloning method.
 */
interface Prototype {
    Prototype clone();
}

/**
 * BookPDP class implements Prototype to allow itself to be cloned.
 */
class BookPDP implements Prototype {
    private String title;
    private String author;
    private String publisher;

    public BookPDP(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    // Setter methods to modify the cloned object's properties
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public Prototype clone() {
        return new BookPDP(this.title, this.author, this.publisher);
    }

    @Override
    public String toString() {
        return "BookPDP{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}

public class PrototypeDP {
    public static void main(String[] args) {
        // Initializing a prototype book
        BookPDP book1 = new BookPDP("Design Patterns", "Erich Gamma", "Addison-Wesley");
        System.out.println(book1.toString());

        // Creating a new book by cloning the prototype and modifying it
        BookPDP book2 = (BookPDP) book1.clone();
        book2.setTitle("The Java Programming Language");
        book2.setAuthor("Ken Arnold");
        System.out.println(book2.toString());

    }
}
