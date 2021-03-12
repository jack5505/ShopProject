package uz.shop.entities;

import uz.shop.entities.enums.Sex;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/*
 *
 *  @author Sabirov Jakhongir
 *
 */
@Entity
@Table(name = "shop_person")
public class PersonEntity  implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String fullname;

    @Column
    private Date dateOfBirth;

    @Column
    private Sex gender;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person",orphanRemoval = true)
    private List<LoginEntity>  logins =new ArrayList<LoginEntity>();

    public Long getId() {
        return id;
    }



    public List<LoginEntity> getLogins() {
        return logins;
    }

    public void setLogins(List<LoginEntity> logins) {
        this.logins = logins;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }
}
