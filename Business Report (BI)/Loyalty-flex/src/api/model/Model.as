package api.model
{	
	import mx.collections.ArrayCollection;

	[Bindable]
	public class Model
	{
		private static var _instance:Model;
		
		public var applicationViewIndex:int=0;
		
		public var menu:ArrayCollection = new ArrayCollection();
		
		public var permissoes:ArrayCollection = new ArrayCollection();
		
		public var menuViewIndex:int = 0;
		
		public var notifications:ArrayCollection = new ArrayCollection();
		
		public var usuario:UsuarioModel = new UsuarioModel();
		
	
		public static function get instance():Model
		{
			if (_instance == null)
				_instance=new Model();
			return _instance;
		}
	}
}