package com.example.KartliSuSistemi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListViewAdapter extends ArrayAdapter<Person> {

    private final LayoutInflater inflater;
    private final Context context;
    private ViewHolder holder;
    private final ArrayList<Person> persons;

    public CustomListViewAdapter(Context context, ArrayList<Person> persons) {
        super(context,0, persons);
        this.context = context;
        this.persons = persons;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Person getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return persons.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.list_view_item, null);

            holder = new ViewHolder();
            holder.personImage = (ImageView) convertView.findViewById(R.id.person_image);
            holder.personNameLabel = (TextView) convertView.findViewById(R.id.person_name_label);
            holder.personAddressLabel = (TextView) convertView.findViewById(R.id.person_address_label);
            holder.personAddressLabel2 = (TextView) convertView.findViewById(R.id.person_address_labellast);
            convertView.setTag(holder);

        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }

        Person person = persons.get(position);
        if(person != null){
            holder.personImage.setImageResource(person.getPhotoId());
            holder.personNameLabel.setText(person.getName());
            holder.personAddressLabel.setText(person.getAddress());
            holder.personAddressLabel2.setText(person.getDurum());

        }
        return convertView;
    }

    private static class ViewHolder {
        TextView personNameLabel;
        TextView personAddressLabel;
        TextView personAddressLabel2;
        ImageView personImage;

    }
}