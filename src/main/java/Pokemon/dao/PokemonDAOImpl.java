package Pokemon.dao;

import Pokemon.pokemons.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PokemonDAOImpl implements PokemonDAO {

    private PokemonRepository pR;

    @Autowired
    public PokemonDAOImpl(PokemonRepository pR) {
        this.pR = pR;
    }

    @Override
    public Pokemon trouverParId(int id) {
        Optional<Pokemon> result = pR.findById(id);

return        result.orElseThrow(() -> new RuntimeException("Did not find Pokemon id - " + id));
    }
}
