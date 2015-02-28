package valueObjects
{	
	[Bindable]
	[RemoteClass(alias="valueObjects.UserProfileVO")]
	public class UserProfileVO extends BaseVO
	{
		public var id:int;
		public var descricao:String;
	}
}