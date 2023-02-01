package com.example.supermarket;

public class Rating {

    private int supermarketID;
    private String supermarketName;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private float liquorDptRating;
    private float produceDptRating;
    private float meatDptRating;
    private float cheeseSelRating;
    private float eocRating;

    public Rating(){
        supermarketID = -1;
        liquorDptRating = (float) 0;
        produceDptRating = (float) 0;
        meatDptRating = (float) 0;
        cheeseSelRating = (float) 0;
        eocRating = (float) 0;
    }

    public int getSupermarketID() {
        return supermarketID;
    }

    public void setSupermarketID(int supermarketID) {
        this.supermarketID = supermarketID;
    }

    public String getSupermarketName() {
        return supermarketName;
    }

    public void setSupermarketName(String supermarketName) {
        this.supermarketName = supermarketName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getLiquorDptRating() {
        return liquorDptRating;
    }

    public void setLiquorDptRating(float liquorDptRating) {
        this.liquorDptRating = liquorDptRating;
    }

    public float getProduceDptRating() {
        return produceDptRating;
    }

    public void setProduceDptRating(float produceDptRating) {
        this.produceDptRating = produceDptRating;
    }

    public float getMeatDptRating() {
        return meatDptRating;
    }

    public void setMeatDptRating(float meatDptRating) {
        this.meatDptRating = meatDptRating;
    }

    public float getCheeseSelRating() {
        return cheeseSelRating;
    }

    public void setCheeseSelRating(float cheeseSelRating) {
        this.cheeseSelRating = cheeseSelRating;
    }

    public float getEocRating() {
        return eocRating;
    }

    public void setEocRating(float eocRating) {
        this.eocRating = eocRating;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
