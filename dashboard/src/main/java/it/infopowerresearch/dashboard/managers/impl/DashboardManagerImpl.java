package it.infopowerresearch.dashboard.managers.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.infopowerresearch.dashboard.bean.Dashboard;
import it.infopowerresearch.dashboard.bean.User;
import it.infopowerresearch.dashboard.bean.Widget;
import it.infopowerresearch.dashboard.bean.WidgetTemplate;
import it.infopowerresearch.dashboard.dao.DashboardDAO;
import it.infopowerresearch.dashboard.dao.UserDAO;
import it.infopowerresearch.dashboard.dao.WidgetDAO;
import it.infopowerresearch.dashboard.dao.WidgetTemplateDAO;
import it.infopowerresearch.dashboard.managers.DashboardManager;

@Component
public class DashboardManagerImpl implements DashboardManager {

	private Logger log = LoggerFactory.getLogger(DashboardManagerImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private DashboardDAO dashboardDAO;

	@Autowired
	private WidgetDAO widgetDAO;

	@Autowired
	private WidgetTemplateDAO widgetTemplateDAO;

	@Override
	public Set<Dashboard> createDashboard(long userId) {
		try {
			Optional<User> optUser = userDAO.findById(userId);
			if (optUser.isPresent()) {
				Dashboard d = new Dashboard();
				Set<Dashboard> dashboards = dashboardDAO.findByUserId(userId);
				d.setName("dashboard" + (dashboards.size() + 1));
				d.setUser(optUser.get());
				d.setWidgets(new HashSet<>());
				dashboardDAO.save(d);
				return dashboardDAO.findByUserId(userId);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean deleteDashboard(long id) {
		try {
			dashboardDAO.deleteById(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return true;
	}

	@Override
	public Set<Dashboard> getUserDashboards(long userId) {
		return dashboardDAO.findByUserId(userId);
	}

	@Override
	public Dashboard getDashboard(long id) {
		try {
			Optional<Dashboard> optDashboard = dashboardDAO.findById(id);
			if (optDashboard.isPresent())
				return optDashboard.get();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Set<Widget> getWidgets(long id) {
		return widgetDAO.findByDashboardId(id);
	}

	@Override
	public Set<WidgetTemplate> getAllWidgetTemplates() {
		return new HashSet<>((Collection<? extends WidgetTemplate>) widgetTemplateDAO.findAll());
	}

	@Override
	public Dashboard saveDashboard(Dashboard dashboard) {

		if (dashboard.getId() != null) {
			widgetDAO.deleteByDashboardId(dashboard.getId());
		}

		for (Widget w : dashboard.getWidgets())
			w.setDashboard(dashboard);

		return dashboardDAO.save(dashboard);
	}
}
