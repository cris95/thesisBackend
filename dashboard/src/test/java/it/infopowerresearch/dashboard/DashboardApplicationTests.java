package it.infopowerresearch.dashboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.infopowerresearch.dashboard.bean.AlertWidget;
import it.infopowerresearch.dashboard.bean.ButtonWidget;
import it.infopowerresearch.dashboard.bean.ChartWidget;
import it.infopowerresearch.dashboard.bean.SliderWidget;
import it.infopowerresearch.dashboard.bean.SwitchWidget;
import it.infopowerresearch.dashboard.bean.User;
import it.infopowerresearch.dashboard.bean.WidgetTemplate;
import it.infopowerresearch.dashboard.dao.AlertWidgetDAO;
import it.infopowerresearch.dashboard.dao.ButtonWidgetDAO;
import it.infopowerresearch.dashboard.dao.ChartWidgetDAO;
import it.infopowerresearch.dashboard.dao.SliderWidgetDAO;
import it.infopowerresearch.dashboard.dao.SwitchWidgetDAO;
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
	private ButtonWidgetDAO buttonWidgetDAO;

	@Autowired
	private ChartWidgetDAO chartWidgetDAO;

	@Autowired
	private SliderWidgetDAO sliderWidgetDAO;

	@Autowired
	private SwitchWidgetDAO switchWidgetDAO;

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
		
//		WidgetTemplate w = new WidgetTemplate();
//		w.setType("button");
//		w.setCols(2);
//		w.setRows(1);
//		w.setDescription("turn off ...");
//		widgetTemplateDAO.save(w);
//		w = widgetTemplateDAO.findById(1l).get();
//		ButtonWidget b = new ButtonWidget();
//		b.setLabel("turn off ...");
//		b.setTemplate(w);
//		buttonWidgetDAO.save(b);
//
//		w = new WidgetTemplate();
//		w.setType("alert");
//		w.setCols(2);
//		w.setRows(2);
//		w.setDescription("cpu temperature");
//		widgetTemplateDAO.save(w);
//		w = widgetTemplateDAO.findById(2l).get();
//		AlertWidget a = new AlertWidget();
//		a.setLow(60);
//		a.setHigh(80);
//		a.setRefreshTime(3000);
//		a.setLabel("cpu temperature");
//		a.setTemplate(w);
//		alertWidgetDAO.save(a);
//
//		w = new WidgetTemplate();
//		w.setType("chart");
//		w.setCols(3);
//		w.setRows(3);
//		w.setDescription("bar chart");
//		widgetTemplateDAO.save(w);
//		w = widgetTemplateDAO.findById(3l).get();
//		ChartWidget c = new ChartWidget();
//		c.setLabel("bar chart");
//		c.setType("bar");
//		c.setRefreshTime(6000);
//		c.setTemplate(w);
//		chartWidgetDAO.save(c);
//		
//		w = new WidgetTemplate();
//		w.setType("chart");
//		w.setCols(3);
//		w.setRows(3);
//		w.setDescription("line chart");
//		widgetTemplateDAO.save(w);
//		w = widgetTemplateDAO.findById(4l).get();
//		c = new ChartWidget();
//		c.setLabel("line chart");
//		c.setType("line");
//		c.setRefreshTime(4000);
//		c.setTemplate(w);
//		chartWidgetDAO.save(c);
//		
//		w = new WidgetTemplate();
//		w.setType("switch");
//		w.setCols(2);
//		w.setRows(1);
//		w.setDescription("switch the pumps on/off");
//		widgetTemplateDAO.save(w);
//		w = widgetTemplateDAO.findById(5l).get();
//		SwitchWidget s = new SwitchWidget();
//		s.setLabel("switch the pumps on/off");
//		s.setTemplate(w);
//		switchWidgetDAO.save(s);
//		
//		w = new WidgetTemplate();
//		w.setType("slider");
//		w.setCols(3);
//		w.setRows(1);
//		w.setDescription("level of ...");
//		widgetTemplateDAO.save(w);
//		w = widgetTemplateDAO.findById(6l).get();
//		SliderWidget slider = new SliderWidget();
//		slider.setLabel("level of ...");
//		slider.setMin(1);
//		slider.setMax(10);
//		slider.setValue(2);
//		slider.setTemplate(w);
//		sliderWidgetDAO.save(slider);
		
	}

}
