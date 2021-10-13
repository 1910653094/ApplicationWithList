package tu.dublin.applicationwithlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

import tu.dublin.applicationwithlist.classes.City;

public class
MainActivity extends AppCompatActivity {
    ListView country_list;
    // Variable to link to our widget

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        country_list = findViewById(R.id.country_list);
        // We link our widget by finding its id (name)

        ArrayList<String> city_array = new ArrayList<>();
        ArrayList<City> cities = createArray();
        // Our data´structure to store our information about cities

        // We add a city to our array
        for (City c: cities) {
            city_array.add(c.getCity());
        }

        // We create the adapter to act as a driver between our data
        // structure and the displayed widget
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                city_array
        );
        country_list.setAdapter(adapter);

        country_list.setOnItemClickListener((AdapterView<?> adapterView, View v, int i, long l) -> {
            Toast.makeText(
                    MainActivity.this,
                    "You have clicked in " + i,
                    Toast.LENGTH_SHORT
            ).show();

            Intent intent = new Intent(MainActivity.this, DisplayInfo.class);
            Bundle b = new Bundle();
            City c = cities.get(i);
            b.putString("city", c.getCity());
            b.putString("country", c.getCountry());
            b.putLong("city population", c.getCity_pop());
            b.putLong("metro population", c.getMetro_pop());
            intent.putExtras(b);
            startActivity(intent);
        });
    }
    
    private ArrayList<City> createArray() {
        ArrayList<City> cities = new ArrayList<>();
        BufferedReader br = null;
        try {
            InputStream is = getApplicationContext().getResources().openRawResource(R.raw.cities);
            br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = br.readLine()) != null) {
                String[] lineArray = line.split(";");
                City city = new City(
                        lineArray[1],
                        lineArray[2],
                        Long.parseLong(lineArray[3].replaceAll(",", "")),
                        lineArray.length == 5 ?
                                Long.parseLong(lineArray[4].replaceAll(",", "")) :
                                0
                );
                cities.add(city);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cities;
    }
}