package it.infopowerresearch.dashboard.managers;

import java.util.Set;

import it.infopowerresearch.dashboard.beans.Dashboard;
import it.infopowerresearch.dashboard.beans.Widget;
import it.infopowerresearch.dashboard.beans.WidgetTemplate;

public interface DashboardManager {

	public Set<Dashboard> createDashboard(long userId);
	
	public boolean deleteDashboard(long id);
	
	public Dashboard saveDashboard(Dashboard dashboard);
	
	public Set<Dashboard> getUserDashboards(long userId);

	public Dashboard getDashboard(long id);
	
	public Set<Widget> getWidgets(long id);

	


		
	
}
