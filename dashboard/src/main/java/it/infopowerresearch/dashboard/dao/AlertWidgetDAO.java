package it.infopowerresearch.dashboard.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.infopowerresearch.dashboard.bean.AlertWidget;

@Repository
public interface AlertWidgetDAO extends CrudRepository<AlertWidget, Long> {

	public AlertWidget findByTemplateId(long templateId);
	
}
