package com.pb.potapov.hw6;

import java.util.Objects;

public class Cat extends Animal{

    private boolean seesInTheDark  = true; // видит в темноте

    public Cat(String name) {
        setName(name);
        setNoise("Мяу-Мяу");
        setPower(false);
        setAnimalType("Кошка");

    }

    public boolean isSeesInTheDark() {
        return seesInTheDark;
    }

    public void setSeesInTheDark(boolean seesInTheDark) {
        this.seesInTheDark = seesInTheDark;
        if (this.seesInTheDark){
            System.out.println("отлично видит в темноте");
        } else {
            System.out.println("плохо видит в темноте");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return seesInTheDark == cat.seesInTheDark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seesInTheDark);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "seesInTheDark=" + seesInTheDark +
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
