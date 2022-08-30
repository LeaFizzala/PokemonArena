import Pokemon.owner.Owner;
import Pokemon.pokemons.PokeInsecte;
import Pokemon.pokemons.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FightTest {

    private Owner o1;
    private Owner o2;
    private Pokemon p1;
    private Pokemon p2;

    @BeforeEach
    public void createOwners(){
        o1 = new Owner("TestOwner1", 1);
        o2 = new Owner("TestOwner2", 1);
    }

    @BeforeEach
    public void createPokemons(){
        p1 = new PokeInsecte(50,50,0,20,"Coconfort");
        p2 = new PokeInsecte(80,80,0,20, "Papinox");
    }

    @Test
    public void fillPokedex(){

        o1.getPokedex().ajouterPokemon(p1);
        o2.getPokedex().ajouterPokemon(p2);

        assertEquals(o1.getPokedex().getPokedex().get(0).getName(), "Coconfort");
        assertEquals(o2.getPokedex().getPokedex().get(0).getName(), "Papinox");
    }

    @Test
    public void unilateralFight(){

        while(p2.getHP()>0) {
            p1.attaque(p2);
        }
    }

    @Test
    public void bilateralFight(){
        while(p1.getHP()>0 && p2.getHP()>0){
            p1.attaque(p2);
            p2.attaque(p1);
        }
    }

    @Test
    public void emptyingPokedex(){

        o1.getPokedex().ajouterPokemon(p1);
        o2.getPokedex().ajouterPokemon(p2);

        while(o1.getPokedex().getPokedex().size()>0 && o2.getPokedex().getPokedex().size()>0 ) {
            while (p1.getHP() > 0 && p2.getHP() > 0) {
                p1.attaque(p2);


                if(p2.getHP()<=0){
                    System.out.println(p2.getName() + " est éliminé ! \n" +
                            "-----------------------------------------");
                    o2.getPokedex().getPokedex().remove(o2.getPokedex().getPokedex().size()-1);
                }

                p2.attaque(p1);

                if(p1.getHP()<=0){
                    System.out.println(p1.getName() + " est éliminé !\n" +
                            "------------------------------------------");
                    o1.getPokedex().getPokedex().remove(o1.getPokedex().getPokedex().size()-1);
                }
            }
        }
    }

    @Test
    public void fightWithSeveralPokemons(){
        o1.getPokedex().getPokedex().add(new Pokemon(100, 100,10,10,"Pikachu"));
        o1.getPokedex().getPokedex().add(new Pokemon(100, 100,10,10,"Evoli"));
        o2.getPokedex().getPokedex().add(new Pokemon(100, 100,10,10,"Abra"));
        o2.getPokedex().getPokedex().add(new Pokemon(100, 100,10,10,"Miaouss"));



        while(o1.getPokedex().getPokedex().size()>0 && o2.getPokedex().getPokedex().size()>0 ) {
            Pokemon fighter1 = o1.getPokedex().getPokedex().get(o1.getPokedex().getPokedex().size()-1);
            Pokemon fighter2 = o2.getPokedex().getPokedex().get(o2.getPokedex().getPokedex().size()-1);

            while (fighter1.getHP() > 0 && fighter2.getHP() > 0) {

                if(fighter1.getHP()>0){
                    fighter1.attaque(fighter2);

                    if(fighter2.getHP()<=0){
                        System.out.println(fighter2.getName() + " est éliminé ! \n" +
                                "-----------------------------------------");
                        o2.getPokedex().getPokedex().remove(fighter2);
                        System.out.println("Pokémons restants pour " + o2.getName() + " : " + o2.getPokedex().getPokedex().size());
                    }
                }


                if(fighter2.getHP()>0) {
                    fighter2.attaque(fighter1);
                    if(fighter1.getHP()<=0){
                        System.out.println(fighter1.getName() + " est éliminé !\n" +
                                "------------------------------------------");
                        o1.getPokedex().getPokedex().remove(fighter1);
                        System.out.println("Pokémons restants pour " + o1.getName() + " : " + o1.getPokedex().getPokedex().size());

                    }
                }
            }
            if(o1.getPokedex().getPokedex().size()<=0){
                System.out.println("Le joueur 1 a perdu !");
            }
            else if(o2.getPokedex().getPokedex().size()<=0){
                System.out.println("Le joueur 2 a perdu !");
            }
        }
    }
}
