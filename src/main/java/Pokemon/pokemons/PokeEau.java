package Pokemon.pokemons;

public class PokeEau extends Pokemon{
    private final String type = "eau";

    public PokeEau(int HP, int DP, int ATK, String name, int level) {
        super(HP, DP, ATK, name, level);

    }

    public PokeEau(int HPmax, int HP, int DP, int ATK, String name) {
        super(HPmax, HP, DP, ATK, name);
    }

    public String getType() {
        return type;
    }
}
