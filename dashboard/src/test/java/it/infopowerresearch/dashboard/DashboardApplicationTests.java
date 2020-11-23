package it.infopowerresearch.dashboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.infopowerresearch.dashboard.beans.AlertWidget;
import it.infopowerresearch.dashboard.beans.ButtonWidget;
import it.infopowerresearch.dashboard.beans.ChartWidget;
import it.infopowerresearch.dashboard.beans.EditWidgetMetadata;
import it.infopowerresearch.dashboard.beans.SliderWidget;
import it.infopowerresearch.dashboard.beans.SwitchWidget;
import it.infopowerresearch.dashboard.beans.User;
import it.infopowerresearch.dashboard.beans.WidgetTemplate;
import it.infopowerresearch.dashboard.dao.AlertWidgetDAO;
import it.infopowerresearch.dashboard.dao.ButtonWidgetDAO;
import it.infopowerresearch.dashboard.dao.ChartWidgetDAO;
import it.infopowerresearch.dashboard.dao.EditWidgetMetadataDAO;
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

	@Autowired
	private EditWidgetMetadataDAO editWidgetMetadataDAO;

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

//	@Test
//	void widgets() {
//
//		WidgetTemplate w = new WidgetTemplate();
//		w.setType("button");
//		w.setCols(2);
//		w.setRows(1);
//		w.setLabel("turn off ...");
//		w.setDescription("turn off ...");
//		widgetTemplateDAO.save(w);
//		w = widgetTemplateDAO.findById(1l).get();
//		ButtonWidget b = new ButtonWidget();
//		b.setTemplate(w);
//		buttonWidgetDAO.save(b);
//
//		w = new WidgetTemplate();
//		w.setType("alert");
//		w.setCols(2);
//		w.setRows(2);
//		w.setDescription("cpu temperature");
//		w.setDataMode("local");
//		w.setUrl("getAlertData");
//		w.setLabel("cpu temperature");
//		widgetTemplateDAO.save(w);
//		w = widgetTemplateDAO.findById(2l).get();
//		AlertWidget a = new AlertWidget();
//		a.setLow(60);
//		a.setHigh(80);
//		a.setRefreshTime(3000);
//		a.setTemplate(w);
//		alertWidgetDAO.save(a);
//
//		w = new WidgetTemplate();
//		w.setType("chart");
//		w.setCols(3);
//		w.setRows(3);
//		w.setDescription("bar chart");
//		w.setDataMode("local");
//		w.setUrl("getChartData");
//		w.setLabel("bar chart");
//		widgetTemplateDAO.save(w);
//		w = widgetTemplateDAO.findById(3l).get();
//		ChartWidget c = new ChartWidget();
//		c.setChartType("bar");
//		c.setRefreshTime(6000);
//		c.setTemplate(w);
//		chartWidgetDAO.save(c);
//		
//		w = new WidgetTemplate();
//		w.setType("chart");
//		w.setCols(3);
//		w.setRows(3);
//		w.setDescription("line chart");
//		w.setLabel("line chart");
//		w.setDataMode("local");
//		w.setUrl("getChartData");
//		widgetTemplateDAO.save(w);
//		w = widgetTemplateDAO.findById(4l).get();
//		c = new ChartWidget();
//		c.setChartType("line");
//		c.setRefreshTime(4000);
//		c.setTemplate(w);
//		chartWidgetDAO.save(c);
//		
//		w = new WidgetTemplate();
//		w.setType("switch");
//		w.setCols(2);
//		w.setRows(1);
//		w.setLabel("switch the pumps on/off");
//		w.setDescription("switch the pumps on/off");
//		widgetTemplateDAO.save(w);
//		w = widgetTemplateDAO.findById(5l).get();
//		SwitchWidget s = new SwitchWidget();
//		s.setTemplate(w);
//		switchWidgetDAO.save(s);
//		
//		w = new WidgetTemplate();
//		w.setType("slider");
//		w.setCols(3);
//		w.setRows(1);
//		w.setDescription("level of ...");
//		w.setLabel("level of ...");
//		widgetTemplateDAO.save(w);
//		w = widgetTemplateDAO.findById(6l).get();
//		SliderWidget slider = new SliderWidget();
//		slider.setMin(1);
//		slider.setMax(10);
//		slider.setValue(2);
//		slider.setTemplate(w);
//		sliderWidgetDAO.save(slider);
//
//	}
//
//	@Test
//	void editMetadata() {
//
//		// Alert
//		EditWidgetMetadata e = new EditWidgetMetadata();
//		e = new EditWidgetMetadata();
//		e.setWidgetType("alert");
//		e.setField("description");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("alert");
//		e.setField("rows");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("alert");
//		e.setField("cols");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("alert");
//		e.setField("label");
//		editWidgetMetadataDAO.save(e);
//
//		e = new EditWidgetMetadata();
//		e.setWidgetType("alert");
//		e.setField("high");
//		editWidgetMetadataDAO.save(e);
//
//		e = new EditWidgetMetadata();
//		e.setWidgetType("alert");
//		e.setField("low");
//		editWidgetMetadataDAO.save(e);
//
//		e = new EditWidgetMetadata();
//		e.setWidgetType("alert");
//		e.setField("refresh_time");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("alert");
//		e.setField("data_mode");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("alert");
//		e.setField("url");
//		editWidgetMetadataDAO.save(e);
//		
//		// Button
//		e = new EditWidgetMetadata();
//		e.setWidgetType("button");
//		e.setField("description");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("button");
//		e.setField("rows");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("button");
//		e.setField("cols");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("button");
//		e.setField("label");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("button");
//		e.setField("url");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("button");
//		e.setField("data_mode");
//		editWidgetMetadataDAO.save(e);
//		
//		// Chart
//		e = new EditWidgetMetadata();
//		e.setWidgetType("chart");
//		e.setField("description");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("chart");
//		e.setField("rows");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("chart");
//		e.setField("cols");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("chart");
//		e.setField("label");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("chart");
//		e.setField("type");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("chart");
//		e.setField("refresh_time");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("chart");
//		e.setField("data_mode");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("chart");
//		e.setField("url");
//		editWidgetMetadataDAO.save(e);
//		
//		// Slider
//		e = new EditWidgetMetadata();
//		e.setWidgetType("slider");
//		e.setField("description");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("slider");
//		e.setField("rows");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("slider");
//		e.setField("cols");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("slider");
//		e.setField("label");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("slider");
//		e.setField("min");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("slider");
//		e.setField("max");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("slider");
//		e.setField("url");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("slider");
//		e.setField("data_mode");
//		editWidgetMetadataDAO.save(e);
//		
//		// Switch
//		e = new EditWidgetMetadata();
//		e.setWidgetType("switch");
//		e.setField("description");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("switch");
//		e.setField("rows");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("switch");
//		e.setField("cols");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("switch");
//		e.setField("label");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("switch");
//		e.setField("url");
//		editWidgetMetadataDAO.save(e);
//		
//		e = new EditWidgetMetadata();
//		e.setWidgetType("switch");
//		e.setField("data_mode");
//		editWidgetMetadataDAO.save(e);
//		
//	}
	
}
