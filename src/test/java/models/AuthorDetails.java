package models;

public class AuthorDetails {

   // private Integer id;
    private String title;
    private String author;

    public AuthorDetails(String title, String author) {
        //this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
