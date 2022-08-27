package Pokemon.pokemons;

public class Pokemon {

    private int HP;
    private int DP;
    private int ATK;
    private String name;

    private int level;

    public Pokemon() {}

    public Pokemon(int HP, int DP, int ATK, String name) {
        this.HP = HP;
        this.DP = DP;
        this.ATK = ATK;
        this.name = name;
        this.level = 1;
    }

    public Pokemon(int HP, int DP, int ATK, String name, int level) {
        this.HP = HP;
        this.DP = DP;
        this.ATK = ATK;
        this.name = name;
        this.level = level;
    }

    public int getHP() {
        return HP;
    }

    public int getDP() {
        return DP;
    }

    public int getATK() {
        return ATK;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void attaque(Pokemon p){
        System.out.println(this.getName() + " attaque !");
         p.setHP(p.getHP()-this.getATK());
         if(p.getHP()>0) {
             System.out.println(p.getName() + " a encore " + p.getHP() + " HP.");
         }
         else{
             System.out.println(p.getName() + " perd connaissance !");
         }
    }
}
