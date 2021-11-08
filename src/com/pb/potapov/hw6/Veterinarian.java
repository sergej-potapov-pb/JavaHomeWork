package com.pb.potapov.hw6;

public class Veterinarian {
    private String name;

    public Veterinarian(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void treatAnimal(Animal animal) {

        System.out.println("ест " + animal.getFood());
        System.out.println("живет " + animal.getLocation());
        if (animal.isIll()) {
            System.out.println("животное болеет");
            animal.sleep();
            if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                dog.setGoodScent(false);
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                cat.setSeesInTheDark(false);
            } else if (animal instanceof Horse) {
                Horse horse = (Horse) animal;
                horse.setRunsFast(false);
            }

        } else {
            System.out.println("животное здорово");
            if (animal.isPower()) {
                System.out.println("может перевозить грузы");
            }
            if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                dog.setGoodScent(true);
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                cat.setSeesInTheDark(true);
            } else if (animal instanceof Horse) {
                Horse horse = (Horse) animal;
                horse.setRunsFast(true);
            }
        }


    }
}
