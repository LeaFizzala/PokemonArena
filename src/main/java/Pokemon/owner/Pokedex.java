package Pokemon.owner;

import Pokemon.arena.Arena;
import Pokemon.pokemons.Pokemon;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Pokedex {

    private ArrayList<Pokemon> pokedex;
    private Owner owner;
    private Arena arena;

    public Pokedex(Owner o) {
        this.owner = o;
        this.pokedex = new ArrayList<Pokemon>();
    }
    public Pokedex(Arena a) {
        this.arena = a;
        this.pokedex = new ArrayList<Pokemon>();
    }

    public Owner getOwner() {
        return owner;
    }

    public ArrayList<Pokemon> getPokedex() {
        return pokedex;
    }

    public void ajouterPokemon(Pokemon poke) {
        this.pokedex.add(poke);
        System.out.println(poke.getName() + " a été ajouté à la collection. " + this.getOwner().getName() +
                " possède maintenant " + this.pokedex.size() + " Pokemons.");
    }

    public Pokemon choisirCombattant(int b) {
        System.out.println("Pokémon choisi: " + this.pokedex.get(b).getName());
        return this.pokedex.get(b);
    }

    public Pokemon choisirCombattant() {
        Scanner scan = new Scanner(System.in);

        Pokemon chosen = null;
        String makeYourChoice = "Choisissez le Pokémon combattant.\n";
        StringBuilder sb = new StringBuilder(makeYourChoice);
        for (int i = 0; i < this.getPokedex().size(); i++) {
            sb.append((i + 1) + " - " + this.getPokedex().get(i).getName() + "\n");
        }

        int pokeChoice = -1;
        do {
            try {
                System.out.println(sb);
                pokeChoice = readChoice(scan);
            } catch (InputMismatchException e) {
                System.err.println("[ " + e.getMessage() + " ]");
            }
        } while (pokeChoice < 0);

        do {

                switch (pokeChoice) {
                    case 1:
                        chosen = this.pokedex.get(0);
                        break;
                    case 2:
                        chosen = this.pokedex.get(1);
                        break;
                    case 3:
                        chosen = this.pokedex.get(2);
                        break;
                }


        } while (chosen == null);
        return chosen;
    }

    @Override
    public String toString() {
        return "Pokedex created for " + this.getOwner().getName();
    }

    public int readChoice(Scanner scan) throws InputMismatchException {
        String strNumber = scan.nextLine();
        int number;
        try {
            number = Integer.parseInt(strNumber);
        } catch (NumberFormatException e) {
            throw new InputMismatchException("Entrez un nombre entre 1 et 3 !");
        }
        if (number <= 0) {
            throw new InputMismatchException("Entrez un nombre entre 1 et 3 !");
        } else if (number > this.pokedex.size()) {
            throw new InputMismatchException("Entrez un nombre entre 1 et " + this.pokedex.size() + " !");
        }
        return number;
    }
}
