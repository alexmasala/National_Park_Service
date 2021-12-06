package ro.ase.seminar1;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONRead {

    public void read(String param_url, IResponse response){
        try {
            URL url = new URL(param_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            StringBuilder result= new StringBuilder();
            String line = "";
            while((line = bufferedReader.readLine())!=null){
                result.append(line);

            }

            List<Parc> list=Parsare(result.toString());

            response.onSuccess(list);


            Log.v("Rezultat ", list.toString());
            bufferedReader.close();
            streamReader.close();
            inputStream.close();



        } catch (MalformedURLException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        }
    }

    private List<Parc> Parsare(String jsonString){
        List<Parc> listaJSON=new ArrayList<>();
        try {
            JSONObject object=new JSONObject(jsonString);
            JSONArray array=object.getJSONArray("parcuri");
            for(int i=0;i<array.length();i++){
                JSONObject jsonObject =array.getJSONObject(i);
                String localizare=jsonObject.getString("localizare");
                String program=jsonObject.getString("program");
                String traseuturistic=jsonObject.getString("traseuturistic");
                int pret =jsonObject.getInt("pret");

                Parc parc=new Parc(localizare,program,traseuturistic,pret);
                listaJSON.add(parc);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listaJSON;
    }
}
