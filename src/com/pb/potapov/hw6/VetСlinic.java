package com.pb.potapov.hw6;

public class VetСlinic {
    public static void main(String[] args) {

        Veterinarian vetDoct1 = new Veterinarian("Иван Иванович");

        Dog dog1 = new Dog("Чарли");
        dog1.setFood("мясо, корм, косточки");
        dog1.setLocation("во дворе");
        dog1.setIll(false);

        Dog dog2 = new Dog("Шарик");
        dog2.setFood("мясо, корм, косточки");
        dog2.setLocation("во дворе");
        dog2.setIll(true);
        //System.out.println(dog2.getAnimalType() + " по кличке " + dog2.getName());
        //dog2.sleep();

        Cat cat1 = new Cat("Марта");
        cat1.setFood("рыба, молоко, сметана");
        cat1.setLocation("в доме");
        cat1.setIll(false);

        Horse horse1 = new Horse("Орлик");
        horse1.setFood("овес, пшеница, сено, трава");
        horse1.setLocation("на конюшне");
        horse1.setIll(false);

        //System.out.println("Это " + dog1.toString());
        //System.out.println("Это " + cat1.toString());
        //System.out.println("Это " + horse1.toString());

        System.out.println("\nВаш питомец в ветлечебнице.\nЕго принимает врач " + vetDoct1.getName()+"\n");

        System.out.println("На приеме "+ dog1.getAnimalType() + " по кличке " + dog1.getName());
        vetDoct1.treatAnimal((Animal) dog1);
        System.out.println("\nНа приеме "+ dog2.getAnimalType() + " по кличке " + dog2.getName());
        vetDoct1.treatAnimal((Animal) dog2);
        System.out.println("\nНа приеме "+ cat1.getAnimalType() + " по кличке " + cat1.getName());
        vetDoct1.treatAnimal((Animal) cat1);
        System.out.println("\nНа приеме "+ horse1.getAnimalType() + " по кличке " + horse1.getName());
        vetDoct1.treatAnimal((Animal) horse1);


    }
}
