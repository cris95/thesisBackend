package it.infopowerresearch.dashboard.dao;

import org.springframework.data.repository.CrudRepository;

import it.infopowerresearch.dashboard.bean.ButtonWidget;

public interface ButtonWidgetDAO extends CrudRepository<ButtonWidget, Long> {

	public ButtonWidget findByTemplateId(long templateId);
}
