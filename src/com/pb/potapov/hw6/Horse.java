package com.pb.potapov.hw6;

import java.util.Objects;

public class Horse extends Animal{

    private String name;
    private String noise;              // голос животного
    private boolean power;             // сила животного
    private boolean runsFast  = true;  // видит в темноте
    private String animalType;         // вид животного

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }


    public Horse(String name) {
        this.name = name;
        this.noise = "Иго-го";
        this.power = true;
        this.animalType = "Лошадь";

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

    public boolean isRunsFast() {
        return runsFast;
    }

    public void setRunsFast(boolean runsFast) {
        this.runsFast = runsFast;
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
        Horse horse = (Horse) o;
        return power == horse.power && runsFast == horse.runsFast && Objects.equals(name, horse.name) && Objects.equals(noise, horse.noise) && Objects.equals(animalType, horse.animalType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, noise, power, runsFast, animalType);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", noise='" + noise + '\'' +
                ", power=" + power +
                ", runsFast=" + runsFast +
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
