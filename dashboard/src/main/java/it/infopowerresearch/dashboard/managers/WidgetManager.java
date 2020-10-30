package it.infopowerresearch.dashboard.managers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.infopowerresearch.dashboard.bean.AlertWidget;
import it.infopowerresearch.dashboard.bean.ButtonWidget;
import it.infopowerresearch.dashboard.bean.ChartWidget;
import it.infopowerresearch.dashboard.bean.SwitchWidget;

public interface WidgetManager {

	public ChartWidget getChartWidget(long id);

	public ButtonWidget getButtonWidget(long templateId);

	public SwitchWidget getSwitchWidget(long templateId);

	public AlertWidget getAlertWidget(long templateId);

	public int switchValue(long id, boolean value);

	public int clickButtonWidget(long id);

	public int buildPushNotification(String title, String body, String value) throws IOException;

	public Set<AlertWidget> getAlertWidgets(long[] ids);

	public Set<ChartWidget> getChartWidgets(long[] ids);

	public Map<Long, Integer> getAlertsData(long[] ids);

	public Map<Long, List<Integer>> getChartsData(long[] ids);

}
