package superheroku.id.co.appuseridn.model.Rss134NewsHome;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class RssJ134NewsHome{

	@SerializedName("result")
	private String result;

	@SerializedName("msg")
	private String msg;

	@SerializedName("data")
	private List<DataItemJ134NewsHome> data;

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

	public void setData(List<DataItemJ134NewsHome> data){
		this.data = data;
	}

	public List<DataItemJ134NewsHome> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"RssJ134NewsHome{" + 
			"result = '" + result + '\'' + 
			",msg = '" + msg + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}