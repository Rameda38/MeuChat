package br.com.apps.rameda.chatfinal2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StarPageActivity extends AppCompatActivity {
    private Button btt_Logar;
    private Button btt_CriarConta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_page);

        btt_CriarConta = (Button) findViewById(R.id.btt_CriarConta);
        btt_Logar = (Button) findViewById(R.id.Btt_logar);

        btt_CriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(StarPageActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
        btt_Logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logarIntent = new Intent(StarPageActivity.this,LoginActivity.class);
                startActivity(logarIntent);
            }
        });

    }
}
