package br.com.apps.rameda.chatfinal2;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class LoginActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mToolbar = (Toolbar)findViewById(R.id.Toobar_login);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Voltar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
