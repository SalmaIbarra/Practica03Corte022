package com.example.practica03corte02;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<ItemData> implements Filterable {
    private Activity context;
    private int groupId;
    private ArrayList<ItemData> originalList;
    private ArrayList<ItemData> filteredList;
    private LayoutInflater inflater;
    private ItemFilter filter;
//Adapter Alumno
    public SpinnerAdapter(Activity context, int groupId, int id, ArrayList<ItemData> list) {
        super(context, id, list);
        this.context = context;
        this.groupId = groupId;
        this.originalList = list;
        this.filteredList = list;
        this.inflater = context.getLayoutInflater();
        this.filter = new ItemFilter();
    }

    @Override
    public int getCount() {
        return filteredList.size();
    }

    @Override
    public ItemData getItem(int position) {
        return filteredList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = inflater.inflate(groupId, parent, false);
        ImageView imagen = itemView.findViewById(R.id.imgAlumno);
        imagen.setImageResource(filteredList.get(position).getImageId());
        TextView txtNombre = itemView.findViewById(R.id.lblNombe);
        txtNombre.setText(filteredList.get(position).getTxtNombre());
        TextView txtMatricula = itemView.findViewById(R.id.lblMatricula);
        txtMatricula.setText(filteredList.get(position).getTxtMatricula());
        return itemView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                List<ItemData> filteredItems = new ArrayList<>();
                for (ItemData item : originalList) {
                    if (item.getTxtNombre().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        filteredItems.add(item);
                    }
                }
                results.count = filteredItems.size();
                results.values = filteredItems;
            } else {
                results.count = originalList.size();
                results.values = originalList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredList = (ArrayList<ItemData>) results.values;
            notifyDataSetChanged();
        }
    }
}
