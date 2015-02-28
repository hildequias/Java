package valueObjects
{	
	[Bindable]
	[RemoteClass(alias="valueObjects.RelColumnVO")]
	public class RelColumnVO extends BaseVO
	{
		public var id:int;
		public var colunaVO:ColumnVO;
		public var relatorioVO:ReportVO;
	}
}