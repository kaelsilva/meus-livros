package br.com.touchsoul.meuslivros;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class tela_resultado_cadastrar extends AppCompatActivity {
    private Button bt;

    private TextView tv_title;
    private TextView tv_author;
    private TextView tv_publisher;
    private TextView tv_pagecount;
    private TextView tv_rbar_value;

    String ti_title;
    String ti_author;
    String ti_publisher;
    String ti_pagecount;
    String rbar_value;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado_cadastrar);

        buttonConfig();

        Bundle bundle = new Bundle();

        bundle = receiveDataFromMainActivity(bundle);

        setBookData(bundle);
    }

    public void buttonConfig(){
        bt = findViewById(R.id.v_rc_btn_voltar);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela_resultado_cadastrar.super.finish();
            }
        });
    }

    public Bundle receiveDataFromMainActivity(Bundle bundle){
        Intent i = getIntent();

        bundle = i.getExtras();

        return bundle;
    }

    public void setBookData(Bundle bundle){
        tv_title = findViewById(R.id.v_rc_tv_title);
        tv_author = findViewById(R.id.v_rc_tv_author);
        tv_publisher = findViewById(R.id.v_rc_tv_publisher);
        tv_pagecount = findViewById(R.id.v_rc_tv_pagecount);
        tv_rbar_value = findViewById(R.id.v_rc_tv_rbar);

        ti_title = bundle.getString("ti_title");
        ti_author = bundle.getString("ti_author");
        ti_publisher = bundle.getString("ti_publisher");
        ti_pagecount = bundle.getString("ti_pagecount");
        rbar_value = bundle.getString("rbar_value");

        tv_title.setText(ti_title);
        tv_author.setText(ti_author);
        tv_publisher.setText(ti_publisher);
        tv_pagecount.setText(ti_pagecount);
        tv_rbar_value.setText(rbar_value);
    }
}
