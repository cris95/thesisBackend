package it.infopowerresearch.dashboard.managers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.infopowerresearch.dashboard.bean.AbstractWidget;
import it.infopowerresearch.dashboard.bean.AlertWidget;
import it.infopowerresearch.dashboard.bean.ButtonWidget;
import it.infopowerresearch.dashboard.bean.ChartWidget;
import it.infopowerresearch.dashboard.bean.EditWidgetMetadata;
import it.infopowerresearch.dashboard.bean.SliderWidget;
import it.infopowerresearch.dashboard.bean.SwitchWidget;
import it.infopowerresearch.dashboard.bean.WidgetTemplate;
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
