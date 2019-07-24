package utilities;

import java.io.FileReader;
import java.util.Properties;

public class Generics {

    protected static FileReader reader;
    protected static Properties properties;


    public static String getConfigValue(String key){
        String val=null;
        try {
            reader = new FileReader("config.properties");
            properties = new Properties();
            properties.load(reader);
            val = properties.getProperty(key);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return val;
    }

    public static String[] stringToArr(String val,String splitChar){
        String[] valArr = val.split(splitChar);

        return valArr;
    }

    public static Long[] stringArrToLongArr(String[] val){
        Long[] arr = new Long[val.length];
        for(int i =0;i<val.length;i++){
            arr[i] = Long.parseLong(val[i]);

        }
        return arr;
    }

    public static Integer[] stringArrTointArr(String[] val){
        Integer[] arr = new Integer[val.length];
        for(int i =0;i<val.length;i++){
            arr[i] = Integer.parseInt(val[i]);

        }
        return arr;
    }

    public static String getReportConfigPath(){
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }
}
