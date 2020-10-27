package it.infopowerresearch.dashboard.managers;

import it.infopowerresearch.dashboard.bean.AlertWidget;
import it.infopowerresearch.dashboard.bean.ButtonWidget;
import it.infopowerresearch.dashboard.bean.ChartWidget;

public interface WidgetManager {

	public AlertWidget getTemperature(long id);

	public int switchValue(long id, boolean value);

	public ChartWidget getData(long id);

	public ButtonWidget getButtonWidget(long templateId);

	public AlertWidget getAlertWidget(long templateId);

}
