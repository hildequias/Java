package services;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import valueObjects.ResourceVO;

@Service("ResourceService")
@RemotingDestination(channels={"my-amf"})
public class ResourceService extends AbstractService<ResourceVO>{
	
	
}
