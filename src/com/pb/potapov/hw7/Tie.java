package com.pb.potapov.hw7;

public class Tie extends Clothes implements ManClothes{

    public Tie(Size cSize, String color, double price) {
        super(cSize, color, price);
    }

    @Override
    public void dressMan() {
        System.out.println("Галстук для мужчин: размер " + cSize + "(" + cSize.getDescription() + "," + cSize.getEuroSize() + "), цвет " + color + ", цена " + price);
    }

}
