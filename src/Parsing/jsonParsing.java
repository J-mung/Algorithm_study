package Parsing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class jsonParsing {
    public static void main(String[] args) {
        System.out.println("hello");
//        doParsingTest();
//        doParsingDepth1();
        doParsingDepth2();
    }

    public static void doParsingTest() {
        String rootPath = "resources";
        try {
            Reader reader = new FileReader(rootPath + "/jsonFiles/MOCK_DATA.json");

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);

            JSONArray jsonArray = (JSONArray) obj;
            System.out.println(jsonArray.get(1));

            ArrayList<jsonData> newDatas = new ArrayList<>();

            if (jsonArray.isEmpty()) {
                System.out.println("json file is empty");
                return;
            }

            for (Object data : jsonArray) {
                JSONObject curObj = (JSONObject) data;
                Object[] keys = curObj.keySet().toArray();
                jsonData newData = new jsonData();
                for (int i = 0; i < keys.length; i++) {
                    String key = (String) keys[i];

                    switch (key) {
                        case "id" :
                            newData.setId(Integer.parseInt(curObj.get(key).toString()));
                            break;
                        case "first_name" :
                            newData.setFirst_name((String) curObj.get(key));
                            break;
                        case "last_name" :
                            newData.setLast_name((String) curObj.get(key));
                            break;
                        case "email" :
                            newData.setEmail((String) curObj.get(key));
                            break;
                        case "gender" :
                            newData.setGender((String) curObj.get(key));
                            break;
                        default :
                            newData.setId(-1);
                    }
                }
                System.out.println(newData);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void doParsingDepth1() {
        try {
            String rootPath = "resources";
            Reader reader = new FileReader(rootPath + "/jsonFiles/Depth_1.json");
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);

            System.out.println(obj);

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject.get("depth_1"));

            JSONArray jsonArray = (JSONArray) jsonObject.get("depth_1");
            System.out.println(jsonArray.get(0));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void doParsingDepth2() {
        try {
            String rootPath = "resources";
            Reader reader = new FileReader(rootPath + "/jsonFiles/Depth_2.json");
            JSONParser parser = new JSONParser();
            JSONObject depth1 = (JSONObject) parser.parse(reader);
            System.out.println(depth1);

            JSONObject depth2 = (JSONObject) depth1.get("depth_1");
            System.out.println(depth2);

            JSONArray jsonArray = (JSONArray) depth2.get("depth_2");
            System.out.println(jsonArray.get(2));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
