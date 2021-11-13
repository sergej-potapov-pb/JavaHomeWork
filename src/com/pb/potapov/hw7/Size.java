package com.pb.potapov.hw7;

public enum Size {

    XXS, XS, S, M, L;
//    XXS("Детский размер"),
//    XS("Взрослый размер"),
//    S("Взрослый размер"),
//    M("Взрослый размер"),
//    L("Взрослый размер");

    private String size;
    private String description;
    private String euroSize;

    Size(String size) {
        this.size = size;
        this.description = this.getDescription();
        this.euroSize = this.getEuroSize();
    }

    public String getDescription() {
        switch (size) {
            case XXS:
                return "Детский размер";
            case XS:
            case S:
            case M:
            case L:
                return "Взрослый размер";
        }

    }

    public String getEuroSize() {
        switch (size) {
            case XXS:
                return "32";
            case XS:
                return "34";
            case S:
                return "36";
            case M:
                return "38";
            case L:
                return "40";
        }
    }
}
