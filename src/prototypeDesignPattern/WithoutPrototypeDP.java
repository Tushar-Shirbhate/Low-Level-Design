package prototypeDesignPattern;

class BookWPDP {
    private String title;
    private String author;
    private String publisher;
    private String category;
    private String language;
    private String format;

    public BookWPDP(String title, String author, String publisher,
                           String category, String language, String format) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.language = language;
        this.format = format;
    }

    @Override
    public String toString() {
        return "BookWPDP{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", category='" + category + '\'' +
                ", language='" + language + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
public class WithoutPrototypeDP {
    public static void main(String[] args){
        BookWPDP book1 = new BookWPDP("Clean Code", "Robert C. Martin", "Prentice Hall", "Programming", "English", "Paperback");
        System.out.println(book1);

        BookWPDP book2 = new BookWPDP("Effective Java", "Joshua Bloch", "Addison-Wesley", "Programming", "English", "Hardcover");
        System.out.println(book2);
    }
}
