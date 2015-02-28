package services
{	
	import config.Service;
	
	import mx.rpc.remoting.RemoteObject;
	
	public dynamic class ConnectionService extends RemoteObjectBase
	{
		public function ConnectionService()
		{
			super("ConnectionService");
		}
	}
}