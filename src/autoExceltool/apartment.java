package autoExceltool;

public class apartment {
	private String name;
	private String floor[];
	private int unit[];
	private int story;
	private int outdoor;
	private int ff_length;
	private int un_length;
	
	public String[] getFloor() {
		return floor;
	}
	public void setFloor(String floor[]) {
		this.floor = floor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getUnit(){
		return unit;
	}
	public void setUnit(int unit[]){
		this.unit = unit;
	}
	public int getStory(){
		return story;
	}
	public void setStory(int story){
		this.story = story;
	}
	public int getOutdoor(){
		return outdoor;
	}
	public void setOutdoor(int outdoor){
		this.outdoor = outdoor;
	}
	public int getFf_length() {
		return ff_length;
	}
	public void setFf_length(int ff_length) {
		this.ff_length = ff_length;
	}
	public int getUn_length() {
		return un_length;
	}
	public void setUn_length(int un_length) {
		this.un_length = un_length;
	}
}
