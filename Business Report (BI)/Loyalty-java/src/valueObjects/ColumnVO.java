package valueObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BI_COLUMN")
public class ColumnVO {
	
	@Id
	@GeneratedValue
	int id;
	
	String field;
	String type;
	
	@Column(name="selected", nullable = false,  columnDefinition="bit default 0")
	Boolean selected;
	
	@Column(name="category", nullable = false,  columnDefinition="bit default 0")
	Boolean category;
	
	@Column(name="series", nullable = false,  columnDefinition="bit default 0")
	Boolean series;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	public Boolean getCategory() {
		return category;
	}
	public void setCategory(Boolean category) {
		this.category = category;
	}
	public Boolean getSeries() {
		return series;
	}
	public void setSeries(Boolean series) {
		this.series = series;
	}
	
}
