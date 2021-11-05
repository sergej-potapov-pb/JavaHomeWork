package com.pb.potapov.hw6;

import java.util.Objects;

public class Dog extends Animal{

    private boolean goodScent = true;  // острый нюх


    public Dog(String name) {
        setName(name);
        setNoise("Гав-Гав");
        setPower(false);
        setAnimalType("Собака");
    }

    public boolean isGoodScent() {
        return goodScent;
    }

    public void setGoodScent(boolean goodScent) {
        this.goodScent = goodScent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return goodScent == dog.goodScent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodScent);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "goodScent=" + goodScent +
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
