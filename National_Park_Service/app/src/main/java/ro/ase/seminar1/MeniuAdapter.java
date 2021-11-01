package ro.ase.seminar1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MeniuAdapter extends BaseAdapter {

    private List<Parc> lista;

    public MeniuAdapter(List<Parc> lista){
        this.lista = lista;
    }
    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Parc getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater infl = LayoutInflater.from(parent.getContext());
        View itemView = infl.inflate(R.layout.item_meniuri, parent, false);
        TextView t_localizare = itemView.findViewById(R.id.localizare);
        TextView t_program = itemView.findViewById(R.id.program);
        TextView t_traseuTuristic = itemView.findViewById(R.id.traseuTuristic);
        Parc current = lista.get(position);
        t_localizare.setText(current.getLocalizare());
        t_program.setText(current.getProgram());
        t_traseuTuristic.setText(current.getTraseuTuristic());
        return itemView;
    }

    public void update_list(List<Parc> lista_noua){
        this.lista.clear();
        this.lista.addAll(lista_noua);
        notifyDataSetChanged();
    }
}
