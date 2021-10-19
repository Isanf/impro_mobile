package com.supernettechnologie.impromobile.ui.gallery;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.supernettechnologie.impromobile.R;
import com.supernettechnologie.impromobile.data.model.Vente;
import com.supernettechnologie.impromobile.ui.vente.NewVenteActivity;
import com.supernettechnologie.impromobile.webapi.ClientsApi;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private TableLayout tableLayout;
    private FloatingActionButton add_v;
    List<Vente> list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        tableLayout = root.findViewById(R.id.tvente);
        add_v = root.findViewById(R.id.add_vente);
        list = new ArrayList<>();

        TableRow tr_head = new TableRow(getContext());
        tr_head.setBackgroundColor(Color.LTGRAY);
        tr_head.setPadding(10, 10, 10, 10);
        tr_head.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView tv1 = new TextView(getContext());
        tv1.setText("N°");
        tv1.setTextColor(Color.BLACK);
        tv1.setGravity(Gravity.CENTER);
        tv1.setWidth(80);
        tr_head.addView(tv1);
        TextView tv2 = new TextView(getContext());
        tv2.setText("Date");
        tv2.setTextColor(Color.BLACK);
        tv2.setGravity(Gravity.CENTER);
        tv2.setWidth(350);
        tr_head.addView(tv2);
        TextView tv3 = new TextView(getContext());
        tv3.setText("Quantité");
        tv3.setTextColor(Color.BLACK);
        tv3.setGravity(Gravity.CENTER);
        tv3.setWidth(180);
        tr_head.addView(tv3);
        TextView tv4 = new TextView(getContext());
        tv4.setText("Client");
        tv4.setTextColor(Color.BLACK);
        tv4.setGravity(Gravity.CENTER);
        tv4.setWidth(200);
        tr_head.addView(tv4);
        tableLayout.addView(tr_head);


        add_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NewVenteActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        list.clear();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext());
        String token_id = "Bearer "+pref.getString("token", "No Token");

        ClientsApi.getInstance().getVentes(token_id).enqueue(new Callback<List<Vente>>() {
            @Override
            public void onResponse(Call<List<Vente>> call, Response<List<Vente>> response) {
                if (response.isSuccessful()) {
                    list.addAll(response.body());
                    for (int i =0; i<list.size(); i++){
                        TableRow tbrow = new TableRow(getContext());

                        TextView numb = new TextView(getContext());
                        numb.setText(list.get(i).getNumeroVente());
                        numb.setTextColor(Color.BLACK);
                        numb.setGravity(Gravity.CENTER);
                        numb.setWidth(80);
                        tbrow.addView(numb);

                        TextView date = new TextView(getContext());
                        date.setText(list.get(i).getDateVente().toString());
                        date.setTextColor(Color.BLACK);
                        date.setGravity(Gravity.CENTER);
                        date.setWidth(450);
                        tbrow.addView(date);

                        TextView quant = new TextView(getContext());
                        quant.setText(String.valueOf(list.get(i).getQuantiteVendue()));
                        quant.setTextColor(Color.BLACK);
                        quant.setGravity(Gravity.CENTER);
                        quant.setWidth(180);
                        tbrow.addView(quant);

                        if (list.get(i).getPersonneMoraleId() == null) {
                            TextView client = new TextView(getContext());
                            client.setText(String.valueOf(list.get(i).getPersonnePhysiqueId()));
                            client.setTextColor(Color.BLACK);
                            client.setGravity(Gravity.CENTER);
                            client.setWidth(200);
                            tbrow.addView(client);
                        }else {
                            TextView client = new TextView(getContext());
                            client.setText(String.valueOf(list.get(i).getPersonneMoraleId()));
                            client.setTextColor(Color.BLACK);
                            client.setGravity(Gravity.CENTER);
                            client.setWidth(200);
                            tbrow.addView(client);
                        }

                        tableLayout.addView(tbrow);
                    }
                    Toast.makeText(getContext(), list.get(0).getDateVente().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Vente>> call, Throwable t) {

            }
        });
    }
}
