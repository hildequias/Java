package services
{
	import config.Service;
	
	import mx.rpc.remoting.RemoteObject;
	
	public dynamic class UserProfileService extends RemoteObjectBase
	{
		public function UserProfileService()
		{
			super("UserProfileService");
		}
	}
}