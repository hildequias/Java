package valueObjects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BI_FILTERS")
public class FilterVO extends BaseVO{
	
	@Id
	@GeneratedValue
	int id;
	
	String operation;
	String home_filter;
	String end_filter;
	
	@ManyToOne(fetch=FetchType.EAGER)
	ColumnVO column;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getHome_filter() {
		return home_filter;
	}
	public void setHome_filter(String home_filter) {
		this.home_filter = home_filter;
	}
	public String getEnd_filter() {
		return end_filter;
	}
	public void setEnd_filter(String end_filter) {
		this.end_filter = end_filter;
	}
	public ColumnVO getColumn() {
		return column;
	}
	public void setColumn(ColumnVO column) {
		this.column = column;
	}
	
}
