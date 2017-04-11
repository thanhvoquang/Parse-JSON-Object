package libraryfordev.vqt.readjsonobject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String JSON_STRING="{\"employee\":{\"name\":\"Sachin\",\"salary\":56000}}";
    String strJson="{ \"Employee\" :[{\"id\":\"101\",\"name\":\"Sonoo Jaiswal\",\"salary\":\"50000\"},{\"id\":\"102\",\"name\":\"Vimal Jaiswal\",\"salary\":\"60000\"}] }";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readJSONObject();
        readJSONArray();
    }

    public void readJSONObject() {
        try{
            JSONObject jsonObject = new JSONObject(JSON_STRING);
            JSONObject emp=jsonObject.getJSONObject("employee");
            String empname=emp.getString("name");
            int empsalary=emp.getInt("salary");
        }catch (Exception e) {e.printStackTrace();}
    }

    public void readJSONArray() {
        try {
            JSONObject root = new JSONObject(strJson);
            JSONArray jsonArray = root.optJSONArray("Employee");
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.optString("id");
                String name = jsonObject.optString("name");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}