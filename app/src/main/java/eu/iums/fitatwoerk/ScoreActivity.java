package eu.iums.fitatwoerk;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ScoreActivity extends AppCompatActivity {
    Toolbar toolbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mAuth = FirebaseAuth.getInstance();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Score");


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView userNameToolbar = findViewById(R.id.name);

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            // User is Login
            userNameToolbar.setText("Online ");
        }

        else {
            userNameToolbar.setText("Offline ");
        }
    }
}