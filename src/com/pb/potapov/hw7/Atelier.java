package com.pb.potapov.hw7;

public class Atelier {
    public static void main(String[] args) {

        Tshirt tshirt1 = new Tshirt(Size.L, "белая", 120);
        Tshirt tshirt2 = new Tshirt(Size.XXS, "розовая", 100);
        Pants pants1 = new Pants(Size.M, "серый", 250);
        Pants pants2 = new Pants(Size.S, "черный", 250);
        Pants pants3 = new Pants(Size.XXS, "голубые", 200);
        Skirt skirt1 = new Skirt(Size.XS, "синяя", 150);
        Skirt skirt2 = new Skirt(Size.XXS, "бордовая", 90);
        Tie tie1 = new Tie(Size.XS, "черный", 150);
        Tie tie2 = new Tie(Size.XXS, "красный", 90);

        Clothes[] clothes = new Clothes[]{tshirt1, tshirt2, pants1, pants2, skirt1, skirt2, tie1, tie2, pants3};

        System.out.println("В нашем ателье широкий асортимент одежды для взрослых и детей.\n\nДля мужчин");
        dressMan(clothes);

        System.out.println("\nДля женщин");
        dressWomen(clothes);


    }

    public static void dressMan(Clothes[] clothes) {

        for (Clothes clot : clothes) {
            if (clot instanceof ManClothes) {
                ((ManClothes) clot).dressMan();
            }
        }

    }

    public static void dressWomen(Clothes[] clothes) {

        for (Clothes clot : clothes) {
            if (clot instanceof WomenClothes) {
                ((WomenClothes) clot).dressWomen();
            }
        }
    }


}
