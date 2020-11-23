package it.infopowerresearch.dashboard.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import it.infopowerresearch.dashboard.beans.SwitchWidget;

public interface SwitchWidgetDAO extends CrudRepository<SwitchWidget, Long> {

	public SwitchWidget findByTemplateId(long templateId);

	@Transactional
	public void deleteByTemplateId(long templateId);
}
