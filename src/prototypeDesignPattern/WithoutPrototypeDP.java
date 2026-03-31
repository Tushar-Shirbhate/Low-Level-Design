package prototypeDesignPattern;

class BookWPDP {
    private String title;
    private String author;
    private String publisher;

    public BookWPDP(String title, String author, String publisher){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "BookWPDP{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
public class WithoutPrototypeDP {
    public static void main(String[] args){
        BookWPDP book1 = new BookWPDP("Design Patterns", "Erich Gamma", "Addison-Wesley");
        System.out.println(book1.toString());

        BookWPDP book2 = new BookWPDP("The Java Programming Language", "Ken Arnold", "Addison-Wesley");
        System.out.println(book2.toString());
    }
}
