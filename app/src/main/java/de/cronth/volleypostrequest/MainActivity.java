package de.cronth.volleypostrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtName;
    EditText txtPassword;
    Button btnSend;
    String name;
    String password;
    SendData sendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txt_name);
        txtPassword = findViewById(R.id.txt_password);
        btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = txtName.getText().toString();
                password = txtPassword.getText().toString();
                if (name.length() == 0 || password.length() == 0) {
                    Toast.makeText(MainActivity.this, "Bitte Name und PW eingeben", Toast.LENGTH_SHORT).show();
                } else {
                    sendData = new SendData(name, password);
                    if (sendData.sendToPC()) {
                        Toast.makeText(MainActivity.this, "Alles klar", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}