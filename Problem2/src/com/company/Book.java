package com.company;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represent books in our library
 */
public abstract class Book implements Comparable<Book>, Serializable {
    //private static final long serialVersionUID = 1L;

    private String title;
    private String locationCode;
    private int yearPub;

    // Part 1: enable an ArrayList of Authors so a book can have multiple authors
    private ArrayList<Author> authors;
    private Publisher publisher;

    /**
     * Initializes the book
     * @param title book's title
     * @param location book's location in the library. it's usually a code like G70.212.R54
     * @param yearPub year of publication
     * @param author author object.
     * @param publisher publisher object.
     */

    // default constructor
    public Book(){
        this.title = "";
        this.locationCode = "";
        this.yearPub = 0;
        this.authors = new ArrayList<Author>();
    }

    public Book ( String title, String location, int yearPub,
                  ArrayList<Author> authorList, Publisher publisher){

        this.title =title;
        this.locationCode = location;
        this.yearPub = yearPub;

        this.publisher = publisher;

        // hw 4 enhancement
        this.authors = new ArrayList<Author>(authorList);

    }


    // Comparable interface
    // returns 0 if yearPub is equal, 1 if greater, -1 if less than
    @Override
    public int compareTo(Book o){
        if (this.yearPub == o.getYearPub()){
            return 0;
        }
        else if(this.yearPub > o.getYearPub()){
            return 1;
        }
        else{
            return -1;
        }
    }

    // add an author the the arrayList
    public void addAuthor(Author author){
        this.authors.add(author);
    }

    // remover an author
    // true if author in the list, false and message if not
    public boolean removerAuthor(Author author){
        if (this.authors.contains(author)){
            this.authors.remove(author);
            return true;
        }
        else{
            System.out.println(this.title + " does not have author: " + author.getName());
            return false;
        }
    }

    // search for an author
    public boolean findAuthor(Author author){
        if (this.authors.contains(author)){
            System.out.println(this.title + " has author " + author.getName());
            return true;
        }
        else {
            System.out.println(this.title + " does not have author " + author.getName());
            return false;
        }
    }

    // return author/authors
    public String getAuthors(){
        // cycle through the authro list and print each
        String authorList = "";
        for(Author author : this.authors){
            if(this.authors.size() == 1){
                authorList = authorList + author + ".";
            }
            else if(author == this.authors.get(this.authors.size() - 1)){
                authorList = authorList + author + ".";
            }
            else {
                authorList = authorList + author + ", ";
            }

        }
        return authorList;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public int getYearPub() {
        return yearPub;
    }

    public void setYearPub(int yearPub) {
        this.yearPub = yearPub;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    /**
     * The toString method converts an object to a string. It is used to display the object in a println call.
     * To be overridden in PrintedBook subclass
     */
    public abstract String toString();
}
