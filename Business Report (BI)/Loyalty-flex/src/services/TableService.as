package services
{
	import config.Service;
	
	import mx.rpc.remoting.RemoteObject;
	
	public dynamic class TableService extends RemoteObjectBase
	{
		public function TableService()
		{
			super("TableService");
		}
	}
}