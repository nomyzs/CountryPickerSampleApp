package com.example.aim.jarosz.szymon.countrypicker.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.aim.jarosz.szymon.countrypicker.R;
import com.example.aim.jarosz.szymon.countrypicker.model.CountryFlag;
import com.example.aim.jarosz.szymon.countrypicker.view.CountryFlagRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Szymon on 29-Jan-15.
 */
public class CountryFlagAdapter extends RecyclerView.Adapter<CountryFlagAdapter.ViewHolder> implements Filterable {
    private List<CountryFlag> countryFlags;
    private List<CountryFlag> fullList;
    private Context context;

    public CountryFlagAdapter(List<CountryFlag> countryFlags) {
        this.fullList = countryFlags;
        this.countryFlags = countryFlags;
    }

    @Override
    public CountryFlagAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_country_phone_code, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryFlagAdapter.ViewHolder holder, int position) {
        CountryFlag cpc = countryFlags.get(position);
        ((CountryFlagRow) holder.itemView).setCountry(cpc);
    }

    @Override
    public int getItemCount() {
        return countryFlags.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                constraint = constraint.toString().toLowerCase(Locale.US);
                List<CountryFlag> filteredCodes = new ArrayList<>();
                for(CountryFlag pc : fullList){
                    if(pc.getName().toLowerCase(Locale.US).contains(constraint)){
                        filteredCodes.add(pc);
                    }
                }
                results.values = filteredCodes;
                results.count = filteredCodes.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                countryFlags = (List<CountryFlag>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public List<CountryFlag> getCountryFlags() {
        return countryFlags;
    }
}
