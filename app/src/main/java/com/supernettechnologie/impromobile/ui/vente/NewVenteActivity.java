package com.supernettechnologie.impromobile.ui.vente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.supernettechnologie.impromobile.R;

public class NewVenteActivity extends AppCompatActivity {

    private RadioGroup typ_p;
    private RadioButton r_pp, r_pm;
    private LinearLayout pp_layout, pm_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vente);

        typ_p = findViewById(R.id.type_personne);
        r_pp = findViewById(R.id.pp);
        r_pm = findViewById(R.id.pm);
        pp_layout = findViewById(R.id.pp_lay);
        pm_layout = findViewById(R.id.pm_lay);

        typ_p.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (group.getCheckedRadioButtonId() == R.id.pp) {
                    if (pp_layout.getVisibility() == View.GONE) {
                        pp_layout.setVisibility(View.VISIBLE);
                        pm_layout.setVisibility(View.GONE);
                    }
                } else if (group.getCheckedRadioButtonId() == R.id.pm) {
                    if (pm_layout.getVisibility() == View.GONE) {
                        pm_layout.setVisibility(View.VISIBLE);
                        pp_layout.setVisibility(View.GONE);
                    }
                }
            }
        });


    }
}
