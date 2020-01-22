package dvdRental;
// Generated 22-ene-2020 12:15:15 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
public class Category  implements java.io.Serializable {


     private Byte categoryId;
     private String name;
     private Date lastUpdate;
     private Set filmCategories = new HashSet(0);

    public Category() {
    }

	
    public Category(String name, Date lastUpdate) {
        this.name = name;
        this.lastUpdate = lastUpdate;
    }
    public Category(String name, Date lastUpdate, Set filmCategories) {
       this.name = name;
       this.lastUpdate = lastUpdate;
       this.filmCategories = filmCategories;
    }
   
    public Byte getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(Byte categoryId) {
        this.categoryId = categoryId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public Set getFilmCategories() {
        return this.filmCategories;
    }
    
    public void setFilmCategories(Set filmCategories) {
        this.filmCategories = filmCategories;
    }




}


