package it.infopowerresearch.dashboard.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import it.infopowerresearch.dashboard.beans.SliderWidget;

public interface SliderWidgetDAO extends CrudRepository<SliderWidget, Long> {

	public SliderWidget findByTemplateId(long templateId);

	@Transactional
	public void deleteByTemplateId(long templateId);

}
