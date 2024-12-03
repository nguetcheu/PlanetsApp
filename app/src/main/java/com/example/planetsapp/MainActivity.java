package com.example.planetsapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listViewPlanet);

        // Initialiser la HashMap des planètes
        HashMap<String, Planet> planetsMap = new HashMap<>();
        planetsMap.put("Mercury", new Planet("Mercury", R.drawable.mercury, 2));
        planetsMap.put("Venus", new Planet("Venus", R.drawable.venus, 3));
        planetsMap.put("Terre", new Planet("Terre", R.drawable.earth, 5));
        planetsMap.put("Mars", new Planet("Mars", R.drawable.mars, 4));
        planetsMap.put("Jupiter", new Planet("Jupiter", R.drawable.jupiter, 79));
        planetsMap.put("Neptune", new Planet("Neptune", R.drawable.neptune, 5));
        planetsMap.put("Saturn", new Planet("Saturn", R.drawable.saturn, 7));
        planetsMap.put("Uranus", new Planet("Uranus", R.drawable.uranus, 12));
        planetsMap.put("Pluto", new Planet("Pluto", R.drawable.uranus, 1));

        // Extraire les planètes sous forme de liste
        ArrayList<Planet> planetArrayList = new ArrayList<>(planetsMap.values());

        // 2- Chargement des données et configuration adapter
        PlanetAdapter planetAdapter = new PlanetAdapter(
                this,
                planetArrayList
        );

        // 3- Liaison de l'adapter a la liste view
        listView.setAdapter(planetAdapter);
    }
}