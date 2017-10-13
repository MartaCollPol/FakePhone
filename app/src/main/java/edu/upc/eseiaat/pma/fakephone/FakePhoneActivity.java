package edu.upc.eseiaat.pma.fakephone;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FakePhoneActivity extends AppCompatActivity {

    private TextView old_text;
    private  TextView phone_text;
    private int all_buttons_id[] = {
            R.id.btn_0,R.id.btn_1,R.id.btn_2,R.id.btn_3,R.id.btn_4,R.id.btn_5,R.id.btn_6,R.id.btn_7,
            R.id.btn_8,R.id.btn_9
    };

    // Apliquem la propietat freezesText a l'xml per a TextView per a mantenir el seu valor en rotar el dispositiu
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Afegim un layout diferent per quan tenim el mòbil en horitzontal.
        switch (getResources().getConfiguration().orientation) {
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_fake_phone);
                break;
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity_rotated_fake_phone);
                break;
        }


        phone_text = (TextView) findViewById(R.id.phone_text);
        old_text = phone_text;
        Button delete = (Button) findViewById(R.id.btn_delete);
        Button call = (Button) findViewById(R.id.btn_call);
        Button finish = (Button) findViewById(R.id.btn_finish);


        for(int i=0; i<all_buttons_id.length;i++){
            final Button btn_num = (Button) findViewById(all_buttons_id[i]);
            btn_num.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){

                    String s = btn_num.getText().toString();
                    phone_text.setText(old_text.getText().toString()+s);

                }

            });

        }
        // Eliminem l'últim caràcter introduit
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String s = old_text.getText().toString();
                phone_text.setText(s.substring(0,s.length()-1));
            }
        });

        call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(FakePhoneActivity.this, R.string.calling, Toast.LENGTH_SHORT).show();
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


}
