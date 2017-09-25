package fr.istic.taa.Server.meteo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeteoHandler {
    public List<InfoMeteo> list;

    public MeteoHandler() {
        this.list = new ArrayList<InfoMeteo>();
    }

    public InfoMeteo getInfoByTimestamp(int ts) throws InterruptedException {
        for (InfoMeteo im: list){
            if (im.getDt() == ts){
                return im;
            }
        }
        throw new InterruptedException("Aucune info ne correspond à cette date.");
    }
}
