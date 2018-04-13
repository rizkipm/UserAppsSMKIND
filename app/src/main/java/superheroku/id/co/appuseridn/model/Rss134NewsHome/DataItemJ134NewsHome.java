package superheroku.id.co.appuseridn.model.Rss134NewsHome;


import com.google.gson.annotations.SerializedName;


public class DataItemJ134NewsHome {

	@SerializedName("judul_news")
	private String judulNews;

	@SerializedName("id_news")
	private String idNews;

	@SerializedName("nama_kategori_news")
	private String namaKategoriNews;

	@SerializedName("id_kategori_news")
	private String idKategoriNews;

	@SerializedName("gbr_news")
	private String gbrNews;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("tgl_create_news")
	private String tglCreateNews;

	@SerializedName("isi news")
	private String isiNews;

	public void setJudulNews(String judulNews){
		this.judulNews = judulNews;
	}

	public String getJudulNews(){
		return judulNews;
	}

	public void setIdNews(String idNews){
		this.idNews = idNews;
	}

	public String getIdNews(){
		return idNews;
	}

	public void setNamaKategoriNews(String namaKategoriNews){
		this.namaKategoriNews = namaKategoriNews;
	}

	public String getNamaKategoriNews(){
		return namaKategoriNews;
	}

	public void setIdKategoriNews(String idKategoriNews){
		this.idKategoriNews = idKategoriNews;
	}

	public String getIdKategoriNews(){
		return idKategoriNews;
	}

	public void setGbrNews(String gbrNews){
		this.gbrNews = gbrNews;
	}

	public String getGbrNews(){
		return gbrNews;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setTglCreateNews(String tglCreateNews){
		this.tglCreateNews = tglCreateNews;
	}

	public String getTglCreateNews(){
		return tglCreateNews;
	}

	public void setIsiNews(String isiNews){
		this.isiNews = isiNews;
	}

	public String getIsiNews(){
		return isiNews;
	}

	@Override
 	public String toString(){
		return 
			"DataItemJ134NewsHome{" +
			"judul_news = '" + judulNews + '\'' + 
			",id_news = '" + idNews + '\'' + 
			",nama_kategori_news = '" + namaKategoriNews + '\'' + 
			",id_kategori_news = '" + idKategoriNews + '\'' + 
			",gbr_news = '" + gbrNews + '\'' + 
			",id_user = '" + idUser + '\'' + 
			",tgl_create_news = '" + tglCreateNews + '\'' + 
			",isi news = '" + isiNews + '\'' + 
			"}";
		}
}