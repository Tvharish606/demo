import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;

import Application_Hooks.Hooks_Way_2_Automation;

public class Base_Class extends Hooks_Way_2_Automation
{
	
	@Test(dataProvider = "Data_Filling")
	public void data_filling(String data)
	{
		String userss[]=data.split(",");
		
		driver.navigate().to("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
		driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys(userss[0]);
		driver.findElement(By.xpath("(//input[@name='name'])[2]")).sendKeys(userss[1]);
		driver.findElement(By.xpath("//input[@value='submit']")).click();
	}
	@DataProvider(name = "Data_Filling")
	public String[] readfile()
	{
		JSONParser jsonparse=new JSONParser();
		FileReader reader=new FileReader(".\\Json_File\\form_file_data.json");
		Object obj = jsonparse.parse(reader);
		JSONObject userdetails =(JSONObject) obj;
		JSONArray user_array=(JSONArray)userdetails.get("form_filling_data");
		String arr[]=new String()[user_array.size()];
		for(int i=0;i<user_array.size();i++)
		{
			JSONObject users=(JSONObject)user_array.get(i);
		String First_name_user=(String)users.get("First_name");
		String Lasst_name_user=(String)users.get("Last_Name");
		arr[i]=First_name_user+" , "+Lasst_name_user;		
		}
		return arr;
	}
	
}
