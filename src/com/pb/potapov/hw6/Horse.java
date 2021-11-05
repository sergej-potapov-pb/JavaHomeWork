package com.pb.potapov.hw6;

import java.util.Objects;

public class Horse extends Animal{

    private boolean runsFast  = true;  // быстро бегает

    public Horse(String name) {
        setName(name);
        setNoise("Иго-го");
        setPower(true);
        setAnimalType("Лошадь");

    }

    public boolean isRunsFast() {
        return runsFast;
    }

    public void setRunsFast(boolean runsFast) {
        this.runsFast = runsFast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return runsFast == horse.runsFast;
    }

    @Override
    public int hashCode() {
        return Objects.hash(runsFast);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "runsFast=" + runsFast +
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
