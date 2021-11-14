package com.pb.potapov.hw7;

public class Skirt extends Clothes implements WomenClothes {

    public Skirt(Size cSize, String color, double price) {
        super(cSize, color, price);
    }

    @Override
    public void dressWomen() {
        System.out.println("Юбка для женщин: размер " + cSize + "(" + cSize.getDescription() + "," + cSize.getEuroSize() + "), цвет " + color + ", цена " + price);
    }

}
