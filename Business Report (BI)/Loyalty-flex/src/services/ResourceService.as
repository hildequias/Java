package services
{	
	import config.Service;
	
	import mx.rpc.remoting.RemoteObject;
	
	public dynamic class ResourceService extends RemoteObjectBase
	{
		public function ResourceService()
		{
			super("ResourceService");
		}
	}
}