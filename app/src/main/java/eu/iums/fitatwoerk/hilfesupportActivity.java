package eu.iums.fitatwoerk;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class hilfesupportActivity extends AppCompatActivity {
    Toolbar toolbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hilfesupport);

        mAuth = FirebaseAuth.getInstance();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hilfe und Support");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Benutzername anzeigen
        if(mAuth.getCurrentUser() != null) {
            TextView userNameToolbar = findViewById(R.id.name);
            userNameToolbar.setText(mAuth.getCurrentUser().getDisplayName());
            TextView userNameNavigationheader = findViewById(R.id.nameNavigation);
            userNameNavigationheader.setText(mAuth.getCurrentUser().getDisplayName());
        } else {
            TextView userNameToolbar = findViewById(R.id.name);
            userNameToolbar.setText("Nutzername");
            TextView userNameNavigationheader = findViewById(R.id.nameNavigation);
            userNameNavigationheader.setText("Nutzername");
        }
    }
}