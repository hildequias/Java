package valueObjects
{	
	[Bindable]
	[RemoteClass(alias="valueObjects.FilterVO")]
	public class FilterVO
	{
		public var operation:String;
		public var home_filter:String;
		public var end_filter:String;
		public var column:ColumnVO;
	}
}