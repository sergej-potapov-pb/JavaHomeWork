package com.pb.potapov.hw6;

public class Animal {
    private String food;            // чем питается
    private String location;        //  где живет
    private boolean ill;            // болеет или нет
    private String name;            // кличка
    private String noise;           // голос животного
    private boolean power;          // сила животного
    private String animalType;      // вид животного


    public String getNoise() {
        return noise;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isIll() {
        return ill;
    }

    public void setIll(boolean ill) {
        this.ill = ill;
    }


    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void makeNoise(){
        System.out.print("животное подает голос ");

    }
    public void eat(){
        System.out.print("животное ест: ");

    }
    public void sleep(){
        System.out.println("животное спит...");
    }
}
