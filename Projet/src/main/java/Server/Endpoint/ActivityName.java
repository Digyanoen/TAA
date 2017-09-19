package Server.Endpoint;


import Server.jpa.CustomSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = CustomSerializer.class)
public class ActivityName {
    private String name;


    public ActivityName(){

    }
    public ActivityName(String name){
        this.name  = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
