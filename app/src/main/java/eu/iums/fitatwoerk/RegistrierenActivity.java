package eu.iums.fitatwoerk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrierenActivity extends AppCompatActivity {
    Toolbar toolbar;
    private FirebaseAuth mAuth;
    private Button buttonRegister;
    private EditText editTextName,editTextAge, editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrieren);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");

        mAuth = FirebaseAuth.getInstance();

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


    }


    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String age = editTextAge.getText().toString().trim();

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

                            User user = new User(name, age, email);
                    // prüfen, ob Task erfolgreich war
                            FirebaseDatabase.getInstance().getReference("Users")
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