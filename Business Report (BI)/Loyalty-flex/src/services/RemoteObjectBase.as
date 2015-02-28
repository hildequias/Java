package services
{
	import config.Service;
	
	import mx.controls.Alert;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class RemoteObjectBase extends RemoteObject
	{
		public function RemoteObjectBase(destination:String=null)
		{
			super(destination);
			this.addEventListener(FaultEvent.FAULT,OnFault);
			endpoint = config.Service.END_POINT;
		}
		
		protected function OnFault(e:FaultEvent):void
		{
			Alert.show(e.fault.rootCause.message, "Erro!");
		}
		
	}
}