package com.pb.potapov.hw6;

import java.util.Objects;

public class Cat extends Animal{

    private String name;
    private String noise;              // голос животного
    private boolean power;             // сила животного
    private boolean seesInTheDark  = true; // видит в темноте
    private String animalType;         // вид животного

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }


    public Cat(String name) {
        this.name = name;
        this.noise = "Мяу-Мяу";
        this.power = false;
        this.animalType = "Кошка";

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

    public boolean isSeesInTheDark() {
        return seesInTheDark;
    }

    public void setSeesInTheDark(boolean seesInTheDark) {
        this.seesInTheDark = seesInTheDark;
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
        Cat cat = (Cat) o;
        return power == cat.power && seesInTheDark == cat.seesInTheDark && Objects.equals(name, cat.name) && Objects.equals(noise, cat.noise) && Objects.equals(animalType, cat.animalType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, noise, power, seesInTheDark, animalType);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", noise='" + noise + '\'' +
                ", power=" + power +
                ", seesInTheDark=" + seesInTheDark +
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
