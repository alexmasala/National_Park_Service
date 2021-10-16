package ro.ase.seminar1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button btnRegister;
private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("oncreate", "Suntem in onCreate");
        Log.e("oncreate", "-eroare");
        Log.d("oncreate", "-debug");
        Log.i("oncreate", "-info");

        //argumentele lui makeText: un context, un msj care se afiseaza + cat timp sta msjul
        //fara show() nu ar afisa
        Toast.makeText(this,"Mesaj misto", Toast.LENGTH_LONG).show();

        Log.v("lifecycle","onCreate");

        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Inregistrat cu succes!", Toast.LENGTH_LONG).show();
                Intent newWindow = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(newWindow);
            }
        });

        btnRegister = findViewById(R.id.btn_login);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Logare cu succes!", Toast.LENGTH_LONG).show();
                Intent newWindow = new Intent(MainActivity.this, Activitate1.class);
                startActivity(newWindow);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v("lifecycle","onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v("lifecycle","onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v("lifecycle","onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v("lifecycle","onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v("lifecycle","onDestroy");

    }
}