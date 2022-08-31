import Pokemon.dao.PokemonDAO;
import Pokemon.dao.PokemonDAOImpl;
import Pokemon.dao.PokemonRepository;
import Pokemon.pokemons.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DbTesting {
    private PokemonDAOImpl pokemonDAO;
    private PokemonRepository pR;




    @Test
    void callAPokeFromDb(){
        int id = 1;
        pokemonDAO = new PokemonDAOImpl(pR);
        Pokemon poke = pokemonDAO.trouverParId(id);
        System.out.println(poke.getName());
    }
}
