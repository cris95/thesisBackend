package it.infopowerresearch.dashboard.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.infopowerresearch.dashboard.bean.AlertWidget;
import it.infopowerresearch.dashboard.bean.ButtonWidget;
import it.infopowerresearch.dashboard.bean.ChartWidget;
import it.infopowerresearch.dashboard.bean.Dashboard;
import it.infopowerresearch.dashboard.bean.SwitchWidget;
import it.infopowerresearch.dashboard.bean.User;
import it.infopowerresearch.dashboard.bean.WidgetTemplate;
import it.infopowerresearch.dashboard.managers.DashboardManager;
import it.infopowerresearch.dashboard.managers.UserManager;
import it.infopowerresearch.dashboard.managers.WidgetManager;

@RestController
@CrossOrigin("*")
public class DashboardController {

	Logger log = org.slf4j.LoggerFactory.getLogger(DashboardController.class);

	@Autowired
	private UserManager userManager;

	@Autowired
	DashboardManager dashboardManager;

	@Autowired
	WidgetManager widgetManager;

	@PostMapping("/login")
	public User login(final String username, final HttpEntity<String> password) {
		return userManager.login(username, password.getBody());
	}

	@GetMapping("/getUserDashboards")
	public Set<Dashboard> getUserDashboards(final long userId) {
		return dashboardManager.getUserDashboards(userId);
	}

	@GetMapping("/createDashboard")
	public Set<Dashboard> createDashboard(final long userId) {
		return dashboardManager.createDashboard(userId);
	}

	@GetMapping("/getDashboard")
	public Dashboard getDashboard(final long id) {
		return dashboardManager.getDashboard(id);
	}

	@PostMapping("/saveDashboard")
	public Dashboard saveDashboard(final HttpEntity<Dashboard> dashboard) {
		return dashboardManager.saveDashboard(dashboard.getBody());
	}

	@GetMapping("/deleteDashboard")
	public boolean deleteDashboard(final long id) {
		return dashboardManager.deleteDashboard(id);
	}

	@GetMapping("/getAllWidgetTemplates")
	public Set<WidgetTemplate> getAllWidgetTemplates() {
		return dashboardManager.getAllWidgetTemplates();
	}
	
	@GetMapping("/getAlertWidgets")
	public Set<AlertWidget> getAlertWidgets(final long[] ids){
		return widgetManager.getAlertWidgets(ids);
	}
	
	@GetMapping("/getChartWidgets")
	public Set<ChartWidget> getChartWidgets(final long[] ids){
		return widgetManager.getChartWidgets(ids);
	}
	
	@GetMapping("/getData")
	public Map<Long, List<Integer>> getData(final long[] ids){
		return widgetManager.getData(ids);
	}
	
	@GetMapping("/getButtonWidget")
	public ButtonWidget getButtonWidget(final long templateId) {
		return widgetManager.getButtonWidget(templateId);
	}
	
	@GetMapping("/getSwitchWidget")
	public SwitchWidget getSwitchWidget(final long templateId) {
		return widgetManager.getSwitchWidget(templateId);
	}
	
	@GetMapping("/getAlertWidget")
	public AlertWidget getAlertWidget(final long templateId) {
		return widgetManager.getAlertWidget(templateId);
	}

	@GetMapping("/getChartWidget")
	public ChartWidget getChartWidget(final long templateId) {
		return widgetManager.getChartWidget(templateId);
	}

	@GetMapping("/switchValue")
	public int switchValue(final long id, final boolean value) {
		return widgetManager.switchValue(id, value);
	}
	
	@GetMapping("clickButtonWidget")
	public int clickButtonWidget(final long id) {
		return widgetManager.clickButtonWidget(id);
	}


}
