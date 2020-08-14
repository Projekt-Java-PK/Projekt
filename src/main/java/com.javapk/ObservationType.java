package com.javapk;

public enum ObservationType {
    KWIATY("kwiaty"), DRZEWA("drzewa"), GWIAZDY("gwiazdy"), ZWIERZE("zwierze"), KRAJOBRAZ("krajobraz");

    private String type;

    ObservationType(String type) {
        this.type = type;
    }
}
