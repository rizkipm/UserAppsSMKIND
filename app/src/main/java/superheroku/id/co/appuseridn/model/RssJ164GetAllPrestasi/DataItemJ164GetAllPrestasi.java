package superheroku.id.co.appuseridn.model.RssJ164GetAllPrestasi;


import com.google.gson.annotations.SerializedName;


public class DataItemJ164GetAllPrestasi {

	@SerializedName("id_kategori_lomba")
	private String idKategoriLomba;

	@SerializedName("deks_prestasi")
	private String deksPrestasi;

	@SerializedName("id_prestasi")
	private String idPrestasi;

	@SerializedName("nama_prestasi")
	private String namaPrestasi;

	@SerializedName("nama_kategori_lomba")
	private String namaKategoriLomba;

	@SerializedName("foto_juara")
	private String fotoJuara;

	@SerializedName("tgl_create_prestasi")
	private String tglCreatePrestasi;

	public void setIdKategoriLomba(String idKategoriLomba){
		this.idKategoriLomba = idKategoriLomba;
	}

	public String getIdKategoriLomba(){
		return idKategoriLomba;
	}

	public void setDeksPrestasi(String deksPrestasi){
		this.deksPrestasi = deksPrestasi;
	}

	public String getDeksPrestasi(){
		return deksPrestasi;
	}

	public void setIdPrestasi(String idPrestasi){
		this.idPrestasi = idPrestasi;
	}

	public String getIdPrestasi(){
		return idPrestasi;
	}

	public void setNamaPrestasi(String namaPrestasi){
		this.namaPrestasi = namaPrestasi;
	}

	public String getNamaPrestasi(){
		return namaPrestasi;
	}

	public void setNamaKategoriLomba(String namaKategoriLomba){
		this.namaKategoriLomba = namaKategoriLomba;
	}

	public String getNamaKategoriLomba(){
		return namaKategoriLomba;
	}

	public void setFotoJuara(String fotoJuara){
		this.fotoJuara = fotoJuara;
	}

	public String getFotoJuara(){
		return fotoJuara;
	}

	public void setTglCreatePrestasi(String tglCreatePrestasi){
		this.tglCreatePrestasi = tglCreatePrestasi;
	}

	public String getTglCreatePrestasi(){
		return tglCreatePrestasi;
	}

	@Override
 	public String toString(){
		return 
			"DataItemJ164GetAllPrestasi{" +
			"id_kategori_lomba = '" + idKategoriLomba + '\'' + 
			",deks_prestasi = '" + deksPrestasi + '\'' + 
			",id_prestasi = '" + idPrestasi + '\'' + 
			",nama_prestasi = '" + namaPrestasi + '\'' + 
			",nama_kategori_lomba = '" + namaKategoriLomba + '\'' + 
			",foto_juara = '" + fotoJuara + '\'' + 
			",tgl_create_prestasi = '" + tglCreatePrestasi + '\'' + 
			"}";
		}
}