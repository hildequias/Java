package valueObjects
{	
	[Bindable]
	[RemoteClass(alias="valueObjects.ConnectionVO")]
	public class ConnectionVO extends BaseVO
	{
		public var id:int;
		public var nome:String;
		public var banco:String;
		public var servidor:String;
		public var porta:String;
		public var data_base:String;
		public var user:String;
		public var senha:String;
	}
}