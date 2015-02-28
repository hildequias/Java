package valueObjects
{	
	[Bindable]
	[RemoteClass(alias="valueObjects.BaseVO")]
	public class BaseVO
	{
		public var cadastro_usuario:String;
		public var excluido:Boolean;
		public var excluido_data:Date;
		public var excluido_usuario:String;
		public var cadastro_data:Date;
	}
}