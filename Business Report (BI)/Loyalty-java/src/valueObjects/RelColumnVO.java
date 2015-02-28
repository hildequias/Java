package valueObjects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BI_REPORTS_COLUMN")
public class RelColumnVO extends BaseVO{
	
	@Id
	@GeneratedValue
	int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	ColumnVO colunaVO;
	
	@ManyToOne(fetch=FetchType.EAGER)
	ReportVO relatorioVO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ColumnVO getColunaVO() {
		return colunaVO;
	}

	public void setColunaVO(ColumnVO colunaVO) {
		this.colunaVO = colunaVO;
	}

	public ReportVO getRelatorioVO() {
		return relatorioVO;
	}

	public void setRelatorioVO(ReportVO relatorioVO) {
		this.relatorioVO = relatorioVO;
	}
	
}
