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

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class InfoMeteo {
        private int dt;
        private Donnees main;
        private List<Meteo> weather;
        private Nuage clouds;
        private Vent wind;

        public int getDt() {
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
}
