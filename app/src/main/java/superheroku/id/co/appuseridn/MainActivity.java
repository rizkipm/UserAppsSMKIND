package superheroku.id.co.appuseridn;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import superheroku.id.co.appuseridn.activity.LoginActivity;
import superheroku.id.co.appuseridn.adapter.AdapterNewsHome;
import superheroku.id.co.appuseridn.helper.Constant;
import superheroku.id.co.appuseridn.helper.HeroHelper;
import superheroku.id.co.appuseridn.helper.MyConstant;
import superheroku.id.co.appuseridn.helper.No_Internet;
import superheroku.id.co.appuseridn.helper.SessionManager;
import superheroku.id.co.appuseridn.helper.VolunterHelper;
import superheroku.id.co.appuseridn.model.Rss134NewsHome.DataItemJ134NewsHome;
import superheroku.id.co.appuseridn.model.Rss134NewsHome.RssJ134NewsHome;
import superheroku.id.co.appuseridn.network.MyRetrofitClient;
import superheroku.id.co.appuseridn.network.RestApi;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int PERMISSION_WRITE_EXTERNAL_STORAGE = 100;
    public static List<DataItemJ134NewsHome> dataList;


    @BindView(R.id.flipper)
    ViewFlipper flipper;
    @BindView(R.id.txtRunning)
    TextView txtRunning;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.frameDisplay)
    FrameLayout frameDisplay;
    @BindView(R.id.btnLogin)
    FloatingActionButton btnLogin;

    private boolean mIsAppFirstLaunched = true;
    AQuery aq;
    String teksRunning;
    private String imgMenu, idSlider, nmMenu, desMenu, hargaMenu, Nmresto, idMenu, statusOps;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        aq = new AQuery(context);

        flipper.setInAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_left_in));
        flipper.setOutAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_left_out));
        flipper.setFlipInterval(2000);
        flipper.startFlipping();
        txtRunning.setSelected(true);

        if (!VolunterHelper.isOnline(getApplicationContext())) {
            startActivity(new Intent(getApplicationContext(), No_Internet.class));
            finish();
        } else {

            getListData();
            getDataMenu();
            getRunningText();

        }
    }

    private void getRunningText() {
        // clear data sebelumnya

        //ambil data dari server
        String url = HeroHelper.BASE_URL + "getPengumuman";
        Map<String, String> parampa = new HashMap<>();
        try {
            //mencari url dan parameter yang dikirimkan
            VolunterHelper.pre("Url : " + url + ", params " + parampa.toString());
            //koneksi ke server meggunakan aquery
            aq.ajax(url, parampa, String.class,
                    new AjaxCallback<String>() {
                        @Override
                        public void callback(String url, String hasil, AjaxStatus status) {
                            //cek apakah hasilnya null atau tidak
                            if (hasil != null) {
                                VolunterHelper.pre("Respon : " + hasil);
                                //merubah string menjadi json
                                try {
                                    JSONObject json = new JSONObject(hasil);
                                    String result = json.getString("result");
                                    String pesan = json.getString("msg");
                                    // NurHelper.pesan(getActivity(), pesan);
                                    if (result.equalsIgnoreCase("true")) {
                                        JSONArray jsonArray = json.getJSONArray("data");
                                        for (int a = 0; a < jsonArray.length(); a++) {
                                            HashMap<String, String> dataMap = new HashMap<>();
                                            JSONObject object = jsonArray.getJSONObject(a);
                                            teksRunning = object.getString("info");
//                                            teksRunning = object.getString("isi_pengumuman");

                                            txtRunning.setText(" " + teksRunning);


                                        }
                                    } else {
                                        VolunterHelper.pesan(getApplicationContext(), pesan);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    VolunterHelper.pesan(getApplicationContext(), "Error parsing data");
                                }
                            }
                        }
                    });

        } catch (Exception e) {
            VolunterHelper.pesan(getApplicationContext(), "Error get data");
            e.printStackTrace();
        }


    }

    private void getDataMenu() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_WRITE_EXTERNAL_STORAGE);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        } else {


            //ambil data dari server
            String url = VolunterHelper.BASE_URL + "getAllSliderDepan";
            Map<String, String> parampa = new HashMap<>();
            try {
                //mencari url dan parameter yang dikirimkan
                VolunterHelper.pre("Url : " + url + ", params " + parampa.toString());
                //koneksi ke server meggunakan aquery
                aq.ajax(url, parampa, String.class,
                        new AjaxCallback<String>() {
                            @Override
                            public void callback(String url, String hasil, AjaxStatus status) {
                                //cek apakah hasilnya null atau tidak
                                if (hasil != null) {
                                    VolunterHelper.pre("Respon : " + hasil);
                                    //merubah string menjadi json
                                    try {
                                        JSONObject json = new JSONObject(hasil);
                                        String result = json.getString("result");
                                        String pesan = json.getString("msg");
                                        // NurHelper.pesan(getActivity(), pesan);
                                        if (result.equalsIgnoreCase("true")) {
                                            JSONArray jsonArray = json.getJSONArray("data");
                                            for (int a = 0; a < jsonArray.length(); a++) {
                                                HashMap<String, String> dataMap = new HashMap<>();
                                                JSONObject object = jsonArray.getJSONObject(a);
                                                idMenu = object.getString("id_slider");
                                                nmMenu = object.getString("judul_slider");
//                                            hargaMenu = object.getString("harga_menu");
//                                                desMenu = object.getString("desc_slider");
                                                imgMenu = object.getString("gbr_slider");
//                                            Nmresto = object.getString("resto_nama");
//                                                Toast.makeText(getApplicationContext(), "ID : " + idMenu +"\nMenu : " +nmMenu + "\nGambar : "+imgMenu, Toast.LENGTH_SHORT).show();


                                                if ((a < Constant.VALUE_SLIDESHOW) && mIsAppFirstLaunched) {
                                                    createSlideshow(idMenu, imgMenu, nmMenu);
                                                }
                                            }
                                        } else {
//                                            KolakaHelper.pesan(getApplicationContext(), pesan);
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
//                                        KolakaHelper.pesan(getApplicationContext(), "Error parsing data");
                                    }
                                }
                            }
                        });

            } catch (Exception e) {
//                KolakaHelper.pesan(getApplicationContext(), "Error get data");
                e.printStackTrace();
            }
        }
    }

    private void getListData() {
        try {
            RestApi api = MyRetrofitClient.getInstanceRetrofit();
            SessionManager sesi = new SessionManager(getApplicationContext());
            String nUser = sesi.getIdUser();
            Log.i("RSMUser : ", nUser);

            Call<RssJ134NewsHome> call = api.getnewsHome();
            call.enqueue(new Callback<RssJ134NewsHome>() {
                @Override
                public void onResponse(Call<RssJ134NewsHome> call, Response<RssJ134NewsHome> response) {
//                    Log.d("onResponse", response.body().toString());


                    String r = response.body().getResult();
//                String nData = response.body().getDataProfilUSer().getLevel();
                    Log.d("adaSlidera", response.body().toString());

                    if (r.equalsIgnoreCase("true")) {


                        dataList = response.body().getData();

                        AdapterNewsHome recyclerViewAdapter =
                                new AdapterNewsHome(dataList, MainActivity.this);

                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));

                        recyclerView.setAdapter(recyclerViewAdapter);


                    } else {

                    }
                }


                @Override
                public void onFailure(Call<RssJ134NewsHome> call, Throwable t) {

                }
            });

//
        } catch (Exception e) {
        }
    }

    private void createSlideshow(String idMenu, String imgMenu, String nmMenu) {
        View view = getLayoutInflater().inflate(R.layout.layout_slideshow, null);

        ImageView menuImg = (ImageView) view.findViewById(R.id.imgMenu);
        TextView namaMenu = (TextView) view.findViewById(R.id.tvNamaMenu);
        TextView judulResto = (TextView) view.findViewById(R.id.tvNamaResto);
        TextView deskripsiMenu = (TextView) view.findViewById(R.id.tvDesMenu);

        // menuImg.setId(Integer.parseInt(idMenu));
//        menuImg.setOnClickListener(this);

        namaMenu.setText(nmMenu);


        Glide.with(context)
                .load(MyConstant.IMAGE_URL + imgMenu)
                .placeholder(R.drawable.no_image)
                .override(150, 125)
                .error(R.drawable.no_image)
                .into(menuImg);

        // Add layout to flipper
        flipper.addView(view);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick(R.id.btnLogin)
    public void onViewClicked() {

        Intent a1 = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(a1);

    }
}
