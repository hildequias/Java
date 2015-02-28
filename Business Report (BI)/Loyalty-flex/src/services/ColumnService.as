package services
{	
	import config.Service;
	
	import mx.rpc.remoting.RemoteObject;
	
	public dynamic class ColumnService extends RemoteObjectBase
	{
		public function ColumnService()
		{
			super("ColumnService");
		}
	}
}