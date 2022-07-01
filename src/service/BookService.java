package service;

import models.Book;
import models.User;
import storige.BookStorage;

import java.util.List;


public class BookService {
    BookStorage bookStorage = new BookStorage();



    public Book[] getByUser(User currentUser) {
        return bookStorage.getBookByUser(currentUser);
    }

      public  Book[] getAll(){
        return bookStorage.getAllBooks();
      }


        public void addBook(Book book){
            bookStorage.add(book);

        };


}


