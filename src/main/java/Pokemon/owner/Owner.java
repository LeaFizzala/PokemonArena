package Pokemon.owner;

import Pokemon.pokemons.Fighting;
import Pokemon.pokemons.Pokemon;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Pokemon.QueryPokemon.getStarterPack;

public class Owner implements Fighting {
    private String name;
    private int level;
    private Pokedex pokedex;

    public Owner(String name, int level){
        this.name = name;
        this.level = level;
        this.pokedex = new Pokedex(this);
    }
    public Owner() {

        this.pokedex = new Pokedex(this);
        Scanner scan = new Scanner(System.in);
        System.out.println("What's your name ?");
        this.name = scan.nextLine();
        System.out.println("Welcome, " + this.name + ".");
        int teamChoice = -1;
        do {
            try {
                System.out.println("Choose your first Pokemon. \n" +
                        getStarterPack().get(0).getName()+ "\n"+
                        getStarterPack().get(1).getName()+ "\n"+
                        getStarterPack().get(2).getName()+ "\n"+
                        getStarterPack().get(3).getName()+ "\n"+
                        getStarterPack().get(4).getName()+ "\n"+
                        getStarterPack().get(5).getName()

                );
                teamChoice = readChoice(scan);
            } catch (InputMismatchException e) {
                System.err.println("[ " + e.getMessage() + " ]");
            }
        } while (teamChoice < 0);

        this.chooseFirstPoke(teamChoice);
//        switch(teamChoice) {
//            case 1:
//                this.getPokedex().getPokedex().add(getStarterPack().get(2));
//                this.getPokedex().getPokedex().add(getStarterPack().get(13));
//                this.getPokedex().getPokedex().add(getStarterPack().get(20));
//                break;
//            case 2:
//                this.getPokedex().getPokedex().add(getThePokemons().get(2));
//                this.getPokedex().getPokedex().add(getThePokemons().get(2));
//                this.getPokedex().getPokedex().add(getThePokemons().get(2));
//                break;
//            case 3:
//                this.getPokedex().getPokedex().add(getThePokemons().get(2));
//                this.getPokedex().getPokedex().add(getThePokemons().get(2));
//                this.getPokedex().getPokedex().add(getThePokemons().get(2));
//                break;
//
//        }


    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Pokedex getPokedex() {
        return pokedex;
    }



    @Override
    public void fight(Owner owner) {
        System.out.println(this.name + " provoque " + owner.getName() + " en duel ! " );
        int round =1;
        // tant que les joueurs ont encore des Pokémons en vie dans leur liste
        while(this.getPokedex().getPokedex().size()>0 && owner.getPokedex().getPokedex().size()>0){

                System.out.println("<<<<<< Combat n°" + round + " >>>>>>>");
                Pokemon combattant1 =  this.getPokedex().choisirCombattant();
                Pokemon combattant2 = owner.getPokedex().choisirCombattant(owner.getPokedex().getPokedex().size()-1);
                System.out.println(combattant1.getName() + " affronte " + combattant2.getName() + " ! \n" +
                        "***********************************");
                round++;

                //tant que les Pokémons sélectionnés ont des HP
                while(combattant1.getHP()>0 && combattant2.getHP()>0){

                    if(combattant1.getHP()>0){
                        combattant1.attaque(combattant2);

                        if(combattant2.getHP()<=0){
                            System.out.println(combattant2.getName() + " est éliminé ! \n" +
                                    "-----------------------------------------");
                            owner.getPokedex().getPokedex().remove(combattant2);
                            System.out.println("Pokémons restants pour " + owner.getName() + " : " + owner.getPokedex().getPokedex().size());
                        }
                    }

                    if(combattant2.getHP()>0) {
                        combattant2.attaque(combattant1);
                        if(combattant1.getHP()<=0){
                            System.out.println(combattant1.getName() + " est éliminé !\n" +
                                    "------------------------------------------");
                            this.getPokedex().getPokedex().remove(combattant1);
                            System.out.println("Pokémons restants pour " + this.getName() + " : " + this.getPokedex().getPokedex().size());

                        }
                    }
                }
        }
    }

    @Override
    public void rest() {
        for (Pokemon p : this.getPokedex().getPokedex()
             ) {
            p.rest();
        }
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
        }
        return number;
    }
    public void chooseFirstPoke(int choice){
        this.getPokedex().getPokedex().add(getStarterPack().get(choice-1));
        System.out.println("You chose " + getStarterPack().get(choice-1).getName() );
    }
}
