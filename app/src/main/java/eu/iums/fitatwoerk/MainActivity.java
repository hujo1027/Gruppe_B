package eu.iums.fitatwoerk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    //private TextView nameTextView;
    private FirebaseAuth mAuth;
    NavigationView navigationView;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        //nameTextView = findViewById(R.id.name);



        //Toolbar
        setSupportActionBar(toolbar);




        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() == null) {
            Menu menu = navigationView.getMenu();
            menu.findItem(R.id.logout).setVisible(false);
            menu.findItem(R.id.meinkonto).setVisible(false);
        } else {
            Menu menu = navigationView.getMenu();
            menu.findItem(R.id.login).setVisible(false);
        }

        navigationView.bringToFront();
        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navdrawer_open, R.string.navdrawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

         */
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.uebungen:
                Intent intent_exercises = new Intent(this, UebungActivity.class);
                startActivity(intent_exercises);
                break;
            case R.id.uebungssets:
                Intent intent_history = new Intent(this, UebungsetsActivity.class);
                startActivity(intent_history);
                break;
            case R.id.score:
                Intent intent_stats = new Intent(this, ScoreActivity.class);
                startActivity(intent_stats);
                break;
            case R.id.meinkonto:
                Intent intent_profile = new Intent(this, ProfilActivity.class);
                startActivity(intent_profile);
                break;
            case R.id.einstellungen:
                Intent intent_einstellungen = new Intent(this, EinstellungenActivity.class);
                startActivity(intent_einstellungen);
                break;
            case R.id.login:
                Intent intent_login = new Intent(this, LoginActivity.class);
                startActivity(intent_login);
                break;
            case R.id.logout:
                FirebaseUser user = mAuth.getCurrentUser();
                if(user != null) {
                    mAuth.signOut();
        }
                break;
            case R.id.hilfesupport:
                Intent intent = new Intent(this, hilfesupportActivity.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}