package eu.iums.fitatwoerk;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    private FirebaseAuth mAuth;
    private Button buttonRegister, buttonLogin;
    private EditText editTextEmail, editTextPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);

        editTextEmail = findViewById(R.id.editEmail);
        editTextPassword = findViewById(R.id.editPassword);
        editTextPassword.setTransformationMethod(new PasswordTransformationMethod());
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonRegister:
                startActivity(new Intent(this, RegistrierenActivity.class));
                break;
            case R.id.buttonLogin:
                userLogin();
                break;
        }
    }

    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

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

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    // User zum Profil zurückleiten
                    startActivity(new Intent(LoginActivity.this, MainActivity.class ));
                    Toast.makeText(LoginActivity.this, "Eingeloggt.", Toast
                            .LENGTH_LONG).show();

                } else {
                    Toast.makeText(LoginActivity.this, "Login fehlgeschlagen, bitte Anmeldedaten überprüfen.", Toast
                            .LENGTH_LONG).show();
                }
            }
        });
    }
}
