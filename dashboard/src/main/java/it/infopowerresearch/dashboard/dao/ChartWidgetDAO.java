package it.infopowerresearch.dashboard.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import it.infopowerresearch.dashboard.beans.ButtonWidget;
import it.infopowerresearch.dashboard.beans.ChartWidget;

public interface ChartWidgetDAO extends CrudRepository<ChartWidget, Long> {

	public ChartWidget findByTemplateId(long templateId);

	@Transactional
	public void deleteByTemplateId(long templateId);

}
