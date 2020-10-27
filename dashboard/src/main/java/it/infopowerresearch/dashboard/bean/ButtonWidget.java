package it.infopowerresearch.dashboard.bean;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "button_widgets")
public class ButtonWidget  extends AbstractIdentifiedBean{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private WidgetTemplate template;
	
	private String label;

	private String url;
	
	public WidgetTemplate getTemplate() {
		return template;
	}

	public void setTemplate(WidgetTemplate template) {
		this.template = template;
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
