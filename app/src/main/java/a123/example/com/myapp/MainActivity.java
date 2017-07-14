package a123.example.com.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Defining views
    private EditText editTextId;
    private EditText editTextName;
    private EditText editTextDesg;
    private EditText editTextSal;
    private EditText editTextMail;
    private EditText editTextNo;

    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing views
        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextDesg = (EditText) findViewById(R.id.editTextDesg);
        editTextSal = (EditText) findViewById(R.id.editTextSalary);
        editTextMail = (EditText) findViewById(R.id.editTextMail);
        editTextNo = (EditText) findViewById(R.id.editTextNo);

        buttonAdd = (Button) findViewById(R.id.button);
        buttonView = (Button) findViewById(R.id.button5);

        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }


    //Adding an employee
    private void addEmployee(){

        final String id = editTextId.getText().toString().trim();
        final String name = editTextName.getText().toString().trim();
        final String college = editTextDesg.getText().toString().trim();
        final String title = editTextSal.getText().toString().trim();
        final String email =editTextMail.getText().toString().trim();
        final String phno = editTextNo.getText().toString().trim();
        class AddEmployee extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Adding...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_EMP_ID,id);
                params.put(Config.KEY_EMP_NAME,name);
                params.put(Config.KEY_EMP_COLLEGE,college);
                params.put(Config.KEY_EMP_TITLE,title);
                params.put(Config.KEY_EMP_EMAIL,email);
                params.put(Config.KEY_EMP_PHNO,phno);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAdd){
            addEmployee();
        }

        if(v == buttonView){
            startActivity(new Intent(this,ViewAllEmployee.class));
        }
    }
}