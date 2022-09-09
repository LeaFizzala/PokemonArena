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

public class Main {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Pokemon.class)
                .buildSessionFactory();
        //create a session
        Session session = factory.getCurrentSession();

        List<Pokemon> thePokemons;
        try {
            //use the session object to save Java objects

            //start a transaction
            session.beginTransaction();

            //query
            thePokemons = session.createQuery("from Pokemon").list();

            // commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }

        //generating the starter pokemons
        Pokemon bulbizar = thePokemons.get(2);
        Pokemon salameche = thePokemons.get(3);
        Pokemon carapuce = thePokemons.get(4);
        Pokemon coconfort = thePokemons.get(5);
        Pokemon papinox = thePokemons.get(6);
        //Pokemon pikachu = thePokemons.get(0);
        Pokemon roucool = thePokemons.get(1);


        //generating owners
        Owner player = new Owner();
        Owner steve = new Owner("Steve", 2);
        Owner eleven = new Owner("Eleven", 18);

        steve.getPokedex().getPokedex().add(bulbizar);
        steve.getPokedex().getPokedex().add(papinox);
        steve.getPokedex().getPokedex().add(salameche);


        //eleven.getPokedex().getPokedex().add(pikachu);
        eleven.getPokedex().getPokedex().add(roucool);

        player.fight(steve);

        player.rest();

        player.fight(eleven);


    }
}
