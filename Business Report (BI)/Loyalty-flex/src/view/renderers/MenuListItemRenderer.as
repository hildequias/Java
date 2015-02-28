package view.renderers
{
	import valueObjects.ResourceVO;
	
	import mx.containers.Canvas;
	import mx.controls.listClasses.ListItemRenderer;

	public class MenuListItemRenderer extends ListItemRenderer
	{
		private var canvas:Canvas;
		protected override function createChildren():void
		{
			super.createChildren();
			canvas = new Canvas();
			canvas.x = -1;
			canvas.y = 0;
			super.addChildAt(canvas, Infinity);	
		}
		
		public override function set data(value:Object):void
		{
			super.data	= value;

			if (value != null && value is ResourceVO)
				setStyleRecurso();
			else
				clearStyleRecurso();
		}
		
		protected override  function updateDisplayList(w:Number, h:Number):void
		{
			super.updateDisplayList(w, h);
			canvas.height = this.height;
			canvas.width = this.width;
		}
		
		private function setStyleRecurso():void
		{
			var r:ResourceVO = super.data as ResourceVO;
			if (r.group)
			{
				canvas.setStyle("backgroundColor", 0xDDDDDD);
				super.setStyle("fontWeight","bold");
			}
			else
				clearStyleRecurso();	
		}
		
		private function clearStyleRecurso():void
		{
			canvas.clearStyle('backgroundColor');
			super.clearStyle('fontWeight');
		}
	}
}