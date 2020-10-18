package it.infopowerresearch.dashboard.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dashboards")
public class Dashboard extends AbstractIdentifiedBean {

	private static final long serialVersionUID = 1L;

	private String name;

	@OneToMany(mappedBy = "dashboard", cascade = CascadeType.ALL)
	private Set<Widget> widgets;

	@ManyToOne
	private User user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public Set<Widget> getWidgets() {
		return widgets;
	}

	public void setWidgets(Set<Widget> widgets) {
		this.widgets = widgets;
	}

	public void addWidget(Widget widget) {

		if (widgets == null)
			widgets = new HashSet<Widget>();

		widget.setDashboard(this);
		widgets.add(widget);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof User))
			return false;
		Dashboard other = (Dashboard) obj;
		return (this.getId() != null && this.getId() == other.getId());
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
//		String s = "Dashboard " + getId() + "\nname: "  + name + "\nuser_id " + user_id + "\nwidgets: [ ";
//		for(Widget w : widgets)
//			s +=  "x: " + w.getX() + " y: " + w.getY() + " rows: " + w.getRows() + " cols: " + w.getCols() + ", ";
//		s = s.substring(0, s.lastIndexOf(','));
//		s += "] ";
//		
//		return s;
		return null;
	}

}
