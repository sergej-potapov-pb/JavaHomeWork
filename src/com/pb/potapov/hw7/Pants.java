package com.pb.potapov.hw7;

public class Pants extends Clothes implements ManClothes,WomenClothes{

    public Pants(Size cSize, String color, double price) {
        super(cSize, color, price);
    }

    @Override
    public void dressMan() {
        System.out.println("Штаны для мужчин: размер " + cSize + "(" + cSize.getDescription() + "," + cSize.getEuroSize() + "), цвет " + color + ", цена " + price);
    }

    @Override
    public void dressWomen() {
        System.out.println("Штаны для женщин: размер " + cSize + "(" + cSize.getDescription() + "," + cSize.getEuroSize() + "), цвет " + color + ", цена " + price);
    }

}
