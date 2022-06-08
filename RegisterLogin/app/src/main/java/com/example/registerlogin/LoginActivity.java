package com.example.registerlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText lId, lPwd;
    Button lLogin, lRegister;

    DataService dtService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dtService = new DataService(getApplicationContext());

        lId = findViewById(R.id.ed_lId);
        lPwd = findViewById(R.id.ed_lPwd);

        lLogin = findViewById(R.id.btn_lLogin);
        lRegister = findViewById(R.id.btn_lRegister);

        SpannableString content = new SpannableString("sign up");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        lRegister.setText(content);

        lRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        lLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = lId.getText().toString();
                String password = lPwd.getText().toString();

                UserRequestDto.Login login = new UserRequestDto.Login();
                login.setEmail(email);
                login.setPassword(password);
                System.out.println(login.getEmail());

                dtService.userApi.login(login).enqueue(new Callback<ResponseDto>() {
                    @Override
                    public void onResponse(Call<ResponseDto> call, Response<ResponseDto> response) {

                        System.out.println(response.body());
                        ResponseDto responseDto = response.body();
                        if(response.isSuccessful() && responseDto != null) {
                            System.out.println(responseDto.getMessage());
                            Toast.makeText(LoginActivity.this,
                                    email + "님 환영합니다.",
                                    Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(LoginActivity.this,
                                    "아이디와 비밀번호를 확인해주세요.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseDto> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(LoginActivity.this,
                                "오류발생.",
                                Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}