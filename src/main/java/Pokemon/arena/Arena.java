package Pokemon.arena;

import Pokemon.owner.Pokedex;

import java.util.ArrayList;

public class Arena {
    private String name;
    private int level;
    private Team team;

    public Arena(String name, int level, Team t) {
        this.name = name;
        this.level = level;
        this.team = new Team();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
