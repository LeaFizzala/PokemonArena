package Pokemon.owner;

import Pokemon.arena.Arena;
import Pokemon.pokemons.Pokemon;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

@Entity
@Table(name="pokedex")
public class Pokedex {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="pokedex_id")
    private int id;

    @Column(name="poke1_id")
    private int poke1;

    @Column(name="poke2_id")
    private int poke2;

    @Column(name="poke3_id")
    private int poke3;

    @Column(name="poke4_id")
    private int poke4;

    @Column(name="poke5_id")
    private int poke5;

    @Column(name="poke6_id")
    private int poke6;

   // private ArrayList<Pokemon> pokedex;


    public Pokedex() {
       /// this.pokedex = new ArrayList<Pokemon>();
    }

    public Pokedex(int poke1, int poke2, int poke3, int poke4, int poke5, int poke6) {
        this.poke1 = poke1;
        this.poke2 = poke2;
        this.poke3 = poke3;
        this.poke4 = poke4;
        this.poke5 = poke5;
        this.poke6 = poke6;
    }

    // public ArrayList<Pokemon> getPokedex() {
     //   return pokedex;
   // }


//    public Pokemon choisirCombattant(int b) {
//        System.out.println("Pokémon choisi: " + this.pokedex.get(b).getName());
//        return this.pokedex.get(b);
//    }

//    public Pokemon choisirCombattant() {
//        Scanner scan = new Scanner(System.in);
//
//        Pokemon chosen = null;
//        String makeYourChoice = "Choisissez le Pokémon combattant.\n";
//        StringBuilder sb = new StringBuilder(makeYourChoice);
//        for (int i = 0; i < this.getPokedex().size(); i++) {
//            sb.append((i + 1) + " - " + this.getPokedex().get(i).getName() + "\n");
//        }
//
//        int pokeChoice = -1;
//        do {
//            try {
//                System.out.println(sb);
//                pokeChoice = readChoice(scan);
//            } catch (InputMismatchException e) {
//                System.err.println("[ " + e.getMessage() + " ]");
//            }
//        } while (pokeChoice < 0);
//
//        do {
//
//                switch (pokeChoice) {
//                    case 1:
//                        chosen = this.pokedex.get(0);
//                        break;
//                    case 2:
//                        chosen = this.pokedex.get(1);
//                        break;
//                    case 3:
//                        chosen = this.pokedex.get(2);
//                        break;
//                }
//
//
//        } while (chosen == null);
//        return chosen;
//    }

    @Override
    public String toString() {
        return "Pokedex n°" + this.id + " created.";
    }

//    public int readChoice(Scanner scan) throws InputMismatchException {
//        String strNumber = scan.nextLine();
//        int number;
//        try {
//            number = Integer.parseInt(strNumber);
//        } catch (NumberFormatException e) {
//            throw new InputMismatchException("Entrez un nombre entre 1 et 3 !");
//        }
//        if (number <= 0) {
//            throw new InputMismatchException("Entrez un nombre entre 1 et 3 !");
//        } else if (number > this.pokedex.size()) {
//            throw new InputMismatchException("Entrez un nombre entre 1 et " + this.pokedex.size() + " !");
//        }
//        return number;
//    }
}
