package it.infopowerresearch.dashboard.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.infopowerresearch.dashboard.bean.WidgetTemplate;

@Repository
public interface WidgetTemplateDAO extends CrudRepository<WidgetTemplate, Long> {

}
