package com.sks.utils;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class MesStreams {

    public void doStuff(){

        int[] tab4 = {1, 4, -2, 9, -3, 5, -3,12,7,6,-11};
        System.out.println("les positifs");
        this.affichageSelectif(tab4,e->e>0);
        System.out.println("les négatifs");
        this.affichageSelectif(tab4,e->e<0);
        System.out.println("les pairs");
        this.affichageSelectif(tab4,e->e%2==0 && e>0);


        //un peu de tri en plus
        int[] tab7 = {1, 4, -2, 9, -3, 5, -3,12,7,6,-11,4,4,4,4,4,4};
        System.out.println("-- Les positifs TRIES de tab : ");
        IntStream.of(tab7).filter(e->e>0).sorted().forEach(e->System.out.println(e+" est MEGATOP positif"));
        System.out.println("-- Le nombre total de positifs de tab : "+IntStream.of(tab7).filter(e->e>0).count());
        System.out.println("-- Le nombre total de positifs DISTINCTS de tab : "+IntStream.of(tab7).filter(e->e>0).distinct().count());


    }

    public void affichageSelectif(int[] tab, IntPredicate predicate) {
        for(int v:tab) {
            if (predicate.test(v)) System.out.println(v);
        }
    }



}
