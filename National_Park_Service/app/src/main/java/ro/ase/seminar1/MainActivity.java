package ro.ase.seminar1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private MeniuAdapter meniuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meniuAdapter = new MeniuAdapter(getParcuri());
        listview = findViewById(R.id.listview);
        listview.setAdapter(meniuAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Random rnd = new Random(1);
                int rnd_int = rnd.nextInt();
                if(rnd_int%2==0)
                    meniuAdapter.update_list(getParcuri());
                else meniuAdapter.update_list(getParcuri2());
            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                meniuAdapter.getItem(position);
                Toast.makeText(MainActivity.this, meniuAdapter.getItem(position).toString(),Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    private List<Parc> getParcuri(){
        List<Parc> lst = new ArrayList<>();
        lst.add(new Parc("Parcul din Craiova","09:00 - 22:00","Traseul Solomon"));
        lst.add(new Parc("Parcul din Cluj","09:00 - 22:00","Traseul Dubrava"));
        lst.add(new Parc("Parcul din Bucuresti","09:00 - 22:00","Traseul Apalachia"));
        return lst;
    }

    private List<Parc> getParcuri2(){
        List<Parc> lst = new ArrayList<>();
        lst.add(new Parc("Parcul din Craiova","10:00 - 22:00","Traseul Solo"));
        lst.add(new Parc("Parcul din Cluj","11:00 - 22:00","Traseul Dub"));
        lst.add(new Parc("Parcul din Bucuresti","10:00 - 22:00","Traseul Apa"));
        return lst;
    }
}
