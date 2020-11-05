package dataaccess;

import javax.persistence.*;

/**
 *
 * @author 820203
 */
public class DBUtil 
{
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsersPU");
    
    public static EntityManagerFactory egtEmFactory()
    {
        return emf;
    }
}
