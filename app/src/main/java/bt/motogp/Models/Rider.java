package bt.motogp.Models;

import java.util.Random;

/**
 * Created by 608258605 on 20/05/2015.
 */
public class Rider {
    public String name;
    public String team;
    public int position;
    public int speed;
    public int lastLapTime;
    public int avgLapTime;


    public Rider(String Name, String Team, int Position)
    {
        this.name= Name;
        this.team = Team;
        this.position = Position;
        Random random = new Random();
        this.speed = 200 +  random.nextInt(150);
        this.lastLapTime = 60 + random.nextInt(240);
        this.avgLapTime= 60 + random.nextInt(290);



    }

    @Override
    public String toString()
    {
        return this.position + " : " + this.name + " " + this.team;
    }

}
