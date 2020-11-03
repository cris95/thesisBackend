package it.infopowerresearch.dashboard.bean;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "slider_widgets")
public class SliderWidget extends AbstractIdentifiedBean {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private WidgetTemplate template;

	private String label;

	private String url;

	private int min;

	private int max;

	private int value;

	public WidgetTemplate getTemplate() {
		return template;
	}

	public void setTemplate(WidgetTemplate template) {
		this.template = template;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
