package it.infopowerresearch.dashboard.managers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.infopowerresearch.dashboard.beans.AbstractWidget;
import it.infopowerresearch.dashboard.beans.AlertWidget;
import it.infopowerresearch.dashboard.beans.ButtonWidget;
import it.infopowerresearch.dashboard.beans.ChartWidget;
import it.infopowerresearch.dashboard.beans.EditWidgetMetadata;
import it.infopowerresearch.dashboard.beans.SliderWidget;
import it.infopowerresearch.dashboard.beans.SwitchWidget;
import it.infopowerresearch.dashboard.beans.WidgetTemplate;
import it.infopowerresearch.dashboard.dto.AbstractWidgetDTO;

public interface WidgetManager {

	public Set<WidgetTemplate> getAllWidgetTemplates();

	public List<EditWidgetMetadata> getAllEditWidgetMetadata();

	public int buildPushNotification(String title, String body, String value) throws IOException;

	public Set<AbstractWidget> getWidgets(long[] ids);

	public Map<Long, List<Integer>> getWidgetsData(long[] ids);

	public int changeSliderValue(long id, int value);

	public int clickButtonWidget(long id);

	public int switchValue(long id, boolean value);

	public boolean saveWidget(AbstractWidgetDTO widget);

	public boolean deleteWidget(long templateId);

	public AbstractWidget getWidget(long templateId, String type);



}
