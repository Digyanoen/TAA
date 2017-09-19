package Server.Meteo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeteoHandler {
    public List<InfoMeteo> list;

    @Override
    public String toString() {
        String res = "";
        for(InfoMeteo i : list){
            res += " " +i;
        }
        return res;
    }
}
