package it.infopowerresearch.dashboard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.infopowerresearch.dashboard.bean.AlertWidget;
import it.infopowerresearch.dashboard.bean.Dashboard;
import it.infopowerresearch.dashboard.bean.User;
import it.infopowerresearch.dashboard.bean.Widget;
import it.infopowerresearch.dashboard.bean.WidgetTemplate;
import it.infopowerresearch.dashboard.dao.AlertWidgetDAO;
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
	
	@Autowired
	private AlertWidgetDAO alertWidgetDAO;

	@Test
	void contextLoads() {
	}

	@Test
	void userWorks() {
		User u = new User();
		u.setUsername("admin");
		u.setPassword("admin");

		userDAO.save(u);

		u = userDAO.findByUsername("admin");

		Dashboard d = new Dashboard();
		d.setName("dashboard1");

		d.setUser(u);

		d.setWidgets(new HashSet<Widget>());

//		dashboardDAO.save(d);

	}

	@Test
	void widgets() {
		WidgetTemplate w = new WidgetTemplate();
		w.setType("alert");
		w.setCols(2);
		w.setRows(2);
		w.setDescription("monitor the cpu temperature");

		widgetTemplateDAO.save(w);

		w = widgetTemplateDAO.findById(1l).get();

		AlertWidget a = new AlertWidget();
		a.setHigh(80);
		a.setLow(60);
		a.setTemplate(w);
		
		alertWidgetDAO.save(a);

//		Set<WidgetTemplate> widgets = new HashSet<>((Collection<? extends WidgetTemplate>) widgetTemplateDAO.findAll());
//
//		assertEquals(1, widgets.size());
	}

}
