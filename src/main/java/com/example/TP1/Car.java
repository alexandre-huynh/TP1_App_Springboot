package com.example.TP1;

public class Car {
    public String plateNumber;

    public String brand;

    public int price;

    public boolean rented;

    public Car(){

    }

    public Car(String unePlateNumber, String uneBrand, int unPrix){
        this.plateNumber = unePlateNumber;
        this.brand = uneBrand;
        this.price = unPrix;
        this.rented = false;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public boolean getRented(){
        return rented;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRented(boolean bool){
        this.rented = bool;
    }

    public String toString() {
        String s = "";
        s += "platenumber = " + this.getPlateNumber() + " brand = " + this.getBrand() + " price = " + this.getPrice();
        return s;
    }

    // à chaque fois que @restcontroller, sait que serveur qui atatend instructions
    // pour que considère comme service
}
