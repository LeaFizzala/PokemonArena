package Pokemon.pokemons;

public class PokeInsecte extends Pokemon {
    private String type = "insecte";

    public PokeInsecte(int HP, int DP, int ATK, String name) {
        super(HP, DP, ATK, name);
    }

    public String getType() {
        return type;
    }
}
