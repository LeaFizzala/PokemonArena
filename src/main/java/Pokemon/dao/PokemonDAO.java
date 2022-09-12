package Pokemon.dao;

import Pokemon.pokemons.Pokemon;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface PokemonDAO {

    // il me faut une méthode pour sélectionner des Pokémons par id
    public Pokemon trouverParId(int id);
}
