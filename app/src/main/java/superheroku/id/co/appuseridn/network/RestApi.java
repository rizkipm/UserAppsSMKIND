package superheroku.id.co.appuseridn.network;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import superheroku.id.co.appuseridn.model.Rss134NewsHome.RssJ134NewsHome;
import superheroku.id.co.appuseridn.model.RssJ164GetAllPrestasi.RssJ164GetAllPrestasi;

/**
 * Created by Blackswan on 9/12/2017.
 */

public interface RestApi {



    @GET("getAllNews")
    Call<RssJ134NewsHome> getnewsHome();

    @GET("getPrestasi")
    Call<RssJ164GetAllPrestasi> getPrestasi();

//    @GET("wisata/json")
//    Call<RssJ113Wisata> getMenuWisata();
//
//    @GET("getAllTipeIndikator")
//    Call<RssJ54GetAllIndikator> getAllTipeIndikator();
//
//
//    @GET("getAllInfrastruktur")
//    Call<RssJ104AllInfrastruktur> getAllInfrastruktur();
//
//    @GET("getAllProfil")
//    Call<RssJ104Profil> getAllProfil();
//
//    @GET("getAllInfoPengumuman")
//    Call<RssJ134AllPengumuman> getAllInfoPengumuman();
//
//
//    @GET("getAllPimpinan")
//    Call<RssJ104AllPimpinan> getAllPimpinan();
//
//
//    @FormUrlEncoded
//    @POST("getIndikatorByTipe")
//    Call<RssJ544IndikatorByTipe> getIndikatorByTipe(
//            @Field("id_tipe_indikator") String id_tipe_indikator
//
//    );


//    @FormUrlEncoded
//    @POST("getKatProdukByID")
//    Call<RssJ182ProdukByKat> getKatProdukByID(
//            @Field("id_kategori_produk") String id_kategori_produk
//
//    );

//    @FormUrlEncoded
//    @POST("penawaranBarang")
//    Call<NewRssJ112Penawaran> penawaranBarang(
//            @Field("id_produk") String id_produk,
//            @Field("id_user") String id_user,
//
//            @Field("id_toko") String id_toko,
//            @Field("jml_pesanan") String jml_pesanan,
//            @Field("satuan_qty") String satuan_qty,
//            @Field("hrg_penawaran") String hrg_penawaran,
//            @Field("alamat_penawaran") String alamat_penawaran,
//            @Field("gmbr_penawaran") String gmbr_penawaran,
//            @Field("userfile") File userfile
//    );



}
