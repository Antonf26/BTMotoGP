package bt.motogp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import bt.motogp.Models.Rider;
import bt.motogp.Models.RiderList;


public class RiderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider);
        Intent intent = getIntent();
        int driverId = intent.getIntExtra("driverID", 0);
        populateDetails(driverId);

    }

    public void populateDetails(int driverId)
    {
        Rider rider = RiderList.GetRider(driverId);


        TextView riderName = (TextView) findViewById(R.id.riderName);
        riderName.setText("Name: " + rider.name);
        TextView teamName = (TextView) findViewById(R.id.riderTeam);
        teamName.setText("Team: " + rider.team);
        TextView riderSpeed = (TextView) findViewById(R.id.riderSpeed);
        riderSpeed.setText("Avg. Speed: " + rider.speed + "km/h");
        TextView riderLastLap = (TextView) findViewById(R.id.riderLastLap);
        riderLastLap.setText("Last Lap: " + rider.lastLapTime + "s");
        TextView riderAvgLap = (TextView) findViewById(R.id.riderAvgLap);
        riderAvgLap.setText("Avg Lap: " + rider.avgLapTime + "s" );


        ImageView driverImage = (ImageView) findViewById(R.id.riderImage);
        int imageId;
        switch(driverId)
        {
            case 0:
                imageId = R.drawable.r0;
                break;
            case 1:
                imageId = R.drawable.r1;
                break;
            default:
                imageId = R.drawable.r3;
                break;

        }
        driverImage.setImageResource(imageId);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rider, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_track) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
