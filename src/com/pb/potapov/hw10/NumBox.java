package com.pb.potapov.hw10;

public class NumBox<T extends Number> {

    private final T[] numbers;
    private int countNum;

    public NumBox(int size) {

        numbers = (T[]) new Number[size];
        countNum = 0;
    }

    public void set(int i, T Number) {
        this.numbers[i] = Number;
    }

    public T get(int i) {
        return numbers[i];
    }

    public T max() {
        float  maxNum=numbers[0].floatValue();
        int c=0; // номер максимального элемента

        for (int i=0; i<countNum; i++){
            if (numbers[i].floatValue()> maxNum){
                maxNum=numbers[i].floatValue();
                c = i;
            }
        }
        return numbers[c];
    }

    public double sum(){
        double resSum = 0;
        for (int i=0; i<countNum; i++){
            resSum = resSum + numbers[i].doubleValue();
        }
        return resSum;

    }

    public double average() {
        return sum()/countNum;
    }

    public int length() {
        return this.countNum;
    }

    public void add(T Number) throws BadSize {

        if (countNum < numbers.length) {
            set(countNum, Number);
            countNum++;
        } else {
            throw new BadSize("Превышен допустимый размер массива чисел");
        }

    }
}
