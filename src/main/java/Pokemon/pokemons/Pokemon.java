package Pokemon.pokemons;

public class Pokemon {

    private int HPmax;
    private int HP = HPmax;
    private int DP;
    private int ATK;
    private String name;

    private int level;

    public Pokemon() {}

    public Pokemon(int HPmax, int HP, int DP, int ATK, String name) {
        this.HPmax = HPmax;
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

    public int getHPmax() {
        return HPmax;
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
    public void rest(){
        System.out.println(this.getName() + " se repose et regagne " + (HPmax-HP) + " HP.");
        this.setHP(HPmax);
    }
}
