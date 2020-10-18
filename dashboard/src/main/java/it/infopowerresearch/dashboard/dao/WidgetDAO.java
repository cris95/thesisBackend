package it.infopowerresearch.dashboard.dao;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.infopowerresearch.dashboard.bean.Widget;

@Repository
public interface WidgetDAO extends CrudRepository<Widget, Long> {

	public Set<Widget> findByDashboardId(long dashboardId);
	
	@Transactional
	public void deleteByDashboardId(long dashboardId);

}
