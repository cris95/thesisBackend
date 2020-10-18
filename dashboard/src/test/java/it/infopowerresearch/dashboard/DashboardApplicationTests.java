package it.infopowerresearch.dashboard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.infopowerresearch.dashboard.bean.Dashboard;
import it.infopowerresearch.dashboard.bean.User;
import it.infopowerresearch.dashboard.bean.Widget;
import it.infopowerresearch.dashboard.bean.WidgetTemplate;
import it.infopowerresearch.dashboard.dao.DashboardDAO;
import it.infopowerresearch.dashboard.dao.UserDAO;
import it.infopowerresearch.dashboard.dao.WidgetDAO;
import it.infopowerresearch.dashboard.dao.WidgetTemplateDAO;

@SpringBootTest
class DashboardApplicationTests {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private DashboardDAO dashboardDAO;

	@Autowired
	private WidgetDAO widgetDAO;

	@Autowired
	private WidgetTemplateDAO widgetTemplateDAO;

	@Test
	void contextLoads() {
	}

	@Test
	void userWorks() {
		User u = new User();
		u.setUsername("admin");
		u.setPassword("admin");

		// userDAO.save(u);

		u = userDAO.findByUsername("admin");

		Dashboard d = new Dashboard();
		d.setName("dashboard2");

		d.setUser(u);

		d.setWidgets(new HashSet<Widget>());

		Widget w = new Widget();
		w.setCols(1);
		w.setRows(1);
		w.setX(1);
		w.setY(1);

		d.addWidget(w);

		w = new Widget();
		w.setCols(1);
		w.setRows(3);
		w.setX(3);
		w.setY(3);

		d.addWidget(w);

//		dashboardDAO.save(d);

	}

	@Test
	void widgets() {
		WidgetTemplate w = new WidgetTemplate();
		w.setType("switch");
		w.setCols(2);
		w.setRows(1);
		w.setDescription("switch on/off");

		//widgetTemplateDAO.save(w);

		w = new WidgetTemplate();
		w.setType("pie chart");
		w.setCols(3);
		w.setRows(3);
		w.setDescription("pie chart");

		//widgetTemplateDAO.save(w);

		Set<WidgetTemplate> widgets = new HashSet<>((Collection<? extends WidgetTemplate>) widgetTemplateDAO.findAll());
		
		assertEquals(2, widgets.size());
	}

}
