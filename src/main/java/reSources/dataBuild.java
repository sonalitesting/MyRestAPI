package reSources;

import java.util.ArrayList;
import java.util.List;

import pojo.addPlacePayload;
import pojo.addPlaceResponsePayload;
import pojo.locationPayload;

public  class dataBuild {
	public addPlacePayload addressSet(String name, String language, String address) {
		//addPlacePayload ap;
		addPlaceResponsePayload addPlaceResponse;
		 addPlacePayload ap=new addPlacePayload();
		//set address
		locationPayload lp=new locationPayload();
		lp.setLat("-38.383494");
		lp.setLng("33.427363");
		
		List<String> list=new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		
		
		 ap=new addPlacePayload();
		ap.setLocation(lp);
		ap.setAccuracy("50");
		ap.setAddress(address);
		ap.setLanguage(language);
		ap.setName(name);
		ap.setPhone_number("(+91)983 893 3938");
		ap.setWebsite("https://google.com");
		ap.setTypes(list);
        return ap;

}
    
	}
