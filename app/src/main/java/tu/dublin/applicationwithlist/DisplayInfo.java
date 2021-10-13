package tu.dublin.applicationwithlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        Bundle b = getIntent().getExtras();
        String city = b.getString("city");
        String country = b.getString("country");
        long city_pop = b.getLong("city population");
        long metro_pop = b.getLong("metro population");

        TextView display_country = findViewById(R.id.display_country);
        TextView display_city = findViewById(R.id.display_city);
        TextView display_pop = findViewById(R.id.display_population);
        TextView display_metro = findViewById(R.id.display_metropolitan);

        display_country.setText(country);
        display_city.setText(city);
        display_pop.setText(Long.toString(city_pop));
        display_metro.setText(Long.toString(metro_pop));
    }
}