package com.mobileapp.grady.sitcomsitdown.models;

public class Character {
    private int id;
    private String name;
    private String details;
    private String image;

    /**
     * Default constructor
     */
    public Character() { }

    /**
     * Constructor for Character model
     * @param id A unique character id number
     * @param name The name of the character
     * @param about Some information bout the character
     * @param image The image path for the character
     */
    public Character(int id, String name, String about, String image) {
        this.id = id;
        this.name = name;
        this.details = about;
        this.image = image;
    }

    /**
     * Getters & Setters
     */
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
    public String getDetails() {
        return details;
    }
    public void setDetails(String about) {
        this.details = about;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
