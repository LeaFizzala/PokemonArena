package Pokemon.pokemons;

public class PokeFeu extends Pokemon{
    private String type = "fire";


    public PokeFeu(int HP, int DP, int ATK, String name, int level) {
        super(HP, DP, ATK, name, level);
    }

    public PokeFeu(int HPmax, int HP, int DP, int ATK, String name) {
        super(HPmax, HP, DP, ATK, name);
    }

    public String getType() {
        return type;
    }
}
