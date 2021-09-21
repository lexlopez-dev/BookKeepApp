package com.alexandroid.bookkeep;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;
    
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;


    public Utils() {
        if(null == allBooks) {
            allBooks = new ArrayList<>();
            initData();
        }

        if(null == alreadyReadBooks) {
            alreadyReadBooks = new ArrayList<>();
        }

        if(null == wantToReadBooks) {
            wantToReadBooks = new ArrayList<>();
        }

        if(null == currentlyReadingBooks) {
            currentlyReadingBooks = new ArrayList<>();
        }

        if(null == favoriteBooks) {
            favoriteBooks = new ArrayList<>();
        }
    }

    private void initData() {
        //TODO: add initial data
        allBooks.add(new Book(1, "1Q84", "Haruki Murakami", 1350, "https://images-na.ssl-images-amazon.com/images/I/71hhB1Rwk4L.jpg", "A work of maddening brilliance", "Long Description"));
        allBooks.add(new Book(2, "The Hobbit", "J. R. R. Tolkien", 310, "https://images-na.ssl-images-amazon.com/images/I/91b0C2YNSrL.jpg", "The Hobbit, or There and Back Again is a children's fantasy novel by English author J. R. R. Tolkien.", "The Hobbit is set within Tolkien's fictional universe and follows the quest of home-loving Bilbo Baggins, the titular hobbit, to win a share of the treasure guarded by Smaug the dragon. Bilbo's journey takes him from his light-hearted, rural surroundings into more sinister territory."));
        allBooks.add(new Book(3, "Harry Potter and the Philosopher's Stone", "\tJ. K. Rowling", 223, "https://images-na.ssl-images-amazon.com/images/I/81YOuOGFCJL.jpg", "Harry Potter and the Philosopher's Stone is a fantasy novel written by British author J. K. Rowling.", "The first novel in the Harry Potter series and Rowling's debut novel, it follows Harry Potter, a young wizard who discovers his magical heritage on his eleventh birthday, when he receives a letter of acceptance to Hogwarts School of Witchcraft and Wizardry. Harry makes close friends and a few enemies during his first year at the school, and with the help of his friends, he faces an attempted comeback by the dark wizard Lord Voldemort, who killed Harry's parents, but failed to kill Harry when he was just 15 months old."));

    }

    public static Utils getInstance() {
        if(null != instance) {
            return instance;
        }else {
            instance = new Utils();
            return instance;
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public Book getBookById(int id) {
        for (Book b: allBooks) {
            if(b.getId() == id) {
                return b;
            }
        }

        return null;
    }
}
