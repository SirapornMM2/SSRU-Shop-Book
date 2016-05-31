package ssru.mingmueang.siraporn.ssrushopbook;

import android.app.DownloadManager;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import static ssru.mingmueang.siraporn.ssrushopbook.R.id.editText3;

public class SignUpActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private EditText nameEditText, surnameEditText, userEditText , passEditText;
    private String nameString, surString, userString, passString;

    private static final String urlUpload = "http://swiftcodingthai.com/ssru/add_user_SRP.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Bind Widget
        nameEditText = (EditText) findViewById(R.id.editText);
        surnameEditText = (EditText) findViewById(R.id.editText2);
        userEditText = (EditText) findViewById(editText3);
        passEditText = (EditText) findViewById(R.id.editText4);


    } //Main Method

    public void clickSignUpSign(View view){

        nameString = nameEditText.getText().toString().trim();
        surString = surnameEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passString = passEditText.getText().toString().trim();

        //Check Space ตรวจสอบหาความว่างเปล่าของสิ่งที่กรอก
        if (nameString.equals("") || surString.equals("") ||
                userString.equals("")|| passString.equals("")) {
            //Have Space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "ข้อมูลไม่ครบถ้วน", "กรุณากรอกข้อมูลให้ครบถ้วน");

        } else {
            //no Space
            urlUploadNewUser();
        }


    }   //clickSign

    private void urlUploadNewUser() {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd" , "true")
                .add("Name" , nameString)
                .add("Surname" , surString)
                .add("User" , userString)
                .add("Password" , passString)
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url("http://swiftcodingthai.com/ssru/add_user_SRP.php").post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                finish();

            }
        });

    }   // uplodeNewUser

} //Main Class

