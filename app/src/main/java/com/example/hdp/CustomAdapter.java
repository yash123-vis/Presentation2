package com.example.hdp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<CountryModel>{

    private Context context;
    private List<CountryModel> countryModelsList;
    private List<CountryModel> countryModelsListFiltered;

    public CustomAdapter( Context context, List<CountryModel> countryModelsList) {
        super(context, R.layout.list_custom_item,countryModelsList);

        this.context = context;
        this.countryModelsList = countryModelsList;
        this.countryModelsListFiltered = countryModelsList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item,null,true);
        TextView tvCountryName = view.findViewById(R.id.tvCountryName);
        ImageView imageView = view.findViewById(R.id.imageFlag);

        tvCountryName.setText(countryModelsListFiltered.get(position).getCountry());
        Glide.with(context).load(countryModelsListFiltered.get(position).getFlag()).into(imageView);

        return view;
    }

    @Override
    public int getCount() {
        return countryModelsListFiltered.size();
    }

    @Nullable
    @Override
    public CountryModel getItem(int position) {
        return countryModelsListFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //search for countries

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                //filter character wise

                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){ //search should not be null
                    filterResults.count = countryModelsList.size();
                    filterResults.values = countryModelsList;

                }else{
                    List<CountryModel> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();
                    //search county from first character
                    for(CountryModel itemsModel:countryModelsList){
                        if(itemsModel.getCountry().toLowerCase().contains(searchStr)){
                            resultsModel.add(itemsModel);

                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }


                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                //match the country list with alphabet
                countryModelsListFiltered = (List<CountryModel>) results.values;
                AffectedCountriesActivity.countryModelsList = (List<CountryModel>) results.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }
}
