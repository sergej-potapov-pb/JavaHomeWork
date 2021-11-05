package com.pb.potapov.hw6;

import java.util.Objects;

public class Dog extends Animal{

    private String name;
    private String noise;              // голос животного
    private boolean power;             // сила животного
    private boolean goodScent = true;  // острый нюх
    private String animalType;         // вид животного

    public String getAnimalType() {
        return animalType;
    }

    public Dog(String name) {
        this.name = name;
        this.noise = "Гав-Гав";
        this.power = false;
        this.animalType = "Собака";
    }

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

    public boolean isGoodScent() {
        return goodScent;
    }

    public void setGoodScent(boolean goodScent) {
        this.goodScent = goodScent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return power == dog.power && goodScent == dog.goodScent && Objects.equals(name, dog.name) && Objects.equals(noise, dog.noise) && Objects.equals(animalType, dog.animalType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, noise, power, goodScent, animalType);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", noise='" + noise + '\'' +
                ", power=" + power +
                ", goodScent=" + goodScent +
                '}';
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println(getNoise()+"!!!");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println(getFood());

    }
}
