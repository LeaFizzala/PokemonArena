package Pokemon.arena;

import Pokemon.owner.Owner;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Owner> team;
    private int level;

    public Team() {
    }

    public Team(String name, ArrayList<Owner> teamOwners) {
        this.name = name;
        this.team = new ArrayList<>();


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Owner> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<Owner> team) {
        this.team = team;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
