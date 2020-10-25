package br.com.touchsoul.meuslivros;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText ti_title;
    private TextInputEditText ti_author;
    private TextInputEditText ti_pagecount;
    private TextInputEditText ti_publisher;
    private RatingBar rBar;
    private Button btn_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonConfig();
    }

    public void buttonConfig(){
        ti_title = findViewById(R.id.ti_title);
        ti_author = findViewById(R.id.ti_author);
        ti_pagecount = findViewById(R.id.ti_pagecount);
        ti_publisher = findViewById(R.id.ti_publisher);
        rBar = findViewById(R.id.rb_book);
        btn_cadastrar = findViewById(R.id.btn_post);

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), tela_resultado_cadastrar.class);

                packageDataToActivity(i);

                startActivity(i);
            }
        });

        Button button = findViewById(R.id.btn_close);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

        Button btn_cancel = findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteUserInputs();
            }
        });
    }

    public void packageDataToActivity(Intent i){
        i.putExtra("ti_author", ti_author.getText().toString());
        i.putExtra("ti_pagecount", ti_pagecount.getText().toString());
        i.putExtra("ti_publisher", ti_publisher.getText().toString());
        i.putExtra("ti_title", ti_title.getText().toString());
        i.putExtra("rbar_value", ""+rBar.getRating());
    }

    public void deleteUserInputs(){
        ti_title.setText("");
        ti_author.setText("");
        ti_publisher.setText("");
        ti_pagecount.setText("");
        rBar.setRating(0);
    }
}