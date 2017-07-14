package a123.example.com.myapp;

/**
 * Created by vijay on 31-01-2017.
 */
public class Config {
    //Address of our scripts of the CRUD
    public static final String URL_ADD="http://rkm000352.000webhostapp.com/CRUD/addEmp.php";
    public static final String URL_GET_ALL = "http://rkm000352.000webhostapp.com/CRUD/getAllEmp.php";
    public static final String URL_GET_ALL2 = "http://rkm000352.000webhostapp.com/CRUD/getAllEmp2.php";
    public static final String URL_GET_EMP = "http://rkm000352.000webhostapp.com/CRUD/getEmp.php?id=";
   // public static final String URL_GET_EMP1 = "http://192.168.137.1/CRUD/getEmp1.php?id=";
    //public static final String URL_GET_EMP2 = "http://10.129.97.116/CRUD/getEmpp.php?id=";
    public static final String URL_UPDATE_EMP = "http://rkm000352.000webhostapp.com/CRUD/updateEmp.php";
    public static final String URL_UPDATE_EMP1 = "http://rkm000352.000webhostapp.com/CRUD/updateEmp1.php";
    public static final String URL_UPDATE_EMP2 = "http://rkm000352.000webhostapp.com/CRUD/updateEmp2.php";
    public static final String URL_DELETE_EMP = "http://rkm000352.000webhostapp.com/CRUD/deleteEmp.php?id=";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAME = "name";
    public static final String KEY_EMP_COLLEGE = "college";
    public static final String KEY_EMP_TITLE ="title";
 public static final String KEY_EMP_EMAIL ="email";
 public static final String KEY_EMP_PHNO ="phno";

    public static final String KEY_CAND_J1INDRO="j1indro";
    public static final String KEY_CAND_J1CONTENT="j1content";
    public static final String KEY_CAND_J1KNOWLEDGE="j1knowledge";
    public static final String KEY_CAND_J1QUERY="j1query";
    public static final String KEY_CAND_J1TOTAL="j1total";
    public static final String KEY_CAND_J2INDRO="j2indro";
    public static final String KEY_CAND_J2CONTENT="j2content";
    public static final String KEY_CAND_J2KNOWLEDGE="j2knowledge";
    public static final String KEY_CAND_J2QUERY="j2query";
    public static final String KEY_CAND_J2TOTAL="j2total";
    public static final String KEY_CAND_TOTAL="total";
    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_COLLEGE = "college";
    public static final String TAG_TITLE = "title";
    public static final String TAG_J1INDRO="j1indro";
    public static final String TAG_J1CONTENT="j1content";
    public static final String TAG_J1KNOWLEDGE="j1knowledge";
    public static final String TAG_J1QUERY="j1query";
    public static final String TAG_J1TOTAL="j1total";
    public static final String TAG_J2INDRO="j2indro";
    public static final String TAG_J2CONTENT="j2content";
    public static final String TAG_J2KNOWLEDGE="j2knowledge";
    public static final String TAG_J2QUERY="j2query";
    public static final String TAG_J2TOTAL="j2total";
    public static final String TAG_TOTAL="total";
    //employee id to pass with intent
    public static final String EMP_ID = "emp_id";
}
