package com.sks.utils;

import java.util.function.Consumer;

public class mesLambdas {

    //Exemple avec l'interface fonctionnelle rédéfinie Consumer<T>
    // JavaDOC
    // Represents an operation that accepts a single input argument and returns no result.
    // Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
    // This is a functional interface whose functional method is accept(Object).
    public Consumer<String> afficher = (param) -> System.out.println(param);

    public void doSomething(){
        this.afficher.accept("bonjour");
    }

}
