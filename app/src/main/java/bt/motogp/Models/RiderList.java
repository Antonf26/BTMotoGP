package bt.motogp.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 608258605 on 20/05/2015.
 */
public class RiderList {

    static ArrayList<Rider> riders = new ArrayList<Rider>();

    public static void populate(){
        riders.add(new Rider("Valentino Rossi", "Yamaha", 1));
        riders.add(new Rider("Jorge Lorenzo", "Yamaha", 2));
        riders.add(new Rider("Andrea Dovizioso", "Ducati", 3));
    }

    public static ArrayList<Rider> GetRiders(){
        return riders;
    }



}
