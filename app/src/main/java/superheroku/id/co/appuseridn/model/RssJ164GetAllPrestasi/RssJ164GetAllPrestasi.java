package superheroku.id.co.appuseridn.model.RssJ164GetAllPrestasi;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RssJ164GetAllPrestasi{

	@SerializedName("result")
	private String result;

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private List<DataItemJ164GetAllPrestasi> data;

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(List<DataItemJ164GetAllPrestasi> data){
		this.data = data;
	}

	public List<DataItemJ164GetAllPrestasi> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"RssJ164GetAllPrestasi{" + 
			"result = '" + result + '\'' + 
			",msg = '" + msg + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}