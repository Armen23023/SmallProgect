package storige;

import models.Book;
import models.User;

public class BookStorage {
    private Book[] books = new Book[10];
    private models.Book[] Book = new Book[10];


    private int size = 0;

    public void add(Book book) {
        if (size >= books.length)
            extend();
        books[size] = book;
        size++;
    }


    private void extend() {
        Book[] newBookList = new Book[books.length + 5];
        System.arraycopy(books, 0, newBookList, 0, books.length);
        books = newBookList;
    }

    public  Book  [] getBookByUser(User current){
        for (int i = 0; i < size; i++) {
            if(current.getName().equals(books[i].getAuthor())){
                Book[i] = books[i];
          }
        }
        return Book;
    }

    public Book[] getAllBooks(){
        for (int i = 0; i < size; i++) {
            Book[i] = books[i];
        }
        return Book;
    }

}
