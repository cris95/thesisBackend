package it.infopowerresearch.dashboard.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import it.infopowerresearch.dashboard.bean.ButtonWidget;
import it.infopowerresearch.dashboard.bean.ChartWidget;

public interface ChartWidgetDAO extends CrudRepository<ChartWidget, Long> {

	public ChartWidget findByTemplateId(long templateId);

	@Transactional
	public void deleteByTemplateId(long templateId);

}
