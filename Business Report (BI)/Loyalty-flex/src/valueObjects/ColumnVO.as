package valueObjects
{	
	[Bindable]
	[RemoteClass(alias="valueObjects.ColumnVO")]
	public class ColumnVO
	{
		public var field:String;
		public var type:String;
		public var operador:int;
		public var selected:Boolean;
		public var category:Boolean;
		public var series:Boolean;
	}
}