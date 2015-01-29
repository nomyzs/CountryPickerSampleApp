package com.example.aim.jarosz.szymon.countrypicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aim.jarosz.szymon.countrypicker.R;
import com.example.aim.jarosz.szymon.countrypicker.model.CountryFlag;

/**
 * Created by Szymon on 29-Jan-15.
 */
public class CountryFlagRow extends FrameLayout implements View.OnClickListener {
    private Context context;
    private ImageView flag;
    private TextView name;
    private View root;

    public CountryFlagRow(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        root = LayoutInflater.from(context).inflate(R.layout.row_country_phone_code_internal, this, true);
        flag = (ImageView) root.findViewById(R.id.row_country_code_flag);
        name = (TextView) root.findViewById(R.id.row_country_code_name);
        root.setOnClickListener(this);
    }

    public void setCountry(CountryFlag cpc) {
        int drawableResourceId = context.getResources().getIdentifier(cpc.getCountryCode().toLowerCase(), "drawable", context.getPackageName());
        flag.setImageResource(drawableResourceId);
        name.setText(cpc.getName());
    }

    @Override
    public void onClick(View v) {

    }
}
