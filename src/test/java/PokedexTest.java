import Pokemon.owner.Owner;
import Pokemon.owner.Pokedex;

import Pokemon.pokemons.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokedexTest {

    private Pokedex test;
    //je veux savoir si mon Pokedex est bien généré correctement

    @BeforeEach
    public void constructPokedex(){
        System.out.println("Creating new Pokedex");
        test = new Pokedex(new Owner("Brian",2));
    }

@Test
public void PokedexGeneratorTest(){

    assertEquals(this.test.toString(),"Pokedex created for " + "Brian" );

}

@Test
public void addingPokemonToPokedex(){

        test.getPokedex().add(new Pokemon(100,10,10,"Testemon"));
        assertEquals(test.getPokedex().get(0).getName(),"Testemon");

}

    @Test
    public void displayingPokemonInPokedex(){
        test.getPokedex().add(new Pokemon(100,10,10,"Testemon"));
        test.getPokedex().add(new Pokemon(100,10,10,"Rondoudou"));
        test.getPokedex().add(new Pokemon(100,10,10,"Raïchu"));

        String makeYourChoice = "Choisissez le Pokémon combattant.\n";
        StringBuilder sb = new StringBuilder(makeYourChoice);
        for(int i=0; i<test.getPokedex().size();i++){
            sb.append((i+1) + " - " + test.getPokedex().get(i).getName() + "\n");
        }
        System.out.println(sb);
    }

}
//  if(this.pokedex.size()>=2) {
//            System.out.println("Choisissez le Pokémon combattant.\n" +
//
//                    "1- " + this.getPokedex().get(0).getName() + "\n"
//                    + "2- " + this.getPokedex().get(1).getName() + "\n"
//                    + "3- " + this.getPokedex().get(2).getName());
//        }
//        else if(this.pokedex.size()<2){
//            System.out.println("Choisissez le Pokémon combattant.\n" +
//
//                    "1- " + this.getPokedex().get(0).getName() + "\n"
//                    + "2- " + this.getPokedex().get(1).getName()) ;
//        }