package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents a library that contains a list of books
public class Library implements Writable {
    protected List<Book> books;

    // EFFECTS: creates an empty library
    public Library() {
        books = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds book to library
    public void addBook(Book book) {
        books.add(book);
    }

    // MODIFIES: this
    // EFFECTS: removes book from library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // EFFECTS: returns the number of books in library
    public int size() {
        return books.size();
    }

    // EFFECTS: returns true if library contains book, false otherwise
    public boolean contains(Book book) {
        return books.contains(book);
    }

    // EFFECTS: returns a list of all books in library
    public List<Book> getBooks() {
        return books;
    }

    // EFFECTS: converts and returns library as a json object
    @Override
    public JSONObject toJson() {
        JSONObject jsonLibrary = new JSONObject();
        jsonLibrary.put("books", booksToJson());
        
        return jsonLibrary;
    }

    // EFFECTS: converts and returns library books as a json array
    private JSONArray booksToJson() {
        JSONArray jsonBooks = new JSONArray();

        for (Book b : books) {
            jsonBooks.put(b.toJson());
        }

        return jsonBooks;
    }
}
