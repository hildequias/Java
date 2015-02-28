package valueObjects
{	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="valueObjects.ResourceVO")]
	public class ResourceVO
	{
		public var id:int;
		public var nome_exibicao:String;
		public var descricao:String;
		public var visao:int=0;
		public var icon:String;
		public var grupo:String;
		public var excluido:Boolean;
		
		[Transient]
		public var selected:Boolean = false;
		
		[Transient]
		public var novo:Boolean = false;
		
		[Transient]
		public var editar:Boolean = false;
		
		[Transient]
		public var excluir:Boolean = false;
		
		[Transient]
		public var group:Boolean = false;
	}
}