package eu.iums.fitatwoerk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrierenActivity extends AppCompatActivity {
    Toolbar toolbar;
    private FirebaseAuth mAuth;
    private Button buttonRegister;
    private FirebaseDatabase db;
    private EditText editTextName,editTextAge, editTextEmail, editTextPassword;
    private  FirebaseUser mUser;
    private RadioGroup radioGroup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrieren);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Registrierung");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        db = FirebaseDatabase.getInstance("https://fitatwoerk-bdbf9-default-rtdb.europe-west1.firebasedatabase.app/");

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        editTextName = (EditText) findViewById(R.id.editName);
        editTextAge = (EditText) findViewById(R.id.editAge);
        editTextEmail = (EditText) findViewById(R.id.editEmail);
        editTextPassword = (EditText) findViewById(R.id.editPassword);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupSportLevel);

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


    @Override
    public void onStart() {
        super.onStart();

    }

    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String age = editTextAge.getText().toString().trim();
        radioGroup.setOnCheckedChangeListener(
                new RadioGroup
                        .OnCheckedChangeListener() {
                    @Override

                    // The flow will come here when
                    // any of the radio buttons in the radioGroup
                    // has been clicked

                    // Check which radio button has been clicked
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId)
                    {

                        // Get the selected Radio Button
                        RadioButton
                                radioButton
                                = (RadioButton)group
                                .findViewById(checkedId);
                    }
                }
        );
        int sportLevel = radioGroup.getCheckedRadioButtonId();

        if (name.isEmpty()) {
            editTextName.setError("Pflichtfeld");
            editTextName.requestFocus();
            return;
        }

        if (age.isEmpty()) {
            editTextAge.setError("Pflichtfeld");
            editTextAge.requestFocus();
            return;
        }

        if (sportLevel == -1) {
            Toast.makeText(RegistrierenActivity.this,
                            "Sportlichkeit nicht ausgewählt",
                            Toast.LENGTH_SHORT)
                    .show();
        }

        if (email.isEmpty()) {
            editTextEmail.setError("Pflichtfeld");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Bitte geben Sie eine gültige E-Mail Adresse ein.");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Pflichtfeld");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Passwort muss mind. 6 Zeichen lang sein.");
            editTextPassword.requestFocus();
            return;
        }



    // User in der Datenbank anlegen
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            User user = new User(name, age, email, sportLevel);
                    // prüfen, ob Task erfolgreich war
                            db.getReference("Users")
                                    .child(mAuth.getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            if (task.isSuccessful()) {
                                                Toast.makeText(RegistrierenActivity.this, "Nutzer wurde erfolgreich registriert.", Toast.LENGTH_LONG).show();

                                                // User zum Profil zurückleiten
                                                Intent intent_login = new Intent(RegistrierenActivity.this, LoginActivity.class);
                                                startActivity(intent_login);

                                            } else {
                                                Toast.makeText(RegistrierenActivity.this, "Registieren Fehlgeschlagen, bitte nochmal versuchen.", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });

                        } else {
                            Toast.makeText(RegistrierenActivity.this, "Registieren Fehlgeschlagen, bitte nochmal versuchen.", Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }



}
