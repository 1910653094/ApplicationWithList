package tu.dublin.applicationwithlist.classes;

public class City {
    private String city;
    private String country;
    private long city_pop;
    private long metro_pop;


    public City() {
    }

    public City(String city, String country, long city_pop, long metro_pop) {
        this.city = city;
        this.country = country;
        this.city_pop = city_pop;
        this.metro_pop = metro_pop;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getCity_pop() {
        return city_pop;
    }

    public void setCity_pop(long city_pop) {
        this.city_pop = city_pop;
    }

    public long getMetro_pop() {
        return metro_pop;
    }

    public void setMetro_pop(long metro_pop) {
        this.metro_pop = metro_pop;
    }
}
