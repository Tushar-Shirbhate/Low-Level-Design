package iteratorDesignPattern;

import java.util.ArrayList;
import java.util.List;

class BookWIDP{
    String title;
    boolean premium;

    public BookWIDP(String title, boolean premium) {
        this.title = title;
        this.premium = premium;
    }
}

class LibraryWIDP {
    private List<BookWIDP> books = new ArrayList<>();

    public void add(BookWIDP book){
        books.add(book);
    }

    // Normal Iteration
    public void printAllBooks(){
        for(int i=0; i<books.size(); i++){
            System.out.println(books.get(i).title);
        }
    }

    // Reverse Iteration
    public void printReverse(){
        for(int i=books.size()-1; i>=0; i--){
            System.out.println(books.get(i).title);
        }
    }

    // Filtered Iteration
    public void printPremiumBooks(){
        for(int i=0; i<books.size(); i++){
            if(books.get(i).premium){
                System.out.println(books.get(i).title);
            }
        }
    }
}

public class WithoutIteratorDP {
    public static void main(String[] args){
        LibraryWIDP libraryWIDP = new LibraryWIDP();
        libraryWIDP.add(new BookWIDP("Clean Code", true));
        libraryWIDP.add(new BookWIDP("Effective Java", true));
        libraryWIDP.add(new BookWIDP("Design Patterns", false));

        System.out.println("Normal Iteration:");
        libraryWIDP.printAllBooks();

        System.out.println("\nReverse Iteration:");
        libraryWIDP.printReverse();

        System.out.println("\nFiltered Iteration:");
        libraryWIDP.printPremiumBooks();
    }
}
