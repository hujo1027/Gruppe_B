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
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.slider.Slider;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    //private TextView nameTextView;
    private FirebaseAuth mAuth;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageButton u1;ImageButton u2;ImageButton u3;ImageButton u4;ImageButton u5;ImageButton u6;ImageButton u7;ImageButton u8;ImageButton u9;ImageButton u10;ImageButton u11;ImageButton u12;ImageButton u13;ImageButton u14;ImageButton u15;ImageButton u16;ImageButton u17;ImageButton u18;ImageButton u19;ImageButton u20;ImageButton u21;ImageButton u22;ImageButton u23;ImageButton u24;ImageButton u25;ImageButton u26;ImageButton u27;ImageButton u28;ImageButton u29;ImageButton u30;ImageButton u31;ImageButton u32;ImageButton u33;ImageButton u34;ImageButton u35;ImageButton u36;ImageButton u37;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_burgermenu);
        //nameTextView = findViewById(R.id.name);



        //Toolbar
        setSupportActionBar(toolbar);

        //öffnen des drawers durch burgericon
        toolbar.setNavigationIcon(R.drawable.ic_burgermenu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });



        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        /*if(mAuth.getCurrentUser() == null) {
            Menu menu = navigationView.getMenu();
            menu.findItem(R.id.logout).setVisible(false);
            menu.findItem(R.id.meinkonto).setVisible(false);
        } else {
            Menu menu = navigationView.getMenu();
            menu.findItem(R.id.login).setVisible(false);
        }*/

        //navigationView.bringToFront();
        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navdrawer_open, R.string.navdrawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

         */
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();


        //uebungsimagebuttons

        u1 = findViewById(R.id.imagebutton1); u1.setOnClickListener(new Click());
        u2 = findViewById(R.id.imagebutton2); u2.setOnClickListener(new Click());
        u3 = findViewById(R.id.imagebutton3); u3.setOnClickListener(new Click());
        u4 = findViewById(R.id.imagebutton4); u4.setOnClickListener(new Click());
        u5 = findViewById(R.id.imagebutton5); u5.setOnClickListener(new Click());
        u6 = findViewById(R.id.imagebutton6); u6.setOnClickListener(new Click());
        u7 = findViewById(R.id.imagebutton7); u7.setOnClickListener(new Click());
        u8 = findViewById(R.id.imagebutton8); u8.setOnClickListener(new Click());
        u9 = findViewById(R.id.imagebutton9); u9.setOnClickListener(new Click());
        u10 = findViewById(R.id.imagebutton10); u10.setOnClickListener(new Click());
        u11 = findViewById(R.id.imagebutton11); u11.setOnClickListener(new Click());
        u12 = findViewById(R.id.imagebutton12); u12.setOnClickListener(new Click());
        u13 = findViewById(R.id.imagebutton13); u13.setOnClickListener(new Click());
        u14 = findViewById(R.id.imagebutton14); u14.setOnClickListener(new Click());
        u15 = findViewById(R.id.imagebutton15); u15.setOnClickListener(new Click());
        u16 = findViewById(R.id.imagebutton16); u16.setOnClickListener(new Click());
        u17 = findViewById(R.id.imagebutton17); u17.setOnClickListener(new Click());
        u18 = findViewById(R.id.imagebutton18); u18.setOnClickListener(new Click());
        u19 = findViewById(R.id.imagebutton19); u19.setOnClickListener(new Click());
        u20 = findViewById(R.id.imagebutton20); u20.setOnClickListener(new Click());
        u21 = findViewById(R.id.imagebutton21); u21.setOnClickListener(new Click());
        u22 = findViewById(R.id.imagebutton22); u22.setOnClickListener(new Click());
        u23 = findViewById(R.id.imagebutton23); u23.setOnClickListener(new Click());
        u24 = findViewById(R.id.imagebutton24); u24.setOnClickListener(new Click());
        u25 = findViewById(R.id.imagebutton25); u25.setOnClickListener(new Click());
        u26 = findViewById(R.id.imagebutton26); u26.setOnClickListener(new Click());
        u27 = findViewById(R.id.imagebutton27); u27.setOnClickListener(new Click());
        u28 = findViewById(R.id.imagebutton28); u28.setOnClickListener(new Click());
        u29 = findViewById(R.id.imagebutton29); u29.setOnClickListener(new Click());
        u30 = findViewById(R.id.imagebutton30); u30.setOnClickListener(new Click());
        u31 = findViewById(R.id.imagebutton31); u31.setOnClickListener(new Click());
        u32 = findViewById(R.id.imagebutton32); u32.setOnClickListener(new Click());
        u33 = findViewById(R.id.imagebutton33); u33.setOnClickListener(new Click());
        u34 = findViewById(R.id.imagebutton34); u34.setOnClickListener(new Click());
        u35 = findViewById(R.id.imagebutton35); u35.setOnClickListener(new Click());
        u36 = findViewById(R.id.imagebutton36); u36.setOnClickListener(new Click());
        u37 = findViewById(R.id.imagebutton37); u37.setOnClickListener(new Click());






    }



    public class Click implements View.OnClickListener{
        @Override
        public void onClick(View v){

            switch (v.getId()) {

                case R.id.imagebutton1:
                    Intent intentu1 = new Intent(v.getContext(), UebungActivity.class);
                    intentu1.putExtra("KEY", "uebung1");
                    startActivity(intentu1);
                    break;
                case R.id.imagebutton2:
                    Intent intentu2 = new Intent(v.getContext(), UebungActivity.class);
                    intentu2.putExtra("KEY", "uebung2");
                    startActivity(intentu2);
                    break;
                case R.id.imagebutton3:
                    Intent intentu3 = new Intent(v.getContext(), UebungActivity.class);
                    intentu3.putExtra("KEY", "uebung3");
                    startActivity(intentu3);
                    break;
                case R.id.imagebutton4:
                    Intent intentu4 = new Intent(v.getContext(), UebungActivity.class);
                    intentu4.putExtra("KEY", "uebung4");
                    startActivity(intentu4);
                    break;
                case R.id.imagebutton5:
                    Intent intentu5 = new Intent(v.getContext(), UebungActivity.class);
                    intentu5.putExtra("KEY", "uebung5");
                    startActivity(intentu5);
                    break;
                case R.id.imagebutton6:
                    Intent intentu6 = new Intent(v.getContext(), UebungActivity.class);
                    intentu6.putExtra("KEY", "uebung6");
                    startActivity(intentu6);
                    break;
                case R.id.imagebutton7:
                    Intent intentu7 = new Intent(v.getContext(), UebungActivity.class);
                    intentu7.putExtra("KEY", "uebung7");
                    startActivity(intentu7);
                    break;
                case R.id.imagebutton8:
                    Intent intentu8 = new Intent(v.getContext(), UebungActivity.class);
                    intentu8.putExtra("KEY", "uebung8");
                    startActivity(intentu8);
                    break;
                case R.id.imagebutton9:
                    Intent intentu9 = new Intent(v.getContext(), UebungActivity.class);
                    intentu9.putExtra("KEY", "uebung9");
                    startActivity(intentu9);
                    break;
                case R.id.imagebutton10:
                    Intent intentu10 = new Intent(v.getContext(), UebungActivity.class);
                    intentu10.putExtra("KEY", "uebung10");
                    startActivity(intentu10);
                    break;
                case R.id.imagebutton11:
                    Intent intentu11 = new Intent(v.getContext(), UebungActivity.class);
                    intentu11.putExtra("KEY", "uebung11");
                    startActivity(intentu11);
                    break;
                case R.id.imagebutton12:
                    Intent intentu12 = new Intent(v.getContext(), UebungActivity.class);
                    intentu12.putExtra("KEY", "uebung12");
                    startActivity(intentu12);
                    break;
                case R.id.imagebutton13:
                    Intent intentu13 = new Intent(v.getContext(), UebungActivity.class);
                    intentu13.putExtra("KEY", "uebung13");
                    startActivity(intentu13);
                    break;
                case R.id.imagebutton14:
                    Intent intentu14 = new Intent(v.getContext(), UebungActivity.class);
                    intentu14.putExtra("KEY", "uebung14");
                    startActivity(intentu14);
                    break;
                case R.id.imagebutton15:
                    Intent intentu15 = new Intent(v.getContext(), UebungActivity.class);
                    intentu15.putExtra("KEY", "uebung15");
                    startActivity(intentu15);
                    break;
                case R.id.imagebutton16:
                    Intent intentu16 = new Intent(v.getContext(), UebungActivity.class);
                    intentu16.putExtra("KEY", "uebung16");
                    startActivity(intentu16);
                    break;
                case R.id.imagebutton17:
                    Intent intentu17 = new Intent(v.getContext(), UebungActivity.class);
                    intentu17.putExtra("KEY", "uebung17");
                    startActivity(intentu17);
                    break;
                case R.id.imagebutton18:
                    Intent intentu18 = new Intent(v.getContext(), UebungActivity.class);
                    intentu18.putExtra("KEY", "uebung18");
                    startActivity(intentu18);
                    break;
                case R.id.imagebutton19:
                    Intent intentu19 = new Intent(v.getContext(), UebungActivity.class);
                    intentu19.putExtra("KEY", "uebung19");
                    startActivity(intentu19);
                    break;case R.id.imagebutton20:
                    Intent intentu20 = new Intent(v.getContext(), UebungActivity.class);
                    intentu20.putExtra("KEY", "uebung20");
                    startActivity(intentu20);
                    break;
                case R.id.imagebutton21:
                    Intent intentu21 = new Intent(v.getContext(), UebungActivity.class);
                    intentu21.putExtra("KEY", "uebung21");
                    startActivity(intentu21);
                    break;
                case R.id.imagebutton22:
                    Intent intentu22 = new Intent(v.getContext(), UebungActivity.class);
                    intentu22.putExtra("KEY", "uebung22");
                    startActivity(intentu22);
                    break;
                case R.id.imagebutton23:
                    Intent intentu23 = new Intent(v.getContext(), UebungActivity.class);
                    intentu23.putExtra("KEY", "uebung23");
                    startActivity(intentu23);
                    break;
                case R.id.imagebutton24:
                    Intent intentu24 = new Intent(v.getContext(), UebungActivity.class);
                    intentu24.putExtra("KEY", "uebung24");
                    startActivity(intentu24);
                    break;
                case R.id.imagebutton25:
                    Intent intentu25 = new Intent(v.getContext(), UebungActivity.class);
                    intentu25.putExtra("KEY", "uebung25");
                    startActivity(intentu25);
                    break;
                case R.id.imagebutton26:
                    Intent intentu26 = new Intent(v.getContext(), UebungActivity.class);
                    intentu26.putExtra("KEY", "uebung26");
                    startActivity(intentu26);
                    break;
                case R.id.imagebutton27:
                    Intent intentu27 = new Intent(v.getContext(), UebungActivity.class);
                    intentu27.putExtra("KEY", "uebung27");
                    startActivity(intentu27);
                    break;
                case R.id.imagebutton28:
                    Intent intentu28 = new Intent(v.getContext(), UebungActivity.class);
                    intentu28.putExtra("KEY", "uebung28");
                    startActivity(intentu28);
                    break;
                case R.id.imagebutton29:
                    Intent intentu29 = new Intent(v.getContext(), UebungActivity.class);
                    intentu29.putExtra("KEY", "uebung29");
                    startActivity(intentu29);
                    break;
                case R.id.imagebutton30:
                    Intent intentu30 = new Intent(v.getContext(), UebungActivity.class);
                    intentu30.putExtra("KEY", "uebung30");
                    startActivity(intentu30);
                    break;
                case R.id.imagebutton31:
                    Intent intentu31 = new Intent(v.getContext(), UebungActivity.class);
                    intentu31.putExtra("KEY", "uebung31");
                    startActivity(intentu31);
                    break;
                case R.id.imagebutton32:
                    Intent intentu32 = new Intent(v.getContext(), UebungActivity.class);
                    intentu32.putExtra("KEY", "uebung32");
                    startActivity(intentu32);
                    break;
                case R.id.imagebutton33:
                    Intent intentu33 = new Intent(v.getContext(), UebungActivity.class);
                    intentu33.putExtra("KEY", "uebung33");
                    startActivity(intentu33);
                    break;
                case R.id.imagebutton34:
                    Intent intentu34 = new Intent(v.getContext(), UebungActivity.class);
                    intentu34.putExtra("KEY", "uebung34");
                    startActivity(intentu34);
                    break;
                case R.id.imagebutton35:
                    Intent intentu35 = new Intent(v.getContext(), UebungActivity.class);
                    intentu35.putExtra("KEY", "uebung35");
                    startActivity(intentu35);
                    break;
                case R.id.imagebutton36:
                    Intent intentu36 = new Intent(v.getContext(), UebungActivity.class);
                    intentu36.putExtra("KEY", "uebung36");
                    startActivity(intentu36);
                    break;
                case R.id.imagebutton37:
                    Intent intentu37 = new Intent(v.getContext(), UebungActivity.class);
                    intentu37.putExtra("KEY", "uebung37");
                    startActivity(intentu37);
                    break;


            }

        }

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {



        switch(item.getItemId()) {
            case R.id.uebungen:
                Intent intent_exercises = new Intent(this, MainActivity.class);
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
                    Toast.makeText(this, " Ausgeloggt", Toast.LENGTH_LONG).show();
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