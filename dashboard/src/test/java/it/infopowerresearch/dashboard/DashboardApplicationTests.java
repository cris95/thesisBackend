package it.infopowerresearch.dashboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.infopowerresearch.dashboard.bean.AlertWidget;
import it.infopowerresearch.dashboard.bean.ButtonWidget;
import it.infopowerresearch.dashboard.bean.ChartWidget;
import it.infopowerresearch.dashboard.bean.User;
import it.infopowerresearch.dashboard.bean.WidgetTemplate;
import it.infopowerresearch.dashboard.dao.AlertWidgetDAO;
import it.infopowerresearch.dashboard.dao.ButtonWidgetDAO;
import it.infopowerresearch.dashboard.dao.ChartWidgetDAO;
import it.infopowerresearch.dashboard.dao.UserDAO;
import it.infopowerresearch.dashboard.dao.WidgetTemplateDAO;

@SpringBootTest
class DashboardApplicationTests {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private WidgetTemplateDAO widgetTemplateDAO;

	@Autowired
	private AlertWidgetDAO alertWidgetDAO;

	@Autowired
	private ButtonWidgetDAO buttonWidgettDAO;

	@Autowired
	private ChartWidgetDAO chartWidgetDAO;

	@Test
	void contextLoads() {
	}

	@Test
	void userWorks() {
		User u = new User();
		u.setUsername("admin");
		u.setPassword("admin");
		userDAO.save(u);
	}

	@Test
	void widgets() {
		
		WidgetTemplate w = new WidgetTemplate();
		w.setType("button");
		w.setCols(2);
		w.setRows(1);
		w.setDescription("switch the pumps on/off");
		widgetTemplateDAO.save(w);
		
		w = widgetTemplateDAO.findById(1l).get();
		ButtonWidget b = new ButtonWidget();
		b.setLabel("pumps switch");
		b.setTemplate(w);
		buttonWidgettDAO.save(b);

		w = new WidgetTemplate();
		w.setType("alert");
		w.setCols(2);
		w.setRows(2);
		w.setDescription("cpu temperature");
		
		AlertWidget a = new AlertWidget();
		a.setLow(60);
		a.setHigh(80);
		a.setRefreshTime(2500);
		a.setLabel("cpu temperature");

		widgetTemplateDAO.save(w);
		w = widgetTemplateDAO.findById(2l).get();
		a.setTemplate(w);
		alertWidgetDAO.save(a);

		w = new WidgetTemplate();
		w.setType("chart");
		w.setCols(3);
		w.setRows(3);
		w.setDescription("bar chart");

		ChartWidget c = new ChartWidget();
		c.setLabel("bar chart");
		c.setType("bar");

		widgetTemplateDAO.save(w);
		w = widgetTemplateDAO.findById(3l).get();
		c.setTemplate(w);
		chartWidgetDAO.save(c);
		
		w = new WidgetTemplate();
		w.setType("chart");
		w.setCols(3);
		w.setRows(3);
		w.setDescription("line chart");

		c = new ChartWidget();
		c.setLabel("line chart");
		c.setType("line");

		widgetTemplateDAO.save(w);
		w = widgetTemplateDAO.findById(4l).get();
		c.setTemplate(w);
		chartWidgetDAO.save(c);

	}

}
