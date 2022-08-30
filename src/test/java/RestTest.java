import Pokemon.pokemons.PokeInsecte;
import Pokemon.pokemons.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestTest {

    private Pokemon p1;
    private Pokemon p2;

    @BeforeEach
    public void createPokemons(){
        p1 = new PokeInsecte(50, 50,20,20,"Coconfort");
        p2 = new PokeInsecte(80,80,20, 20, "Papinox");

        p1.attaque(p2);
        p1.attaque(p2);

    }


    @Test
    public void testRest(){
        p2.rest();
        assertEquals(p2.getHPmax() , p2.getHP());
    }



}
