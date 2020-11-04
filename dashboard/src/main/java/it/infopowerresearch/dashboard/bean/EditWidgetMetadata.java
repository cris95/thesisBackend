package it.infopowerresearch.dashboard.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "edit_widget_metadata")
public class EditWidgetMetadata extends AbstractIdentifiedBean{

	private static final long serialVersionUID = 1L;

	private String widgetType;
	
	private String field;
	
	public String getWidgetType() {
		return widgetType;
	}

	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
