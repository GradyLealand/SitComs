package com.mobileapp.grady.sitcomsitdown.models;

import java.util.List;

public class Sitcom {
    private int id;
    private String name;
    private int image;
    private List<Character> characters;

    //A list of character Models

    /**
     * Default  Constructor
     */
    public Sitcom() { }

    /**
     * Constructor for a Sitcom model
     * @param id A unique sitcom id number
     * @param name The sitcoms title
     * @param image A path to the sitcoms logo
     */
    public Sitcom(int id, String name, int image)
    {
        this.id = id;
        this.name = name;
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
    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
    public List<Character> getCharacters() {
        return characters;
    }
    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
