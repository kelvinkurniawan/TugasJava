package models;

/**
 * @author fajar
 */

public class Country {
    private String id, country_name;
    private int region_id;

    public Country() {
    }

    public Country(String id, String country_name, int region_id) {
        this.id = id;
        this.country_name = country_name;
        this.region_id = region_id;
    }

    /**
     *
     * Setter & Getter Variable
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", country_name='" + country_name + '\'' +
                ", region_id=" + region_id +
                '}';
    }
}
