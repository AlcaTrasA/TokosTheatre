package Models;

import javafx.scene.image.Image;

public class Movie {
    private int id;
    private String name;
    private String director;
    private String details;
    private double imdb;
    private Image image;
    private Double price;
    private String bought;

    public Movie(int id, String name, String director, String details, double imdb, Image image,double price,String bought) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.details = details;
        this.imdb = imdb;
        this.image = image;
        this.price = price;
        this.bought = bought;
    }

    public Movie() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBought() {
        return bought;
    }

    public void setBought(String bought) {
        this.bought = bought;
    }
}
