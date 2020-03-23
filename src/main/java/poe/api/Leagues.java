package poe.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Leagues {

	@JsonProperty("max")
	private double max;

	@JsonProperty("display")
	private String display;

	@JsonProperty("start")
	private String start;

	@JsonProperty("active")
	private boolean active;

	@JsonProperty("accepted")
	private int accepted;

	@JsonProperty("mode")
	private double mode;

	@JsonProperty("exalted")
	private double exalted;

	@JsonProperty("total")
	private int total;

	@JsonProperty("current")
	private int current;

	@JsonProperty("min")
	private double min;

	@JsonProperty("median")
	private double median;

	@JsonProperty("mean")
	private double mean;

	@JsonProperty("daily")
	private int daily;

	@JsonProperty("name")
	private String name;

	@JsonProperty("end")
	private Object end;

	@JsonProperty("id")
	private int id;

	public void setMax(double max){
		this.max = max;
	}

	public double getMax(){
		return max;
	}

	public void setDisplay(String display){
		this.display = display;
	}

	public String getDisplay(){
		return display;
	}

	public void setStart(String start){
		this.start = start;
	}

	public String getStart(){
		return start;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}

	public void setAccepted(int accepted){
		this.accepted = accepted;
	}

	public int getAccepted(){
		return accepted;
	}

	public void setMode(double mode){
		this.mode = mode;
	}

	public double getMode(){
		return mode;
	}

	public void setExalted(double exalted){
		this.exalted = exalted;
	}

	public double getExalted(){
		return exalted;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setCurrent(int current){
		this.current = current;
	}

	public int getCurrent(){
		return current;
	}

	public void setMin(double min){
		this.min = min;
	}

	public double getMin(){
		return min;
	}

	public void setMedian(double median){
		this.median = median;
	}

	public double getMedian(){
		return median;
	}

	public void setMean(double mean){
		this.mean = mean;
	}

	public double getMean(){
		return mean;
	}

	public void setDaily(int daily){
		this.daily = daily;
	}

	public int getDaily(){
		return daily;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEnd(Object end){
		this.end = end;
	}

	public Object getEnd(){
		return end;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"LeaguesItem{" + 
			"max = '" + max + '\'' + 
			",display = '" + display + '\'' + 
			",start = '" + start + '\'' + 
			",active = '" + active + '\'' + 
			",accepted = '" + accepted + '\'' + 
			",mode = '" + mode + '\'' + 
			",exalted = '" + exalted + '\'' + 
			",total = '" + total + '\'' + 
			",current = '" + current + '\'' + 
			",min = '" + min + '\'' + 
			",median = '" + median + '\'' + 
			",mean = '" + mean + '\'' + 
			",daily = '" + daily + '\'' + 
			",name = '" + name + '\'' + 
			",end = '" + end + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}