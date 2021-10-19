package com.supernettechnologie.impromobile.ui.gallery;

import com.supernettechnologie.impromobile.data.model.Vente;
import com.supernettechnologie.impromobile.webapi.ClientsApi;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private List<Vente> listVentes = new ArrayList<>();

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public List<Vente> getVentes(String token){
        ClientsApi.getInstance().getVentes(token).enqueue(new Callback<List<Vente>>() {
            @Override
            public void onResponse(Call<List<Vente>> call, Response<List<Vente>> response) {
                if (response.isSuccessful()) {
                    for (int i =0; i<response.body().size(); i++){
                        listVentes.add(response.body().get(i));
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Vente>> call, Throwable t) {

            }
        });
        return listVentes;
    }
}