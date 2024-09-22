import java.util.ArrayList;
import java.util.Scanner;
class Book
{
	private String title;
	private String author;
	private int bookId;
	private boolean isBorrowed;
	public Book(String title, String author, int bookId)
	{
		this.title = title;
		this.author = author;
		this.bookId = bookId;
		this.isBorrowed = false;
	}
	public String gettitle()
	{
		return title;
	}
	public String getauthor()
	{
		return author;
	}
	public int grtbookId()
	{
		return bookId;
	}
	public boolean isBorrowed()
	{
		return isBorrowed;
	}
	public void borrowBook()
	{
		isBorrowed = true;
	}
	public void returnBook()
	{
		isBorrowed = false;
	}
	@Override
	public String toString()
	{
		return "Book ID:" + bookId +",Title:"+",Author:"+author+",Borrowed:"+ isBorrowed;
	}
}
class User
{
	private String name;
	private int userId;
	private ArrayList<Book> borrowedBooks;
	public user(String name, int userId)
	{
		this.name = name;
		this.userId=userId;
		this.borrowedBooks = new ArrayList<>();
	}
	public String getName()
	{
		return name;
	}
	public int getUserId()
	{
		return userId;
	}
	public ArrayList<Book> getBorrowedBooks()
	{
		return borrowedBooks;
	}
	public void borrowBook(Book book)
	{
		borrowedBooks.add(book);
		book.borrowBook();
	}
	public void returnBook(Book book)
	{
		borrowedBooks.remove(book);
		book.returnBook();
	}
	public void showBorrowedBooks()
	{
		if (borrowedBokks.isEmpty())
		{
			System.out.println(name+"has no borrowed books.");
		}
		else
		{
			System.out.println(name+"'s borrowed books:");
			for (Book book : borrowedBooks)
			{
				System.out.println(book);
			}
		}
	}
}
class Library
{
	private ArrayList<Book> books;
	private ArrayList<User> users;
	public Library()
	{
		books = new ArrayList<>();
		users = new ArrayList<>();
	}
	public void addBook(Book book)
	{
		books.add(book);
		System.out.println("Book added:"+book);
	}
	public void addUser(User user)
	{
		users.add(user);
		System.out.println("User added:"+user.getName());
	}
	public Book findBookById(int bookId)
	{
		for (Book book : books)
		{
			if (book.getBookId()==bookId)
			{
				return book;
			}
		}
		return null;
	}
	public User findUserById(int userID) {
        for (User user : users) {
            if (user.getUserID() == userID) {
                return user;
            }
        }
        return null;
    }

    public void borrowBook(int userID, int bookID) {
        User user = findUserById(userID);
        Book book = findBookById(bookID);

        if (user == null) {
            System.out.println("User not found.");
        } else if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isBorrowed()) {
            System.out.println("Book is already borrowed.");
        } else {
            user.borrowBook(book);
            System.out.println("Book borrowed: " + book.gettitle() + " by " + user.getName());
        }
    }

    public void returnBook(int userID, int bookID) {
        User user = findUserById(userID);
        Book book = findBookById(bookID);

        if (user == null || book == null) {
            System.out.println("Invalid user or book ID.");
            return;
        }
        user.returnBook(book);
        System.out.println("Book returned: " + book.gettitle() + " by " + user.getName());
    }

    public void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayUsers() {
        System.out.println("Library Users:");
        for (User user : users) {
            System.out.println("User ID: " + user.getUserId() + ", Name: " + user.getName());
        }
    }
}

// Main class to interact with the Library Management System
public class LibraryManagementSystem 
{
    public static void main(String[] args) 
    {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Adding some sample data
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 1));
        library.addBook(new Book("1984", "George Orwell", 2));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 3));

        library.addUser(new User("Alice", 101));
        library.addUser(new User("Bob", 102));

        boolean running = true;
        while (running) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display all books");
            System.out.println("2. Display all users");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Display borrowed books for a user");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    library.displayUsers();
                    break;
                case 3:
                    System.out.print("Enter User ID: ");
                    int userID = scanner.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    library.borrowBook(userID, bookID);
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    userID = scanner.nextInt();
                    System.out.print("Enter Book ID: ");
                    bookID = scanner.nextInt();
                    library.returnBook(userID, bookID);
                    break;
                case 5:
                    System.out.print("Enter User ID: ");
                    userID = scanner.nextInt();
                    User user = library.findUserById(userID);
                    if (user != null) 
                    {
                        user.showBorrowedBooks();
                    }
                    else 
                    {
                        System.out.println("User not found.");
                    }
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
        scanner.close();
    }
}
