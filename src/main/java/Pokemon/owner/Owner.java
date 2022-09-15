package Pokemon.owner;

import Pokemon.pokemons.Fighting;
import Pokemon.pokemons.Pokemon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Pokemon.QueryPokemon.getStarterPack;
@Entity
@Table(name="owner")
public class Owner  {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="owner_id")
    private int owner_id;
    @Column(name="owner_name")
    private String name;
    @Column(name="owner_level")
    private int level;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="owner_pokedex")
    private Pokedex pokedex;
    @Column(name="team_id")
    private int team;

//    public Owner(String name, int level, int team){
//        this.name = name;
//        this.level = level;
//        this.pokedex = new Pokedex();
//        this.team = team;
//    }

    public Owner(){};

    public void createOwner(String newName, int newLevel, int newTeam) {
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
            owner1.setName(newName);
            owner1.setLevel(newLevel);
            owner1.setTeam(newTeam);

            Pokedex firstPokedex =
                    new Pokedex(1, 1, 1, 1, 1, 1);


            // associate the objects
            owner1.setPokedex(firstPokedex);

            // start a transaction
            session.beginTransaction();

            System.out.println("Saving owner: " + owner1);
            session.save(owner1);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }


//    public Owner(int owner_id) {
//
//        this.pokedex = new Pokedex();
//        Scanner scan = new Scanner(System.in);
//        System.out.println("What's your name ?");
//        this.name = scan.nextLine();
//        System.out.println("Welcome, " + this.name + ".");
//        int teamChoice = -1;
//        do {
//            try {
//                System.out.println("Choose your first Pokemon. \n" +
//                        "1 " + getStarterPack().get(0).getName()+ "\n"+
//                        "2 " + getStarterPack().get(1).getName()+ "\n"+
//                       "3 " + getStarterPack().get(2).getName()+ "\n"+
//                       "4 " + getStarterPack().get(3).getName()+ "\n"+
//                        "5 " +getStarterPack().get(4).getName()
//
//                );
//                teamChoice = readChoice(scan);
//            } catch (InputMismatchException e) {
//                System.err.println("[ " + e.getMessage() + " ]");
//            }
//        } while (teamChoice < 0);
//
//        this.chooseFirstPoke(teamChoice);
//
//        do {
//            try {
//                System.out.println("Choose your second Pokemon. \n" +
//                        "1 " + getStarterPack().get(5).getName()+ "\n"+
//                        "2 " + getStarterPack().get(6).getName()+ "\n"+
//                        "3 " + getStarterPack().get(7).getName()+ "\n"+
//                        "4 " + getStarterPack().get(8).getName()+ "\n"+
//                        "5 " +getStarterPack().get(9).getName()
//
//                );
//                teamChoice = readChoice(scan);
//            } catch (InputMismatchException e) {
//                System.err.println("[ " + e.getMessage() + " ]");
//            }
//        } while (teamChoice < 0);
//
//        this.chooseSecondPoke(teamChoice);
//    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Pokedex getPokedex() {
        return pokedex;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setPokedex(Pokedex pokedex) {
        this.pokedex = pokedex;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

//    public void ajouterPokemon(Pokemon poke) {
//        this.getPokedex().getPokedex().add(poke);
//        System.out.println(poke.getName() + " a été ajouté à la collection. " + this.getName() +
//                " possède maintenant " + this.getPokedex().getPokedex().size() + " Pokemons.");
//    }
//
//
//    @Override
//    public void fight(Owner owner) {
//        System.out.println(this.name + " provoque " + owner.getName() + " en duel ! " );
//        int round =1;
//        // tant que les joueurs ont encore des Pokémons en vie dans leur liste
//        while(this.getPokedex().getPokedex().size()>0 && owner.getPokedex().getPokedex().size()>0){
//
//                System.out.println("<<<<<< Combat n°" + round + " >>>>>>>");
//                Pokemon combattant1 =  this.getPokedex().choisirCombattant();
//                Pokemon combattant2 = owner.getPokedex().choisirCombattant(owner.getPokedex().getPokedex().size()-1);
//                System.out.println(combattant1.getName() + " affronte " + combattant2.getName() + " ! \n" +
//                        "***********************************");
//                round++;
//
//                //tant que les Pokémons sélectionnés ont des HP
//                while(combattant1.getHP()>0 && combattant2.getHP()>0){
//
//                    if(combattant1.getHP()>0){
//                        combattant1.attaque(combattant2);
//
//                        if(combattant2.getHP()<=0){
//                            System.out.println(combattant2.getName() + " est éliminé ! \n" +
//                                    "-----------------------------------------");
//                            owner.getPokedex().getPokedex().remove(combattant2);
//                            System.out.println("Pokémons restants pour " + owner.getName() + " : " + owner.getPokedex().getPokedex().size());
//                        }
//                    }
//
//                    if(combattant2.getHP()>0) {
//                        combattant2.attaque(combattant1);
//                        if(combattant1.getHP()<=0){
//                            System.out.println(combattant1.getName() + " est éliminé !\n" +
//                                    "------------------------------------------");
//                            this.getPokedex().getPokedex().remove(combattant1);
//                            System.out.println("Pokémons restants pour " + this.getName() + " : " + this.getPokedex().getPokedex().size());
//
//                        }
//                    }
//                }
//        }
//    }
//
//    @Override
//    public void rest() {
//        for (Pokemon p : this.getPokedex().getPokedex()
//             ) {
//            p.rest();
//        }
//    }
    public int readChoice(Scanner scan) throws InputMismatchException {
        String strNumber = scan.nextLine();
        int number;
        try {
            number = Integer.parseInt(strNumber);
        } catch (NumberFormatException e) {
            throw new InputMismatchException("Entrez un nombre entre 1 et 5 !");
        }
        if (number <= 0) {
            throw new InputMismatchException("Entrez un nombre entre 1 et 5 !");
        }
        else if(number >5){
            throw new InputMismatchException("Entrez un nombre entre 1 et 5 !");
        }
        return number;
    }
//    public void chooseFirstPoke(int choice){
//        this.getPokedex().getPokedex().add(getStarterPack().get(choice-1));
//        System.out.println("You chose " + getStarterPack().get(choice-1).getName() );
//    }
//    public void chooseSecondPoke(int choice){
//        this.getPokedex().getPokedex().add(getStarterPack().get(choice+4));
//        System.out.println("You chose " + getStarterPack().get(choice+4).getName() );
//    }
}
