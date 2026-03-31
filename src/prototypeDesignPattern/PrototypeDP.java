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
    private String category;
    private String language;
    private String format;

    public BookPDP(String title, String author, String publisher,
                    String category, String language, String format) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.language = language;
        this.format = format;
    }

    // Copy constructor
    public BookPDP(BookPDP other) {
        this.title = other.title;
        this.author = other.author;
        this.publisher = other.publisher;
        this.category = other.category;
        this.language = other.language;
        this.format = other.format;
    }

    @Override
    public Prototype clone(){
        return new BookPDP(this);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "BookPDP{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", category='" + category + '\'' +
                ", language='" + language + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}

public class PrototypeDP {
    /*
        https://chatgpt.com/c/69c97458-3334-8324-be4f-69acb0d686e8
     */
    public static void main(String[] args) {
        // Initializing a prototype book
        BookPDP book1 = new BookPDP("Clean Code", "Robert C. Martin", "Prentice Hall", "Programming", "English", "Paperback");
        System.out.println(book1);

        // Creating a new book by cloning the prototype and modifying it
        BookPDP book2 = (BookPDP) book1.clone();
        book2.setTitle("Effective Java");
        book2.setAuthor("Joshua Bloch");
        book2.setPublisher("Addison-Wesley");
        book2.setFormat("Hardcover");
        System.out.println(book2);

    }
}
