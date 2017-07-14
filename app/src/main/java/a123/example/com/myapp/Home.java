package a123.example.com.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    private  Button buttonj =null;
    private  Button buttona = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        buttonj = (Button) findViewById(R.id.buttonj);
        buttona = (Button) findViewById(R.id.buttona);

        buttonj.setOnClickListener(mOnClickListener);
        buttona.setOnClickListener(mOnClickListener);


    }
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == buttonj) {
                Intent intent = new Intent(getApplicationContext(), JudgeLogin.class);
                startActivity(intent);
                finish();
            } else if (view == buttona)

            {
                Intent intent = new Intent(getApplicationContext(), AdminLogin.class);
                //startActivity(intent);
                startActivity(intent);
                finish();
            }

        }
    };
}
