package com.sks.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Affichage {
    public void doStuff() {
        /////////////////////////////////////////////////    solution1
        Consumer<int[]> affichage_selectif = (tab) -> {
            for (int i = 0; i < tab.length; i++) {
                if (tab[i] > 0) System.out.println(tab[i]);
            }
        };

        int[] tab = {1, 4, -2, 9, -3, 5, -3};
        System.out.println("-- Les positifs de tab : ");
        // affichage_selectif (tab, ee -> ee > 0) ;
        affichage_selectif.accept(tab);


        ////////////////////////////////////////////////    solution 2 :
            /*
            On voit que la méthode affichage_selectif doit recevoir en second argument une
            implémentation d’une interface fonctionnelle dont la méthode fonctionnelle reçoit un
            argument de type int et fournit un résultat de type booléen
             */
        int[] tab2 = {1, 4, -2, 9, -3, 5, -3};
        System.out.print("-- Les positifs de tab : ");
        affichage_selectif2(tab2, ee -> ee > 0);


        Predicate<String> chaineEstVide = String::isEmpty;
        System.out.println("la chaine est vide " + chaineEstVide.test(""));
        System.out.println("la chaine n'est PAS vide " + chaineEstVide.test("lalala"));

        Predicate<Integer> isBiggerThan7 = (p) -> {
            return p > 5;
        };
        boolean cas3 = isBiggerThan7.test(3);
        boolean cas42 = isBiggerThan7.test(42);
        System.out.println("entier.test cas4=" + cas3);
        System.out.println("entier.test casMoins2=" + cas42);

        Supplier<String> ilFaitFroid = () -> {
            return "ca caille !";
        };
        System.out.println(ilFaitFroid.get());


        ////////////////////////////////////////////////    solution 3 :

        int[] tab3 = {1, 4, -2, 9, -3, 5, -3};
        System.out.println("-- Les positifs de tab : ");
        //affichage_selectif2 (tab2, ee -> ee > 0) ;
        Arrays.stream(tab3).filter(e->e>0).forEach(e->System.out.println(e+" est HYPER positif"));


        ////////////////////////////////////////////////    solution 4 :

        int[] tab4 = {1, 4, -2, 9, -3, 5, -3};
        System.out.println("-- Les positifs de tab : ");
        //affichage_selectif2 (tab2, ee -> ee > 0) ;
        IntStream.of(tab4).filter(e->e>0).forEach(e->System.out.println(e+" est MEGATOP positif"));


    }




        public void affichage_selectif2(int[] tabIn, IntPredicate formule) {
            //ici formule prend la valeur "ee -> ee > 0" !!!!!!!!!!!!!!!!!!!
            for (int x=0; x<tabIn.length-1;x++) {
                if (formule.test(tabIn[x])) {
                    System.out.println(tabIn[x]+" est très positif");
                } else {
                    System.out.println(tabIn[x]+" est rejeté");
                }
            }
        }





}