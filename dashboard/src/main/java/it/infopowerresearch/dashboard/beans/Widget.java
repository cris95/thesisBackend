package it.infopowerresearch.dashboard.beans;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "widgets")
public class Widget extends AbstractIdentifiedBean {

	private static final long serialVersionUID = 1L;

	private int x;

	private int y;

	private int rows;

	private int cols;

	@ManyToOne
	@JsonIgnore
	private Dashboard dashboard;

	@ManyToOne
	private WidgetTemplate template;

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Dashboard getDashboard() {
		return dashboard;
	}

	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}

	public WidgetTemplate getTemplate() {
		return template;
	}

	public void setTemplate(WidgetTemplate template) {
		this.template = template;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
