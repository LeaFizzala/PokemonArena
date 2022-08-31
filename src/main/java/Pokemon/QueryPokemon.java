package Pokemon;

import Pokemon.pokemons.Pokemon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryPokemon {


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

                //query students
                List<Pokemon> thePokemons = session.createQuery("from Pokemon").list();

                //display the students
                displayPokes(thePokemons);


                // commit transaction
                session.getTransaction().commit();

                System.out.println("Done, baby !");
            }
            finally {
                factory.close();
            }


        }

        private static void displayPokes(List<Pokemon> thePokemons) {
            for(Pokemon tempPoke : thePokemons) {
                System.out.println(tempPoke);
            }
        }

    }

