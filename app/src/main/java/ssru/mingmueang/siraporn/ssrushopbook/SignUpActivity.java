package ssru.mingmueang.siraporn.ssrushopbook;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
            myAlert.myDialog(this, "ข้อมูลไม่ครบถ้วน", "กรุณากรอกให้ครบถ้วน");

        } else {
            //no Space
            urlUploadNewUser();
        }


    }   //clickSign

    private void urlUploadNewUser() {

    }   // uplodeNewUser

} //Main Class
