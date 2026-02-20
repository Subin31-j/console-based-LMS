package library;

import java.util.Scanner;

public class Main {

    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            showMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> addBook();
                case 2 -> library.displayAllBooks();
                case 3 -> searchBooks();
                case 4 -> registerMember();
                case 5 -> borrowBook();
                case 6 -> library.displayStatistics();
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
        System.out.println("1. Add New Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Books");
        System.out.println("4. Register Member");
        System.out.println("5. Borrow Book");
        System.out.println("6. View Statistics");
        System.out.println("7. Exit");
    }

    private static void addBook() {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        int year = getIntInput("Year: ");

        library.addBook(new Book(isbn, title, author, year));
    }

    private static void registerMember() {
        System.out.print("Member ID: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();

        library.registerMember(new Member(id, name));
    }

    private static void borrowBook() {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Member ID: ");
        String memberId = scanner.nextLine();

        library.borrowBook(isbn, memberId);
    }

    private static void searchBooks() {
        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();

        library.searchBooks(keyword)
                .forEach(System.out::println);
    }

    private static int getIntInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }
}
