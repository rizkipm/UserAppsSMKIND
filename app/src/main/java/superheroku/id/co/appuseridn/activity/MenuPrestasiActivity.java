package superheroku.id.co.appuseridn.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import superheroku.id.co.appuseridn.R;
import superheroku.id.co.appuseridn.adapter.AdapterPrestasi;
import superheroku.id.co.appuseridn.model.RssJ164GetAllPrestasi.DataItemJ164GetAllPrestasi;
import superheroku.id.co.appuseridn.model.RssJ164GetAllPrestasi.RssJ164GetAllPrestasi;
import superheroku.id.co.appuseridn.network.MyRetrofitClient;
import superheroku.id.co.appuseridn.network.RestApi;

public class MenuPrestasiActivity extends AppCompatActivity {
    public static List<DataItemJ164GetAllPrestasi> dataItemJ23RiwayatLelangs;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_menu);
        ButterKnife.bind(this);
        dataItemJ23RiwayatLelangs = new ArrayList<>();



        getListData();

    }

    private void getListData() {
        try {
            RestApi api = MyRetrofitClient.getInstanceRetrofit2();


            Call<RssJ164GetAllPrestasi> call = api.getPrestasi();
            call.enqueue(new Callback<RssJ164GetAllPrestasi>() {
                @Override
                public void onResponse(Call<RssJ164GetAllPrestasi> call, Response<RssJ164GetAllPrestasi> response) {
//                    Log.d("onResponse", response.body().toString());

                    String r = response.body().getResult();
//                String nData = response.body().getDataProfilUSer().getLevel();
                    Log.d("adaawisata", response.body().toString());

                    if (r.equalsIgnoreCase("true")) {


                        dataItemJ23RiwayatLelangs = response.body().getData();
//                    layoutManager = new LinearLayoutManager(getApplicationContext());
                        AdapterPrestasi recyclerViewAdapter =
                                new AdapterPrestasi(dataItemJ23RiwayatLelangs, MenuPrestasiActivity.this);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MenuPrestasiActivity.this));

//                    recyclerView.setLayoutManager(layoutManager);
////                        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

                        recyclerView.setAdapter(recyclerViewAdapter);

                    }else {

                    }



                }

                @Override
                public void onFailure(Call<RssJ164GetAllPrestasi> call, Throwable t) {

                }
            });

//
        } catch (Exception e) {
        }
    }

}
