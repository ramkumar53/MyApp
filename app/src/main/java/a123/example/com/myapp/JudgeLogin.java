package a123.example.com.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JudgeLogin extends AppCompatActivity {
    private Button button3 = null;
    private EditText editText = null;
    private EditText editText2 = null;
    private String userName = null;
    private String password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_judge_login);
        button3 = (Button) findViewById(R.id.button3);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        button3.setOnClickListener(mOnClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == button3) {
                userName = editText.getText().toString();
                password = editText2.getText().toString();

                if (validateData()) {
                    finish();
                }
            }
        }
    };
    private boolean validateData() {
        if (userName.equals("evaluater1") && password.equals("cse54321")) {
            Toast.makeText(JudgeLogin.this, "Login Successfully", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), Judge1View.class);
            startActivity(intent);
            editText.requestFocus();
            return false;
        }
        if (userName.equals("evaluater2") && password.equals("cse12345")) {
            Toast.makeText(JudgeLogin.this, "Login Successfully", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), Judge2View.class);
            startActivity(intent);
            editText.requestFocus();
            return false;
        }else{
            Toast.makeText(JudgeLogin.this, "Enter Valid Username (or) Password", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), JudgeLogin.class);
            startActivity(intent);
            editText.requestFocus();
        }

        return true;
    }
}
