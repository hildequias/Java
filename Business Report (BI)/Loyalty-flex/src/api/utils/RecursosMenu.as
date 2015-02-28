package api.utils
{
	import valueObjects.ResourceVO;
	
	import mx.collections.ArrayCollection;
	import mx.utils.StringUtil;
	
	public class RecursosMenu
	{
		public static function makeMenu(recursos:ArrayCollection): ArrayCollection
		{
			var grupo:String = '_____________________________________sys   !@$#%#@  12343________@#$@#$% 23423 @#!$@#$%';
			
			var ar:Array=[];
			
			var gr:ResourceVO = new ResourceVO();
			gr.nome_exibicao = "Home";
			gr.icon = "HOME";
			gr.visao = 0;
			ar.push(gr);
			
			for each (var recurso:ResourceVO in recursos)
			{
				if (recurso.grupo != grupo)
				{
					gr = new ResourceVO();
					grupo = recurso.grupo;
					gr.nome_exibicao = grupo == null ? '' : StringUtil.trim	(grupo);
					gr.group = true;
					ar.push(gr);
				}
			//	recurso.children = null;
				if (recurso.icon=='' || recurso.icon == null)
					recurso.icon = "folder";
				//gr.children.addItem(recurso);
				ar.push(recurso);
			}
			return new ArrayCollection(ar);
		}

	}
}