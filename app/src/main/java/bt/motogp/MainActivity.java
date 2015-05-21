package bt.motogp;

import android.app.Activity;
import android.content.Intent;
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
        row.put("Icon", R.drawable.r0);
        row.put("Name", "Valentino Rossi");
        row.put("Team", "Yamaha");
        data.add(row);
        row  = new HashMap<String, Object>();
        row.put("Icon", R.drawable.r1);
        row.put("Name", "Jorge Lorenzo");
        row.put("Team", "Yamaha");
        data.add(row);
        row  = new HashMap<String, Object>();
        row.put("Icon", R.drawable.r3);
        row.put("Name", "Andrea Doviziaso");
        row.put("Team", "Ducati");
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
                new String[] {"Icon","Name","Team"},
                new int[] { R.id.imageView, R.id.textView4,R.id.textView5});
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
