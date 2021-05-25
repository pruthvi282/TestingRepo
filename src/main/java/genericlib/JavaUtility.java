package genericlib;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public  String date(){
			Date da=new Date();
			return da.toString();
	}
	
	
	public String random(int value,String name){
		Random randam=new Random();
		int number=randam.nextInt(value);
		String randamName=name + number;
		return randamName;
	}
}
