package superheroku.id.co.appuseridn.model.RssGet164Partners;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class RssJ164GetAllPartners{

	@SerializedName("result")
	private String result;

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private List<DataItem164Partners> data;

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

	public void setData(List<DataItem164Partners> data){
		this.data = data;
	}

	public List<DataItem164Partners> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"RssJ164GetAllPartners{" + 
			"result = '" + result + '\'' + 
			",msg = '" + msg + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}