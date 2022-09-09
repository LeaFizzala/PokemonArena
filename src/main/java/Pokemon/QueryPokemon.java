package Pokemon;

import Pokemon.pokemons.Pokemon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class QueryPokemon {
   private static List<Pokemon> thePokemons;
    private static List<Pokemon> starterPack;
    public static List<Pokemon> getThePokemons() {
        return thePokemons;
    }

    public static List<Pokemon> getStarterPack() {
        return starterPack;
    }

    public static void main(String[] args) {

            //create session factory
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Pokemon.class)
                    .buildSessionFactory();
            //create a session
            Session session = factory.getCurrentSession();

            try {
                //use the session object to save Java objects

                //start a transaction
                session.beginTransaction();

                //query pokemons

                thePokemons = session.createQuery("from Pokemon").list();

                Query<Pokemon> poke = session.createQuery("from Pokemon where total<400 order by id_pokemon").setMaxResults(10);
               starterPack = poke.list();

                //display the pokemons
                displayPokes(starterPack);

                // commit transaction
                session.getTransaction().commit();

                System.out.println("Done, baby !");
            }
            finally {
                factory.close();
            }


        }

        private static void displayPokes(List<Pokemon> thePokemons) {
            thePokemons.forEach(e -> System.out.println(e.getName()));
        }

    }

