package ro.ase.seminar1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Button btnSignUp;
    private EditText eTnume;
    //private EditText eTPrenume;
    private EditText eTParola;
    private EditText eTEmail;
    private EditText eTTelefon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnSignUp = findViewById(R.id.btn_signup);
        eTnume = findViewById(R.id.etNume);
        //eTPrenume = findViewById(R.id.etPrenume);
        eTEmail = findViewById(R.id.etEmail);
        eTParola = findViewById(R.id.etParola);
        eTTelefon = findViewById(R.id.etTelefon);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    Persoana p1 = new Persoana();
                    p1.setNume(eTnume.getText().toString());
                   // p1.setPrenume(eTPrenume.getText().toString());
                    p1.setEmail(eTEmail.getText().toString());
                    p1.setParola(eTParola.getText().toString());
                    p1.setTelefon(Integer.parseInt(eTTelefon.getText().toString()));

                    Toast.makeText(RegisterActivity.this, p1.toString(), Toast.LENGTH_SHORT).show();
                    Bundle wrapperObj = new Bundle();
                    wrapperObj.putSerializable("persoana",p1);
                    Intent intent = new Intent();
                    intent.putExtra("raspunsBundle",wrapperObj);
                    Toast.makeText(RegisterActivity.this,"Inregistrat cu succes!", Toast.LENGTH_LONG).show();
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });

    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValid() {
        if (eTnume.getText().toString().isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Completati numele", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (eTEmail.getText().toString().isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Completati emailul", Toast.LENGTH_SHORT).show();
            return false;
        }
//        if (!(isEmailValid(eTEmail.getText().toString()))) {
//            Toast.makeText(RegisterActivity.this, "Email invalid", Toast.LENGTH_SHORT).show();
//            return false;
//        }
        if (eTParola.getText().toString().isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Completati parola", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (eTTelefon.getText().toString().isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Completati nr. de telefon", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}