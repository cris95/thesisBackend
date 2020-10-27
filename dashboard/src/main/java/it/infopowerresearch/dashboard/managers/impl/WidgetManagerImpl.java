package it.infopowerresearch.dashboard.managers.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.infopowerresearch.dashboard.bean.AlertWidget;
import it.infopowerresearch.dashboard.bean.ButtonWidget;
import it.infopowerresearch.dashboard.bean.ChartWidget;
import it.infopowerresearch.dashboard.dao.AlertWidgetDAO;
import it.infopowerresearch.dashboard.dao.ButtonWidgetDAO;
import it.infopowerresearch.dashboard.dao.ChartWidgetDAO;
import it.infopowerresearch.dashboard.managers.WidgetManager;

@Component
public class WidgetManagerImpl implements WidgetManager {

	@Autowired
	private AlertWidgetDAO alertWidgetDAO;

	@Autowired
	private ButtonWidgetDAO buttonWidgetDAO;

	@Autowired
	private ChartWidgetDAO chartWidgetDAO;

	@Override
	public AlertWidget getTemperature(long id) {

		AlertWidget a = alertWidgetDAO.findByTemplateId(id);
		a.setValue(new Random().nextInt(60) + 40);
		return a;

	}

	@Override
	public int switchValue(long id, boolean value) {
//		ButtonWidget b = buttonWidgetDAO.findByTemplateId(id);

		try {
			List<Integer> a = null;
			a.get(3);
		} catch (Exception e) {
		}

		return (value) ? 1 : 0;
	}

	@Override
	public ChartWidget getData(long id) {
		ChartWidget c = chartWidgetDAO.findByTemplateId(id);
		ArrayList<Integer> l = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			l.add(new Random().nextInt(50));
		}
		c.setValues(l);
		return c;
	}

	@Override
	public ButtonWidget getButtonWidget(long templateId) {
		return buttonWidgetDAO.findByTemplateId(templateId);
	}

	@Override
	public AlertWidget getAlertWidget(long templateId) {
		return alertWidgetDAO.findByTemplateId(templateId);
	}

}
