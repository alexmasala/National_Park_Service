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
                JSONRead reader = new JSONRead();

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        reader.read("https://jsonkeeper.com/b/PUTW", new IResponse() {
                            @Override
                            public void onSuccess(List<Parc> lista) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        meniuAdapter.update_list(lista);
                                    }
                                });
                            }

                            @Override
                            public void onError(String errMessage) {
                                Toast.makeText(MainActivity.this, errMessage, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                thread.start();
            }
        });
    }

//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Random rnd = new Random(1);
//                int rnd_int = rnd.nextInt();
//                meniuAdapter.update_list(getParcuri());
////                else meniuAdapter.update_list(getParcuri2());
//            }
//        });
//        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                meniuAdapter.getItem(position);
//                Toast.makeText(MainActivity.this, meniuAdapter.getItem(position).toString(),Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });
//
//        jsonRead= new JSONRead();
//
//        Thread thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                jsonRead.read("https://jsonkeeper.com/b/G66N", new IResponse() {
//                    @Override
//                    public void onSuccess(List<Parc> list) {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
////                                        meniuAdapter.update_list(getParcuri());
//
//                                meniuAdapter.update_list(list);
//
//                            }
//                        });
//
//                    }
//
//                    @Override
//                    public void onError(String errorMessage) {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Toast.makeText(MainActivity.this,errorMessage,Toast.LENGTH_LONG).show();
//                            }
//                        });
//
//                    }
//                });
//
//            }
//        });
//        thread.start();
//    }

    private List<Parc> getParcuri(){
        List<Parc> lst = new ArrayList<>();
        lst.add(new Parc("Parcul din Craiova","09:00 - 22:00","Traseul Solomon",20));
        lst.add(new Parc("Parcul din Cluj","09:00 - 22:00","Traseul Dubrava",15));
        lst.add(new Parc("Parcul din Bucuresti","09:00 - 22:00","Traseul Apalachia",30));
        return lst;
    }

    private List<Parc> getParcuri2(){
        List<Parc> lst = new ArrayList<>();
        lst.add(new Parc("Parcul din Craiova","10:00 - 22:00","Traseul Solo",35));
        lst.add(new Parc("Parcul din Cluj","11:00 - 22:00","Traseul Dub",25));
        lst.add(new Parc("Parcul din Bucuresti","10:00 - 22:00","Traseul Apa",10));
        return lst;
    }
}
