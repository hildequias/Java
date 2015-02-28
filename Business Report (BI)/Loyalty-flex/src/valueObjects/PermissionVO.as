package valueObjects
{	
	[Bindable]
	[RemoteClass(alias="valueObjects.PermissionVO")]
	public class PermissionVO
	{
		public var id:int;
		public var recurso:ResourceVO;
		public var perfilUsuario:UserProfileVO;
		public var novo:Boolean;
		public var editar:Boolean;
		public var excluir:Boolean;
	}
}