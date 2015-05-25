package pavel.midtraining.service;

import pavel.midtraining.dao.ResourceDao;
import pavel.midtraining.model.Resource;

/**
 *
 */
public class ResourceService {

    private ResourceDao dao;

    public ResourceService() {
        this.dao = new ResourceDao();
    }

    public Resource getResource(int resourceId){
        Resource resource = dao.loadResource(resourceId);
        //Some buisness logic goes here
        return resource;
    }
}
