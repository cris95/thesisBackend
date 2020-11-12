package it.infopowerresearch.dashboard.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import it.infopowerresearch.dashboard.bean.AbstractWidget;
import it.infopowerresearch.dashboard.bean.Dashboard;
import it.infopowerresearch.dashboard.bean.EditWidgetMetadata;
import it.infopowerresearch.dashboard.bean.User;
import it.infopowerresearch.dashboard.bean.WidgetTemplate;
import it.infopowerresearch.dashboard.dto.AbstractWidgetDTO;
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

	@GetMapping("/deleteWidget")
	public boolean deleteWidget(final long templateId) {
		return widgetManager.deleteWidget(templateId);
	}
	
	@PostMapping("/saveWidget")
	public boolean saveWidget(final HttpEntity<AbstractWidgetDTO> widget) {
		return widgetManager.saveWidget(widget.getBody());
	}

	@GetMapping("/getAllWidgetTemplates")
	public Set<WidgetTemplate> getAllWidgetTemplates() {
		return widgetManager.getAllWidgetTemplates();
	}

	@GetMapping("/getAllEditWidgetMetadata")
	public List<EditWidgetMetadata> getAllEditWidgetMetadata() {
		return widgetManager.getAllEditWidgetMetadata();
	}
	
	@GetMapping("/getWidgets")
	public Set<AbstractWidget> getWidgets(final long[] ids){
		return widgetManager.getWidgets(ids);
	}

	@GetMapping("/getWidgetsData")
	public Map<Long, List<Integer>> getWidgetsData(final long[] ids) {
		return widgetManager.getWidgetsData(ids);
	}

	@GetMapping("/getWidget")
	public AbstractWidget getWidget(final long templateId, final String type) {
		return widgetManager.getWidget(templateId, type);
	}

	@GetMapping("/changeSliderValue")
	public int changeSliderValue(final long id, final int value) {
		return widgetManager.changeSliderValue(id, value);
	}

	@GetMapping("/clickButtonWidget")
	public int clickButtonWidget(final long id) {
		return widgetManager.clickButtonWidget(id);
	}

	@GetMapping("/switchValue")
	public int switchValue(final long id, final boolean value) {
		return widgetManager.switchValue(id, value);
	}

}
