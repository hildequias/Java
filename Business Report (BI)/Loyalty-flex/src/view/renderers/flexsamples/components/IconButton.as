package view.renderers.flexsamples.components
{
	import view.renderers.flexsamples.components.IconButton;
	import mx.controls.Button;
	import mx.events.FlexEvent;
	
	[style(name="icon",type="*")]
	public class IconButton extends Button
	{
		public function IconButton()
		{
			this.addEventListener(FlexEvent.CREATION_COMPLETE, OnComplete);
			super();
		}
		
		private function OnComplete(event:FlexEvent):void{
			
			this.setStyle("skinClass", Class(IconButtonSkin));
		}
	}
}