package pavel.midtraining.dao;

import pavel.midtraining.dataprovider.ResultSetProvider;
import pavel.midtraining.exception.PersistenceException;
import pavel.midtraining.model.Resource;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class ResourceDao {

    /**
     * Loads resource, converts any unexpected {@link SQLException} to dao layer specific {@link PersistenceException}
     * @param resourceId
     * @return resource
     */
    public Resource loadResource(int resourceId){
        Resource resource = null;
        try {
            ResultSetProvider provider = new ResultSetProvider();
            ResultSet rs = provider.getResult(resourceId);
            resource = new Resource(rs.getString("name"),rs.getInt("capacity"));
        } catch (SQLException e) {
            throw new PersistenceException("Failed to load resource with",e,resourceId);
        }
        return resource;
    }
}
