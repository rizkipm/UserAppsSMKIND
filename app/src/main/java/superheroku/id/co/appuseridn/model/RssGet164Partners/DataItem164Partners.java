package superheroku.id.co.appuseridn.model.RssGet164Partners;


import com.google.gson.annotations.SerializedName;


public class DataItem164Partners {

	@SerializedName("tgl_create_partners")
	private String tglCreatePartners;

	@SerializedName("nama_partners")
	private String namaPartners;

	@SerializedName("icon_partners")
	private String iconPartners;

	@SerializedName("id_partners")
	private String idPartners;

	public void setTglCreatePartners(String tglCreatePartners){
		this.tglCreatePartners = tglCreatePartners;
	}

	public String getTglCreatePartners(){
		return tglCreatePartners;
	}

	public void setNamaPartners(String namaPartners){
		this.namaPartners = namaPartners;
	}

	public String getNamaPartners(){
		return namaPartners;
	}

	public void setIconPartners(String iconPartners){
		this.iconPartners = iconPartners;
	}

	public String getIconPartners(){
		return iconPartners;
	}

	public void setIdPartners(String idPartners){
		this.idPartners = idPartners;
	}

	public String getIdPartners(){
		return idPartners;
	}

	@Override
 	public String toString(){
		return 
			"DataItem164Partners{" +
			"tgl_create_partners = '" + tglCreatePartners + '\'' + 
			",nama_partners = '" + namaPartners + '\'' + 
			",icon_partners = '" + iconPartners + '\'' + 
			",id_partners = '" + idPartners + '\'' + 
			"}";
		}
}