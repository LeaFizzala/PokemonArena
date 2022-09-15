package Pokemon.owner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateOwner {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Owner.class)
                .addAnnotatedClass(Pokedex.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // create the objects

            Owner owner1 =
                    new Owner();

            Pokedex firstPokedex =
                    new Pokedex(1,1,1,1,1,1);


            // associate the objects
            //tempInstructor.setInstructordetail(tempInstructorDetail);
            owner1.setPokedex(firstPokedex);

            // start a transaction
            session.beginTransaction();

            // save the instructor
            //
            // Note: this will ALSO save the details object
            // because of CascadeType.ALL
            //
            //System.out.println("Saving instructor: " + tempInstructor);
            //session.save(tempInstructor);
            System.out.println("Saving owner: " + owner1);
            session.save(owner1);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

}

