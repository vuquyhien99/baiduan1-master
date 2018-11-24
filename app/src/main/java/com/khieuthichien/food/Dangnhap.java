package com.khieuthichien.food;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class Dangnhap extends AppCompatActivity {
    private ImageView imgLogo;
    private EditText edUserName;
    private EditText edPassWord;
    private CheckBox chkRememberPass;
    private Button loginDangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        initViews();
        loginDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edUserName.getText().toString().trim();
                String pass = edPassWord.getText().toString().trim();
                if (pass.length() < 6 || user.isEmpty() || pass.isEmpty()) {

                    if (user.isEmpty()) edUserName.setError(getString(R.string.notify_empty_user));

                    if (pass.length() < 6)
                        edPassWord.setError(getString(R.string.notify_length_pass));

                    if (pass.isEmpty()) edPassWord.setError(getString(R.string.notify_empty_pass));


                } else{

                    final ProgressDialog progressDialog=new ProgressDialog(Dangnhap.this);
                    final int[]a={0};
                    progressDialog.setTitle("Đang đăng nhập");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);


                    CountDownTimer countDownTimer=new CountDownTimer(1500,40) {
                        @Override
                        public void onTick(long l) {
                            a[0] = a[0] + 4;
                            progressDialog.show();
                            progressDialog.setProgress(a[0]);

                        }

                        @Override
                        public void onFinish() {
                            progressDialog.dismiss();
                            startActivity(new Intent(Dangnhap.this, Trangchu.class));

                        }
                    }.start();
                }
            }
        });


    }
    public void initViews() {
        edUserName = findViewById(R.id.edemail);
        edPassWord = findViewById(R.id.edtpassword);
        chkRememberPass = findViewById(R.id.cbRememberPasswork);
        loginDangnhap = findViewById(R.id.btdangnhap);

    }
}
