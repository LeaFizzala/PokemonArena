package Pokemon.pokemons;

public class PokeHerbe extends Pokemon{
    private String type = "herbe";

    public PokeHerbe(int HP, int DP, int ATK, String name, int level) {
        super(HP, DP, ATK, name, level);

    }

    public PokeHerbe(int HP, int DP, int ATK, String name) {
        super(HP, DP, ATK, name);
    }

    public String getType() {
        return type;
    }
}
