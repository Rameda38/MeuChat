package br.com.apps.rameda.chatfinal2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Toolbar mToolbar;
    private EditText edEmail;
    private EditText edName;
    private EditText edPass;
    private Button bttCriarConta;
    private ProgressDialog loadBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mToolbar = (Toolbar)findViewById(R.id.Toobar_registro);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Voltar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edName = (EditText)findViewById(R.id.edName);
        edEmail = (EditText)findViewById(R.id.edEmail);
        edPass = (EditText)findViewById(R.id.edPass);
        bttCriarConta = (Button)findViewById(R.id.bttCriarConta);
        firebaseAuth = FirebaseAuth.getInstance();
        loadBar = new ProgressDialog(this);

        bttCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edName.getText().toString();
                String email = edEmail.getText().toString();
                String pass = edPass.getText().toString();
                
                RegistrarConta(name,email,pass);
                
            }
        });



    }

    private void RegistrarConta(String name, String email, String pass) {
        if (TextUtils.isEmpty(name)){
            Toast.makeText(RegisterActivity.this,"Por Favor Digite seu nome " , Toast.LENGTH_LONG).show();
        }
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Por Favor Digite seu Email", Toast.LENGTH_LONG).show();
        }
        if (TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Por Favor Digite seu Password",Toast.LENGTH_LONG ).show();
        }
        else{
            loadBar.setTitle("Creating new Acccount ");
            loadBar.setTitle("Please wait");
            loadBar.show();
            firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener <AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Intent mainIntent=new Intent(RegisterActivity.this, MainActivity.class);
                        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(mainIntent);
                        finish();

                    } else {
                        Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                    loadBar.dismiss();
                }

            });

        }
    }
}

