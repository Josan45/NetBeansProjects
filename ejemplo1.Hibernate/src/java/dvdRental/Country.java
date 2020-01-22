package dvdRental;
// Generated 22-ene-2020 13:18:24 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Country generated by hbm2java
 */
public class Country  implements java.io.Serializable {


     private Short countryId;
     private String country;
     private Date lastUpdate;
     private Set cities = new HashSet(0);

    public Country() {
    }

	
    public Country(String country, Date lastUpdate) {
        this.country = country;
        this.lastUpdate = lastUpdate;
    }
    public Country(String country, Date lastUpdate, Set cities) {
       this.country = country;
       this.lastUpdate = lastUpdate;
       this.cities = cities;
    }
   
    public Short getCountryId() {
        return this.countryId;
    }
    
    public void setCountryId(Short countryId) {
        this.countryId = countryId;
    }
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public Set getCities() {
        return this.cities;
    }
    
    public void setCities(Set cities) {
        this.cities = cities;
    }




}


