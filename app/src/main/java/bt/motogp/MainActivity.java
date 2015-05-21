package bt.motogp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import bt.motogp.Models.RiderList;


public class MainActivity extends Activity {

    final static ArrayList<HashMap<String, ?>> data = new ArrayList<HashMap<String, ?>>();

    static{
        HashMap<String, Object> row  = new HashMap<String, Object>();
        row.put("Position", "1st");
        row.put("Name", "Valentino ROSSI");
        row.put("Team", "Yamaha");
        data.add(row);
        row  = new HashMap<String, Object>();
        row.put("Position", "2nd");
        row.put("Name", "Jorge LORENZO");
        row.put("Team", "Yamaha");
        data.add(row);
        row  = new HashMap<String, Object>();
        row.put("Position", "3rd");
        row.put("Name", "Andrea DOVIASO");
        row.put("Team", "Ducati");
        data.add(row);
        row  = new HashMap<String, Object>();
        row.put("Position", "4th");
        row.put("Name", "Marc MARQUEZ");
        row.put("Team", "Honda");
        data.add(row);
        row  = new HashMap<String, Object>();
        row.put("Position", "5th");
        row.put("Name", "Andrea IANNONE");
        row.put("Team", "Ducati");
        data.add(row);
        row  = new HashMap<String, Object>();
        row.put("Position", "6th");
        row.put("Name", "Cal CRUTCHLOW");
        row.put("Team", "Honda");
        data.add(row);
        row  = new HashMap<String, Object>();
        row.put("Position", "7th");
        row.put("Name", "Bradley SMITH");
        row.put("Team", "Yamaha");
        data.add(row);
        row  = new HashMap<String, Object>();
        row.put("Position", "8th");
        row.put("Name", "Pol ESPARGARO");
        row.put("Team", "Yamaha");
        row  = new HashMap<String, Object>();
        row.put("Position", "9th");
        data.add(row);
        row.put("Name", "Aleix ESPARGARO");
        row.put("Team", "Suzuki");
        row  = new HashMap<String, Object>();
        row.put("Position", "10th");
        row.put("Name", "Maverick VINALES");
        row.put("Team", "Suzuki");
        data.add(row);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RiderList.populate();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.leaderList);

        SimpleAdapter adapter = new SimpleAdapter(this,
                data,
                R.layout.row,
                new String[] {"Position","Name","Team"},
                new int[] {R.id.textView6, R.id.textView4,R.id.textView5});
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent riderDetailIntent = new Intent(getBaseContext(), RiderActivity.class);
                riderDetailIntent.putExtra("driverID", position);
                startActivity(riderDetailIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
