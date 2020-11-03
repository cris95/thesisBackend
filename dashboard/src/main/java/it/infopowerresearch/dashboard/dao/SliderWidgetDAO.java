package it.infopowerresearch.dashboard.dao;

import org.springframework.data.repository.CrudRepository;

import it.infopowerresearch.dashboard.bean.SliderWidget;

public interface SliderWidgetDAO extends CrudRepository<SliderWidget, Long> {
	
	public SliderWidget findByTemplateId(long templateId);

}
