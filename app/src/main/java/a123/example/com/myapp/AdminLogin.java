package a123.example.com.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    private Button button4 = null;
    private EditText editText7 = null;
    private String password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        button4 = (Button) findViewById(R.id.button4);
        editText7 = (EditText) findViewById(R.id.editText7);

        button4.setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == button4) {

                password = editText7.getText().toString();

                if (password.equals("adminevaluater")) {
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    Toast.makeText(AdminLogin.this, "Login Successfully" , Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(AdminLogin.this, "Enter The Valid Password", Toast.LENGTH_LONG).show();
                    editText7.requestFocus();

                }
            }
        }



    };
}