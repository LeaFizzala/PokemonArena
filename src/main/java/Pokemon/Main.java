package Pokemon;

import Pokemon.dao.PokemonDAO;
import Pokemon.dao.PokemonDAOImpl;
import Pokemon.dao.PokemonRepository;
import Pokemon.owner.Owner;
import Pokemon.pokemons.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static Pokemon.QueryPokemon.getThePokemons;


public class Main {

    public static void main(String[] args) {

        QueryPokemon.main();

        //generating the starter pokemons
        Pokemon caterpie = getThePokemons().get(13);
        Pokemon salameche = getThePokemons().get(3);
        Pokemon carapuce = getThePokemons().get(4);
        Pokemon coconfort = getThePokemons().get(5);
        Pokemon papinox = getThePokemons().get(6);
        Pokemon pikachu = getThePokemons().get(0);
        Pokemon roucool = getThePokemons().get(1);


        //generating owners
        Owner player = new Owner();
        Owner steve = new Owner("Steve", 2);
        Owner eleven = new Owner("Eleven", 18);

        steve.getPokedex().getPokedex().add(caterpie);


        //eleven.getPokedex().getPokedex().add(pikachu);
        eleven.getPokedex().getPokedex().add(roucool);

        player.fight(steve);

        player.rest();

        player.fight(eleven);


    }
}
