package Pokemon;

import Pokemon.owner.Owner;
import Pokemon.pokemons.*;

public class Main {
    public static void main(String[] args) {

        //generating the starter pokemons
        Pokemon bulbizar = new PokeHerbe(50,10,20,"Bulbizar");
        Pokemon salameche = new PokeFeu(50,8,22, "Salameche");
        Pokemon carapuce = new PokeEau(50,12,18,"Carapuce");
        Pokemon coconfort = new PokeInsecte(50,20,15,"Coconfort");
        Pokemon papinox = new PokeInsecte(80,10,15, "Papinox");

        //generating owners
        Owner dustin = new Owner();
        Owner steve = new Owner("Steve", 2);

        steve.getPokedex().getPokedex().add(bulbizar);
        steve.getPokedex().getPokedex().add(papinox);
        steve.getPokedex().getPokedex().add(salameche);
        steve.getPokedex().getPokedex().add(coconfort);

       // dustin.capturer(bulbizar);
       // dustin.capturer(salameche);
       // dustin.capturer(papinox);

       // steve.capturer(carapuce);
       // steve.capturer(coconfort);

        dustin.fight(steve);


    }
}
