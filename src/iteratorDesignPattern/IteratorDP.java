package iteratorDesignPattern;

import java.util.ArrayList;
import java.util.List;

class BookIDP{
    String title;
    boolean premium;

    public BookIDP(String title, boolean premium) {
        this.title = title;
        this.premium = premium;
    }
}

interface BookIterator{
    boolean hasNext();
    BookIDP next();
}

class NormalIterator implements BookIterator{
    private List<BookIDP> books;
    private int index=0;

    public NormalIterator(List<BookIDP> books){
        this.books = books;
    }

    @Override
    public boolean hasNext(){
        return index < books.size();
    }

    @Override
    public BookIDP next(){
        return books.get(index++);
    }
}

class ReverseIterator implements BookIterator{
    private List<BookIDP> books;
    private int index;

    public ReverseIterator(List<BookIDP> books){
        this.books = books;
        this.index = books.size()-1;
    }

    @Override
    public boolean hasNext(){
        return index>=0;
    }

    @Override
    public BookIDP next(){
        return books.get(index--);
    }
}

class PremiumIterator implements BookIterator{
    private List<BookIDP> books;
    private int index=0;

    public PremiumIterator(List<BookIDP> books){
        this.books = books;
    }

    @Override
    public boolean hasNext(){
        while(index<books.size()){
            if(books.get(index).premium){
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public BookIDP next(){
        return books.get(index++);
    }
}

interface BookCollection{
    BookIterator createIterator(String type);
}

class Library implements BookCollection{
    private List<BookIDP> books = new ArrayList<>();

    public void addBook(BookIDP book){
        books.add(book);
    }

    @Override
    public BookIterator createIterator(String type){
        switch (type.toUpperCase()) {
            case "NORMAL" :
                return new NormalIterator(books);
            case "REVERSE" :
                return new ReverseIterator(books);
            case "PREMIUM":
                return new PremiumIterator(books);
            default:
                throw new IllegalArgumentException("Invalid iterator type: " + type);
        }
    }
}
public class IteratorDP {
    public static void main(String[] args){
        Library library = new Library();
        library.addBook(new BookIDP("Clean Code", true));
        library.addBook(new BookIDP("Effective Java", true));
        library.addBook(new BookIDP("Design Patterns", false));

        BookIterator normalIterator = library.createIterator("NORMAL");
        System.out.println("Normal Iteration:");
        while(normalIterator.hasNext()){
            BookIDP book = normalIterator.next();
            System.out.println(book.title);
        }
        System.out.println();

        BookIterator reverseIterator = library.createIterator("REVERSE");
        System.out.println("Reverse Iteration:");
        while(reverseIterator.hasNext()){
            BookIDP book = reverseIterator.next();
            System.out.println(book.title);
        }
        System.out.println();
        
        BookIterator premiumIterator = library.createIterator("PREMIUM");
        System.out.println("Premium Iteration:");
        while(premiumIterator.hasNext()){
            BookIDP book = premiumIterator.next();
            System.out.println(book.title);
        }
    }
}
