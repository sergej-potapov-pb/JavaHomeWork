package com.pb.potapov.hw6;

import java.lang.reflect.Constructor;

public class VetСlinic {
    public static void main(String[] args) throws Exception {

        Dog dog1 = new Dog("Чарли");
        dog1.setFood("мясо, корм, косточки");
        dog1.setLocation("во дворе");
        dog1.setIll(false);

        Dog dog2 = new Dog("Шарик");
        dog2.setFood("мясо, корм, косточки");
        dog2.setLocation("во дворе");
        dog2.setIll(true);

        Cat cat1 = new Cat("Марта");
        cat1.setFood("рыба, молоко, сметана");
        cat1.setLocation("в доме");
        cat1.setIll(false);

        Horse horse1 = new Horse("Орлик");
        horse1.setFood("овес, пшеница, сено, трава");
        horse1.setLocation("на конюшне");
        horse1.setIll(false);

        System.out.println(dog1.getAnimalType() + " по кличке " + dog1.getName());
        dog1.makeNoise();
        dog1.eat();
        System.out.println(dog2.getAnimalType() + " по кличке " + dog2.getName());
        dog2.makeNoise();
        dog2.eat();
        System.out.println(cat1.getAnimalType() + " по кличке " + cat1.getName());
        cat1.makeNoise();
        cat1.eat();
        System.out.println(horse1.getAnimalType() + " по кличке " + horse1.getName());
        horse1.makeNoise();
        horse1.eat();

        Animal[] Animals = new Animal[4];
        Animals[0] = dog1;
        Animals[1] = dog2;
        Animals[2] = cat1;
        Animals[3] = horse1;

        Class vetClazz = Class.forName("com.pb.potapov.hw6.Veterinarian");
        // создание объекта через рефлексию
        Constructor constr = vetClazz.getConstructor(new Class[] {String.class});
        Object vetObj = constr.newInstance("Иван Иванович");

        System.out.println("\nВаш питомец в ветлечебнице.\nЕго принимает врач " + ((Veterinarian) vetObj).getName() + "\n");
        int i;
        for (i = 0; i<Animals.length; i++) {

            System.out.println("\nНа приеме " + Animals[i].getAnimalType() + " по кличке " + Animals[i].getName());
            ((Veterinarian) vetObj).treatAnimal(Animals[i]);

        }



    }


}
