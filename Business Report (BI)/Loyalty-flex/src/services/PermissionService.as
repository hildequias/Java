package services
{
	import config.Service;
	
	import mx.rpc.remoting.RemoteObject;
	
	public dynamic class PermissionService extends RemoteObjectBase
	{
		public function PermissionService()
		{
			super("PermissionService");
		}
	}
}