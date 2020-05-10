package poe.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemData {

	@JsonProperty("leagues")
	private List<Leagues> leagues;

	@JsonProperty("influences")
	private List<Object> influences;

	@JsonProperty("name")
	private String name;

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("id")
	private int id;

	@JsonProperty("type")
	private String type;

	@JsonProperty("category")
	private String category;

	@JsonProperty("group")
	private String group;

	@JsonProperty("frame")
	private int frame;

	public void setLeagues(List<Leagues> leagues){
		this.leagues = leagues;
	}

	public List<Leagues> getLeagues(){
		return leagues;
	}

	public void setInfluences(List<Object> influences){
		this.influences = influences;
	}

	public List<Object> getInfluences(){
		return influences;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setGroup(String group){
		this.group = group;
	}

	public String getGroup(){
		return group;
	}

	public void setFrame(int frame){
		this.frame = frame;
	}

	public int getFrame(){
		return frame;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"leagues = '" + leagues + '\'' + 
			",influences = '" + influences + '\'' + 
			",name = '" + name + '\'' + 
			",icon = '" + icon + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			",category = '" + category + '\'' + 
			",group = '" + group + '\'' + 
			",frame = '" + frame + '\'' + 
			"}";
		}
}