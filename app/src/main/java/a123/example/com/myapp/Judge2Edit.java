package a123.example.com.myapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Judge2Edit extends AppCompatActivity implements View.OnClickListener{
    private EditText editTextId;
    private EditText editTextName;
    private EditText editTextDesg;
    private EditText editTextSalary;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;



    private Button buttonUpdate;
    private Button buttonDelete;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_judge2_edit);

        Intent intent = getIntent();

        id = intent.getStringExtra(Config.EMP_ID);

        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextDesg = (EditText) findViewById(R.id.editTextDesg);
        editTextSalary = (EditText) findViewById(R.id.editTextSalary);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);

        buttonUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);

        editTextId.setText(id);

        getEmployee();
    }

    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Judge2Edit.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Config.URL_GET_EMP,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String name = c.getString(Config.TAG_NAME);
            String college = c.getString(Config.TAG_COLLEGE);
            String title = c.getString(Config.TAG_TITLE);


            editTextName.setText(name);
            editTextDesg.setText(college);
            editTextSalary.setText(title);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void updateEmployee(){
        final String name = editTextName.getText().toString().trim();
        final String college = editTextDesg.getText().toString().trim();
        final String title = editTextSalary.getText().toString().trim();
        final String j1indro =toString().trim();
        final String j1content= toString().trim();
        final String j1knowledge = toString().trim();
        final String j1query = toString().trim();
        final String j1total = toString().trim();
        final String j2indro = editText3.getText().toString().trim();
        final String j2content= editText4.getText().toString().trim();
        final String j2knowledge = editText5.getText().toString().trim();
        final String j2query = editText6.getText().toString().trim();
        final String j2total = toString().trim();
        final String total = toString().trim();



        class UpdateEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Judge2Edit.this,"Updating...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Judge2Edit.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(Config.KEY_EMP_ID,id);
                hashMap.put(Config.KEY_EMP_NAME,name);
                hashMap.put(Config.KEY_EMP_COLLEGE,college);
                hashMap.put(Config.KEY_EMP_TITLE,title);
                hashMap.put(Config.KEY_CAND_J1INDRO,j1indro);
                hashMap.put(Config.KEY_CAND_J1CONTENT,j1content);
                hashMap.put(Config.KEY_CAND_J1KNOWLEDGE,j1knowledge);
                hashMap.put(Config.KEY_CAND_J1QUERY,j1query);
                hashMap.put(Config.KEY_CAND_J1TOTAL,j1total);
                hashMap.put(Config.KEY_CAND_J2INDRO,j2indro);
                hashMap.put(Config.KEY_CAND_J2CONTENT,j2content);
                hashMap.put(Config.KEY_CAND_J2KNOWLEDGE,j2knowledge);
                hashMap.put(Config.KEY_CAND_J2QUERY,j2query);
                hashMap.put(Config.KEY_CAND_J2TOTAL,j2total);
                hashMap.put(Config.TAG_TOTAL,total);
                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(Config.URL_UPDATE_EMP2,hashMap);

                return s;
            }
        }

        UpdateEmployee ue = new UpdateEmployee();
        ue.execute();
    }

    private void deleteEmployee(){
        class DeleteEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Judge2Edit.this, "Updating...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Judge2Edit.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Config.URL_DELETE_EMP, id);
                return s;
            }
        }

        DeleteEmployee de = new DeleteEmployee();
        de.execute();
    }

    private void confirmDeleteEmployee(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to delete this candidate?");

        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteEmployee();
                        startActivity(new Intent(Judge2Edit.this,ViewAllEmployee.class));
                    }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonUpdate){
            updateEmployee();
        }

        if(v == buttonDelete){
            confirmDeleteEmployee();
        }
    }
}
