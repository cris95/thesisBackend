package it.infopowerresearch.dashboard.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.infopowerresearch.dashboard.beans.AlertWidget;

@Repository
public interface AlertWidgetDAO extends CrudRepository<AlertWidget, Long> {

	public AlertWidget findByTemplateId(long templateId);

	@Transactional
	public void deleteByTemplateId(long templateId);
	
}
