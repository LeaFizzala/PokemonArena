package Pokemon;

import Pokemon.owner.Owner;
import Pokemon.pokemons.*;

public class Main {
    public static void main(String[] args) {

        //generating the starter pokemons
        Pokemon bulbizar = new PokeHerbe(50, 50,10,20,"Bulbizar");
        Pokemon salameche = new PokeFeu(50, 50,8,22, "Salameche");
        Pokemon carapuce = new PokeEau(50, 50,12,18,"Carapuce");
        Pokemon coconfort = new PokeInsecte(50,50,15,20,"Coconfort");
        Pokemon papinox = new PokeInsecte(80,80,15, 20,"Papinox");
        Pokemon pikachu = new PokeEau(80,80,15,20,"Pikachu");
        Pokemon magicarpe = new PokeEau(80,80,0,2,"Magicarpe");

        //generating owners
        Owner player = new Owner();
        Owner steve = new Owner("Steve", 2);
        Owner eleven = new Owner("Eleven", 18);

        steve.getPokedex().getPokedex().add(bulbizar);
        steve.getPokedex().getPokedex().add(papinox);
        steve.getPokedex().getPokedex().add(salameche);


        eleven.getPokedex().getPokedex().add(pikachu);
        eleven.getPokedex().getPokedex().add(magicarpe);

        player.fight(steve);

        player.rest();

       player.fight(eleven);





    }
}
