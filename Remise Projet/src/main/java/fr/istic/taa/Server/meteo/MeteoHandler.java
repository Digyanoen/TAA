package fr.istic.taa.Server.meteo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.istic.taa.Server.model.User;
import fr.istic.taa.Server.model.WeatherCondition;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeteoHandler {
    private String METEOMAIL = "noreplytaaproject@gmail.com";
    private String PASSWORD = "TAAspring";
    private List<InfoMeteo> list;

    public MeteoHandler() {
        this.list = new ArrayList<InfoMeteo>();
    }

    private InfoMeteo meteo;

    private InfoMeteo getInfoByTimestamp(long ts) throws InterruptedException {
        for (InfoMeteo im: list){
            if (im.getDt() == ts){
                return im;
            }
        }
        throw new InterruptedException("Aucune info ne correspond à cette date.");
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class InfoMeteo {
        private long dt;
        private Donnees main;
        private List<Meteo> weather;
        private Nuage clouds;
        private Vent wind;

        public long getDt() {
            return dt;
        }

        public void setDt(int dt) {
            this.dt = dt;
        }

        public Donnees getMain() {
            return main;
        }

        public void setMain(Donnees main) {
            this.main = main;
        }

        public List<Meteo> getWeather() {
            return weather;
        }

        public void setWeather(List<Meteo> weather) {
            this.weather = weather;
        }

        public Nuage getClouds() {
            return clouds;
        }

        public void setClouds(Nuage clouds) {
            this.clouds = clouds;
        }

        public Vent getWind() {
            return wind;
        }

        public void setWind(Vent wind) {
            this.wind = wind;
        }

        public class Vent {
            private double speed;
            private double deg;

            public double getSpeed() {
                return speed;
            }

            public void setSpeed(double speed) {
                this.speed = speed;
            }

            public double getDeg() {
                return deg;
            }

            public void setDeg(double deg) {
                this.deg = deg;
            }
        }

        public class Nuage {
            private int all;

            public int getAll() {
                return all;
            }

            public void setAll(int all) {
                this.all = all;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Meteo {
            private int id;
            private String main;
            private String description;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMain() {
                return main;
            }

            public void setMain(String main) {
                this.main = main;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Donnees {
            public double temp;
            public double temp_min;
            public double temp_max;
            public double pressure;
            public double sea_level;
            public double grnd_level;
            public double humidity;
        }
    }

    public boolean isOk(WeatherCondition weatherCondition) throws InterruptedException {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.setTime(date);
        cal.add(Calendar.DATE, 4);
            if(meteo == null) meteo = getInfoByTimestamp(cal.getTimeInMillis());

        switch (weatherCondition.getCondition()) {
            case WIND:
                return meteo.getWind().speed < weatherCondition.getStrength();
            case CLOUD:
                return meteo.getClouds().all < weatherCondition.getStrength();
            default:
                return false;

        }

    }

    public void sendForecast(List<User> users, String msg){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.setProperty("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props);

        MimeMessage message = new MimeMessage(session);
        try {
            message.setText(msg);
            message.setSubject("Forecast for the weekend");
            for(User u : users)message.addRecipients(Message.RecipientType.CC, u.getEmail());

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        Transport transport = null;
        try {
            transport= session.getTransport("smtp");
            transport.connect(METEOMAIL, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients()
            );
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally {
            try {
                if(transport != null){
                    transport.close();
                }
            }catch (MessagingException e){
                e.printStackTrace();

            }
        }
    }
}
