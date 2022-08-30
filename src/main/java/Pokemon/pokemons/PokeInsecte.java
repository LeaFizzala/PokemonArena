package Pokemon.pokemons;

public class PokeInsecte extends Pokemon {
    private String type = "insecte";

    public PokeInsecte(int HPmax, int HP, int DP, int ATK, String name) {
        super(HPmax, HP, DP, ATK, name);
    }

    public String getType() {
        return type;
    }
}
