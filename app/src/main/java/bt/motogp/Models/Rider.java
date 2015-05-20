package bt.motogp.Models;

/**
 * Created by 608258605 on 20/05/2015.
 */
public class Rider {
    private String name;
    private String team;
    private int position;

    public Rider(String Name, String Team, int Position)
    {
        this.name= Name;
        this.team = Team;
        this.position = Position;
    }

    @Override
    public String toString()
    {
        return this.position + " : " + this.name + " " + this.team;
    }

}
