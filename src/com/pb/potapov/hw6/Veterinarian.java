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

    public void treatAnimal(Animal animal){
        // System.out.println("Прием у ветеринара "+name);
        System.out.println("ест "+ animal.getFood());
        System.out.println("живет "+ animal.getLocation());
        if (animal.isIll()) {
            System.out.println("животное болеет");
            animal.sleep();
        } else {
            System.out.println("животное здорово");

        }


    }
}
