package it.infopowerresearch.dashboard.managers.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.infopowerresearch.dashboard.bean.AlertWidget;
import it.infopowerresearch.dashboard.dao.AlertWidgetDAO;
import it.infopowerresearch.dashboard.managers.WidgetManager;

@Component
public class WidgetManagerImpl implements WidgetManager {

	@Autowired
	private AlertWidgetDAO alertWidgetDAO;

	@Override
	public int getTemperature(long id) {

		Optional<AlertWidget> optAlert = alertWidgetDAO.findById(id);
		if (optAlert.isPresent()) {
			return new Random().nextInt(60) + 40;
		}
		return 0;

	}

}
