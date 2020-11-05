package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author 775653
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries
    ({
      @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
      @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email =: email"),
      @NamedQuery(name = "User.findByActive", query = "SELECT u FROM User u WHERE u.active =: active"),
      @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName =: firstName"),
      @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName =: lastName"),
      @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password =: password")            
    })

public class User implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    
    @JoinColumn(name = "role", referencedColumnName = "role_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Role role;
    
    public User()
    {
        
    }
    
    public User(String email)
    {
        this.email = email;
    }
    
    public User(String email, boolean active, String firstName, String lastName, String password)
    {
        this.email = email;
        this.active = active;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public boolean isActive() 
    {
        return active;
    }

    public void setActive(boolean active) 
    {
        this.active = active;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public Role getRole() 
    {
        return role;
    }

    public void setRole(Role role) 
    {
        this.role = role;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;        
    }
    
    @Override
    public boolean equals(Object object)
    {
        if(!(object instanceof Role))
        {
            return false;
        }
        User other = (User) object;
        
        if((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email)))
        {
            return false;
        }
        return true;
    }
    
    @Override 
    public String toString()
    {
        return "models.User[ email=" + email + " ]";
    }
}
