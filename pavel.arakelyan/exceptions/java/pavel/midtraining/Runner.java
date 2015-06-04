package pavel.midtraining;

import pavel.midtraining.model.Resource;
import pavel.midtraining.service.ResourceService;

/**
 * Class represents the use case of exceptions
 */
public class Runner {

    public static void main(String[] args){
        ResourceService service = new ResourceService();
        //On < 1 number we will have our exception case
        Resource resource = service.getResource(10);
        System.out.print(resource);
    }
}
