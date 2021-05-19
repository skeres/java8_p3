package com.sks.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Personne {

    public static ArrayList<Personne> arrayList =null;

    private String nom, prenom ;
    private int annee_naissance ;

    public Personne (){
    }

    public Personne (String prenom, String nom, int annee)
        { this.nom = nom ; this.prenom = prenom ; annee_naissance =
                annee ; }

    public String getNom() { return nom ; }
    public String getPrenom() { return prenom ; }
    public int getAnnee() { return annee_naissance ; }

    public void initArray(){
        arrayList =new ArrayList<>();
        arrayList.add(new Personne("steph","kere1",1964));
        arrayList.add(new Personne("coco","kere4",1965));
        arrayList.add(new Personne("chloe","kere7",1991));
        arrayList.add(new Personne("vincent","keres",1993));
        arrayList.add(new Personne("thais","kere14",1998));

    }

    public void afficher_le_nom_des_personnes_nées_apres_1985(){
        System.out.println("");
        arrayList.stream().filter(e->e.getAnnee()>1985).forEach(e-> System.out.println(e.getPrenom()+ " est né après 1985"));
    }

    public void afficher_le_nom_des_personnes_nées_avant_2000_trie_nom_et_affiche_nombre() {
        System.out.println("");

        //"main" java.lang.IllegalStateException: stream has already been operated upon or closed
        //solution ASTUCE TIP and TRICKS : use Supplier interface => takes no parameters but return something
        Supplier<Stream<String>> supplierStream = () -> arrayList.stream().filter(e -> e.getAnnee() < 2000).map(e -> e.getNom()).sorted(Comparator.naturalOrder());
        supplierStream.get().forEach(e -> System.out.println(e + " est né avant 2000"));
        System.out.println("nombre de personnes concernées =" + supplierStream.get().count());

        //solution avec peek
        Stream<Personne> sp=arrayList.stream().filter(e -> e.getAnnee() < 2000)
                .sorted(Comparator.comparing(c->c.getNom()))
                .peek(e-> System.out.println(e.getNom()+" "+e.getPrenom()));
        System.out.println("nbre de personnes concernées="+sp.count());
    }


    public void tri_sur_nom_et_prenom(){
        System.out.println("tri_sur_nom_et_prenom");
        arrayList.stream().sorted(Comparator.comparing(p->p.getNom()+getPrenom())).forEach(a-> System.out.println(a.getNom() + " "+a.getPrenom()));
    }

    public void annee_de_naissance_de_la_plus_jeune(){
        //solution 1
        Optional<Integer> agee=arrayList.stream().map(e->e.getAnnee()).reduce((p1, p2)->p1<p2 ? p1:p2);
        System.out.println(agee.get());

        //solution 2
        System.out.println(arrayList.stream().mapToInt(e->e.getAnnee()). min().getAsInt());




    }

}
