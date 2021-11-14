package com.pb.potapov.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {


    public Tshirt(Size cSize, String color, double price) {
        super(cSize, color, price);
    }

    @Override
    public void dressMan() {
        System.out.println("Футболка для мужчин: размер " + cSize + "(" + cSize.getDescription() + "," + cSize.getEuroSize() + "), цвет " + color + ", цена " + price);
    }

    @Override
    public void dressWomen() {
        System.out.println("Футболка для женщин: размер " + cSize + "(" + cSize.getDescription() + "," + cSize.getEuroSize() + "), цвет " + color + ", цена " + price);
    }
}
