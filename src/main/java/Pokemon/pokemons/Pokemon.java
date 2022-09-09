package Pokemon.pokemons;

import javax.persistence.*;

@Entity
@Table(name="pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_pokemon")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="Type_1")
    private String type1;

    @Column(name="Type_2")
    private String type2;

    @Column(name="Total")
    private int total;

    @Column(name="hp")
    private int HP;
    @Column(name="def")
    private int DP;
    @Column(name="atk")
    private int ATK;
    @Column(name="Sp_Atk")
    private int spAtk;
    @Column(name="Sp_Def")
    private int spDef;
    @Column(name="Speed")
    private int speed;



    public Pokemon() {}

    public Pokemon(int id, String name, String type1, String type2, int total, int HP, int DP, int ATK, int spAtk, int spDef, int speed) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.HP = HP;
        this.DP = DP;
        this.ATK = ATK;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.speed = speed;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDP() {
        return DP;
    }

    public void setDP(int DP) {
        this.DP = DP;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getSpAtk() {
        return spAtk;
    }

    public void setSpAtk(int spAtk) {
        this.spAtk = spAtk;
    }

    public int getSpDef() {
        return spDef;
    }

    public void setSpDef(int spDef) {
        this.spDef = spDef;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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
        System.out.println(this.getName() + " se repose et regagne " + (HP-HP) + " HP.");
        this.setHP(HP);
    }

    public int getId() {
        return this.id;
    }
}
