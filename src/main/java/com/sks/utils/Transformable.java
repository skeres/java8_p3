package com.sks.utils;

interface Transformable
    //toutes les méthodes des interfaces sont abstracts par défaut
    //l'absence de modificateur vaut pour "package". Il ne s'écrit pas.
    //private n'est pas permis pour une interface => c'est un non sens
{   void homothetie (double coef) ;
    abstract public void rotation (double angle) ;
}
