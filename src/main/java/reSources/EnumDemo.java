package reSources;

public enum EnumDemo {
	AddplaceAPI("/maps/api/place/add/json"),
	GetplaceAPI("/maps/api/place/get/json");
	private String resource;
	
	EnumDemo(String resource){
		this.resource=resource;
	}
	public String getResource() {
	    return resource;	
	}

}
