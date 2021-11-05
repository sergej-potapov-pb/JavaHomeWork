package com.pb.potapov.hw6;

public class Animal {
    private String food;            // чем питается
    private String location;        //  где живет
    private boolean ill;            // болеет или нет

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
