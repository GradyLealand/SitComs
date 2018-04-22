package com.mobileapp.grady.sitcomsitdown.models;

public class SitcomModel {
    private int id;
    private String name;
    private String image;

    //A list of character Models

    /**
     * Default  Constructor
     */
    public SitcomModel() { }

    /**
     * Constructor for a SitcomModel
     * @param id A unique user id number
     * @param name The sitcoms title
     * @param image A path to the sitcoms logo
     */
    public SitcomModel(int id, String name, String image)
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
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
