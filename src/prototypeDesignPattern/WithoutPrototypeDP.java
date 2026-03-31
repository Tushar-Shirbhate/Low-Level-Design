package prototypeDesignPattern;

class Book {
    private String title;
    private String author;
    private String publisher;

    public Book(String title, String author, String publisher){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
public class WithoutPrototypeDP {
    public static void main(String[] args){
        Book book1 = new Book("Atomic Habits", "James Clear", "Avery Publishing");
        System.out.println(book1.toString());

        Book book2 = new Book("Clean Code", "Robert C. Martin", "Prentice Hall");
        System.out.println(book2.toString());

        Book book3 = new Book("Design Patterns", "Erich Gamma", "Addison-Wesley");
        System.out.println(book3.toString());

        Book book4 = new Book("The Java Programming Language", "Ken Arnold", "Addison-Wesley");
        System.out.println(book4.toString());
    }
}
