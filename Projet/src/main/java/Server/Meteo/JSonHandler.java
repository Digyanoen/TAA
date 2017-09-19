package Server.Meteo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class JSonHandler {
    public static void main(String args[]){
        try {
            InputStream test = new URL("http://samples.openweathermap.org/data/2.5/forecast?lat=35&lon=139&appid=b1b15e88fa797225412429c1c50c122a1").openStream();
            BufferedReader res = new BufferedReader(new InputStreamReader(test, Charset.forName("UTF-8")));
            System.out.println(res.readLine());
            ObjectMapper mapper = new ObjectMapper();
            MeteoHandler met = mapper.readValue(new URL("http://samples.openweathermap.org/data/2.5/forecast?lat=35&lon=139&appid=b1b15e88fa797225412429c1c50c122a1"), MeteoHandler.class);
            System.out.println(met);
        } catch (MalformedURLException e) {
            System.out.println("échec");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
