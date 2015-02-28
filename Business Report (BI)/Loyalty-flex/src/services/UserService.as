package services
{
	import config.Service;
	
	import mx.rpc.remoting.RemoteObject;
	
	public dynamic class UserService extends RemoteObjectBase
	{
		public function UserService()
		{
			super("UserService");
		}
	}
}