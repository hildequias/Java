package valueObjects
{
	[Bindable]
	[RemoteClass(alias="valueObjects.UserVO")]
	public class UserVO extends BaseVO
	{
		public var id:int;
		public var usuario:String;
		public var nome_completo:String;
		public var email:String;
		public var password:String;
		public var observacao:String;
		public var ativo:Boolean;
		public var data_ultimo_login:Date;
		public var perfilUsuario:UserProfileVO;
		
	}
}