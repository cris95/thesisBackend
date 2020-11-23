package it.infopowerresearch.dashboard.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import it.infopowerresearch.dashboard.beans.ButtonWidget;

public interface ButtonWidgetDAO extends CrudRepository<ButtonWidget, Long> {

	public ButtonWidget findByTemplateId(long templateId);

	@Transactional
	public void deleteByTemplateId(long templateId);
}
