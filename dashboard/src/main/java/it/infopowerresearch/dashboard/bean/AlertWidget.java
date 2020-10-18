package it.infopowerresearch.dashboard.bean;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "alert_widgets")
public class AlertWidget extends AbstractIdentifiedBean {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private WidgetTemplate template;
	
	@Transient
	private int value;
	
	private int high;
	
	private int low;
	
	public WidgetTemplate getTemplate() {
		return template;
	}

	public void setTemplate(WidgetTemplate template) {
		this.template = template;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getHigh() {
		return high;
		
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
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
