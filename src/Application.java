import models.Book;
import models.User;
import exeptions.UserAlreadyExistsException;
import exeptions.UserNotFoundException;
import service.BookService;
import service.UserService;

import java.util.Scanner;

public class Application {

    private UserService userService = new UserService();
    private BookService bookService = new BookService();
    private Scanner scanner = new Scanner(System.in);
    private User currentUser;


    public void start() {
        boolean findNormalCommand = false;
        while (!findNormalCommand) {
            System.out.println("For registration please input 1");
            System.out.println("For login please input 2");
            System.out.println("For exit from program input 3");
            String command = scanner.nextLine();
            switch (command) {
                case "1": {
                    registration();
                    findNormalCommand = false;
                    break;
                }
                case "2": {
                    login();
                    findNormalCommand = false;
                    break;
                }
                case "3": {
                    System.exit(1);
                }
                default: {
                    System.out.println("Please input only 1 or 2");
                }
            }

        }
    }

    private void login() {
        System.out.println(" ** Login process **");

        System.out.println("Please input your email");
        String email = scanner.nextLine();

        System.out.println("Please input your password");
        String password = scanner.nextLine();

        try {
            currentUser = userService.login(email, password);
            System.out.println("Login success");
            logService();


        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());

        }
    }

    private void registration() {
        System.out.println(" ** Registration process **");

        System.out.println("Please input your name");
        String name = scanner.nextLine();

        System.out.println("Please input your surname");
        String surname = scanner.nextLine();

        System.out.println("Please input your email");
        String email = scanner.nextLine();

        System.out.println("Please input your password");
        String password = scanner.nextLine();



        try {
            currentUser = userService.registration(new User(name, surname, email, password));
            System.out.println("Registration success");
         //   start();   //removable
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());

        }
    }

    private void logService() {

        System.out.println("** WELCOME TO THE LIBRARY **");
        System.out.println( "\n" +"\t\t" + currentUser.getName()+ "  " +currentUser.getSurname() +"\n" );
        boolean exit = false;
        while (!exit) {
            System.out.println("For read  my books please input 1");
            System.out.println("For read the all books please input 2");
            System.out.println("For add the books please input 3");
            System.out.println("For the logout input 4");
            scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            switch (command) {
                case "1": {
                 currentUserBooks();
                    break;
                }
                case "2": {
                    printAllBooks();
                    break;
                }
                case "3": {
                    addBook();
                    break;
                }
                case "4": {
                    System.out.println("Bye");
                    exit = true;
                    break;
                }
                default: {
                    System.out.println("Please input 1 , 2 , 3 or 4");
                }
            }
        }
    }

    private void currentUserBooks() {
        Book [] books = bookService.getByUser(currentUser);
        for (Book book:books) {
          try {
              System.out.println(book.toString());
          }catch (NullPointerException e){
              System.out.println();
              break;
          }
        }
    }

    private void printAllBooks() {
        Book[] books = bookService.getAll();
        for (Book book : books) {
            try {
                System.out.println(book.toString());
            } catch (NullPointerException e) {
                System.out.println();
                break;
            }

        }
    }



    private void addBook(){
        System.out.println(" ** Book Adding **");

        System.out.println("Please input title");
        String name = scanner.nextLine();

        int pageCount = defineNumberValue("Please input book page");

        int year = defineNumberValue("Please input year");

        bookService.addBook(new Book(name,pageCount,year,currentUser));
        System.out.println(" ** Congratulation your book added");
    }



        private int defineNumberValue(String text) {
            boolean isNumberDefined = false;

            int year = 0;
            while (!isNumberDefined) {
                try {
                    scanner = new Scanner(System.in);
                    System.out.println(text);
                    year = scanner.nextInt();
                    isNumberDefined = true;
                } catch (Exception e) {
                    System.out.println("Please input only numeric value");
                }
            }
            return year;

        }





}


