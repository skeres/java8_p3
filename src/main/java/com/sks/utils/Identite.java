package com.sks.utils;

public class Identite {

    private static int autoIncrement=0;
    private int numero;

    public Identite (){
        autoIncrement+=1;
        setIdent(autoIncrement);
    }

    public int getIdent() {
        return this.numero;
    }

    public static int getIdentMax() {
        return autoIncrement;
    }

    private void setIdent(int n) {
        this.numero=n;
    }
}
