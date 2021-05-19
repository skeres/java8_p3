package com.sks.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MesReducesAndCo {

    public MesReducesAndCo(){

    }

    public void reduce1(){

        int[] nbr = {1, 2, 3};
        System.out.println("int[] nbr = {1, 2, 3}");
        int somme_starting_at_0 = Arrays.stream(nbr).reduce(0, (a, b) -> a + b);
        System.out.println("somme_starting_at_0="+somme_starting_at_0);
        int somme_starting_at_10 = Arrays.stream(nbr).reduce(10, (a, b) -> a + b);
        System.out.println("somme_starting_at_10="+somme_starting_at_10);
    }

    public void reduce2parallel(){
        int[] nbr = {1, 2, 3,4,5,6,7,8,7,14,15,16,1,9,10,11};

        List<Integer> targetList = new ArrayList<>(Arrays.asList(1, 2, 3,4,5,6,7,8,7,14,15,16,1,9,10,11));
        System.out.println("new ArrayList<>(Arrays.asList(1, 2, 3,4,5,6,7,8,7,14,15,16,1,9,10,11))");
        //TODO

    }

}
