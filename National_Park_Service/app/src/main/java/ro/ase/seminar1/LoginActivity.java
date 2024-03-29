package ro.ase.seminar1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
private Button btnRegister;
private Button btnLogin;
private EditText eTParola;
private EditText eTEmail;
private final int MainActivityRequest = 100;
private ParcDAO parcDAO;
private MeniuAdapter meniuAdapter;
private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.v("oncreate", "Suntem in onCreate");
        Log.e("oncreate", "-eroare");
        Log.d("oncreate", "-debug");
        Log.i("oncreate", "-info");

        //argumentele lui makeText: un context, un msj care se afiseaza + cat timp sta msjul
        //fara show() nu ar afisa
        Toast.makeText(this,"Mesaj misto", Toast.LENGTH_LONG).show();

        Log.v("lifecycle","onCreate");

        eTEmail = findViewById(R.id.etEmail);
        eTParola = findViewById(R.id.etParola);
        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newWindow = new Intent(LoginActivity.this, RegisterActivity.class);
                //startActivity(newWindow);
                startActivityForResult(newWindow, MainActivityRequest);

            }
        });

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,"Logare cu succes!", Toast.LENGTH_LONG).show();
                Intent newWindow = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(newWindow);

                Thread thread1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        parcDAO = Database.getInstance(LoginActivity.this).getDataBase().parcDAO();
                        for (int i=0;i<getParcuri().size();i++){
                            parcDAO.insert(getParcuri().get(i));
                        }
                    }
                });
                thread1.start();
                writeToDataBase();
                readFromDatabase();
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MainActivityRequest) {
            if (resultCode == RESULT_OK) {
                if (data!=null) {
                    Bundle newBundle = data.getBundleExtra("raspunsBundle");
                    Persoana persoana = (Persoana)newBundle.getSerializable("persoana");
                    eTEmail.setText(persoana.getEmail().toString());
                    eTParola.setText(persoana.getParola().toString());
                }
            }
        }
    }

    private List<Parc> getParcuri(){
        List<Parc> lst = new ArrayList<>();
        lst.add(new Parc("Parcul din Craiova","09:00 - 22:00","Traseul Solomon",20));
        lst.add(new Parc("Parcul din Cluj","09:00 - 22:00","Traseul Dubrava",10));
        lst.add(new Parc("Parcul din Bucuresti","09:00 - 22:00","Traseul Apalachia",15));
        return lst;
    }

    private void writeToDataBase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://dam-project-efa06-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference("Parcuri");
        for (int i=0;i<getParcuri().size();i++){
            Parc p = new Parc (getParcuri().get(i).getLocalizare(),getParcuri().get(i).getProgram(),
                    getParcuri().get(i).getTraseuTuristic(),getParcuri().get(i).getPret());
            myRef.child("Parc numar "+ i).setValue(p);
        }
    }
    private void readFromDatabase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Parcuri");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Parc p = new Parc(dataSnapshot1.getValue(Parc.class).getLocalizare(),
                            dataSnapshot1.getValue(Parc.class).getProgram(),
                            dataSnapshot1.getValue(Parc.class).getTraseuTuristic(),
                            dataSnapshot1.getValue(Parc.class).getPret());
                    Log.d("citire","Parc citit " + p.toStringFB());
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("cancelled", "Failed to read value.", error.toException());
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