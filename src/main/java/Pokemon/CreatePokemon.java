package Pokemon;

import Pokemon.pokemons.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreatePokemon{

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Pokemon.class)
                .buildSessionFactory();
        //create a session
        Session session = factory.getCurrentSession();

        try {


            Pokemon bulbizar = new Pokemon(50, 50, 10, 20, "Bulbizar");
            Pokemon salameche = new Pokemon(50, 50, 8, 22, "Salameche");
            Pokemon carapuce = new Pokemon(50, 50, 12, 18, "Carapuce");
            Pokemon coconfort = new Pokemon(50, 50, 15, 20, "Coconfort");
            Pokemon papinox = new Pokemon(80, 80, 15, 20, "Papinox");
            Pokemon chetiflor = new Pokemon(50,50,10,20,"Chétiflor");
            Pokemon magneti = new Pokemon(50,50,10,20,"Magnéti");
            Pokemon smogo = new Pokemon(100,100,10,20,"Smogo");
            Pokemon taupiqueur = new Pokemon(100,100,10,20,"Taupiqueur");

            //start a transaction
            session.beginTransaction();

            //save the Pokemon object
            System.out.println("Saving the object");
            session.save(bulbizar);
            session.save(salameche);
            session.save(carapuce);
            session.save(coconfort);
            session.save(papinox);
            session.save(chetiflor);
            session.save(magneti);
            session.save(smogo);
            session.save(taupiqueur);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done, baby !");
        }
        finally {
            factory.close();
        }


    }

}