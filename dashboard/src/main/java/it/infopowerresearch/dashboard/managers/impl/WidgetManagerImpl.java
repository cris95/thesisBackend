package it.infopowerresearch.dashboard.managers.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.infopowerresearch.dashboard.beans.AbstractWidget;
import it.infopowerresearch.dashboard.beans.AlertWidget;
import it.infopowerresearch.dashboard.beans.ButtonWidget;
import it.infopowerresearch.dashboard.beans.ChartWidget;
import it.infopowerresearch.dashboard.beans.EditWidgetMetadata;
import it.infopowerresearch.dashboard.beans.SliderWidget;
import it.infopowerresearch.dashboard.beans.SwitchWidget;
import it.infopowerresearch.dashboard.beans.Widget;
import it.infopowerresearch.dashboard.beans.WidgetTemplate;
import it.infopowerresearch.dashboard.dao.AlertWidgetDAO;
import it.infopowerresearch.dashboard.dao.ButtonWidgetDAO;
import it.infopowerresearch.dashboard.dao.ChartWidgetDAO;
import it.infopowerresearch.dashboard.dao.EditWidgetMetadataDAO;
import it.infopowerresearch.dashboard.dao.SliderWidgetDAO;
import it.infopowerresearch.dashboard.dao.SwitchWidgetDAO;
import it.infopowerresearch.dashboard.dao.WidgetDAO;
import it.infopowerresearch.dashboard.dao.WidgetTemplateDAO;
import it.infopowerresearch.dashboard.data.Data;
import it.infopowerresearch.dashboard.dto.AbstractWidgetDTO;
import it.infopowerresearch.dashboard.managers.WidgetManager;

@Component
public class WidgetManagerImpl implements WidgetManager {

	private static final String ALERT = "alert";
	private static final String BUTTON = "button";
	private static final String CHART = "chart";
	private static final String SLIDER = "slider";
	private static final String SWITCH = "switch";

	@Autowired
	private WidgetDAO widgetDAO;

	@Autowired
	private AlertWidgetDAO alertWidgetDAO;

	@Autowired
	private ButtonWidgetDAO buttonWidgetDAO;

	@Autowired
	private SwitchWidgetDAO switchWidgetDAO;

	@Autowired
	private ChartWidgetDAO chartWidgetDAO;

	@Autowired
	private SliderWidgetDAO sliderWidgetDAO;

	@Autowired
	private WidgetTemplateDAO widgetTemplateDAO;

	@Autowired
	private EditWidgetMetadataDAO editWidgetMetadataDAO;

	@Override
	public int buildPushNotification(String title, String body, String value) throws IOException {
//		URL url = new URL("https://fcm.googleapis.com/fcm/send");
//
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//		connection.setRequestMethod("POST");
//
//		connection.setRequestProperty("Authorization",
//				"key=AAAAhw6L60o:APA91bEPjIDLE-ue3QiRLDJND2dEd5wSQcbc6Ks_mT9FO1mQ6mN1Pkcx9tZkkp8R_LxJ5vzHnWjAM8C2YuDhrQwmdhDbYh05u2rZCx0K85lW3lV9phFa_Y0iTdptB_1IOJbJb8ngxXHF");
//		connection.setRequestProperty("Content-Type", "application/json");
//		connection.setRequestProperty("Accept", "application/json");
//
//		connection.setConnectTimeout(5000);
//		connection.setReadTimeout(5000);
//
//		JSONObject httpBody = new JSONObject();
//
//		JSONObject notification = new JSONObject();
//		notification.put("title", title);
//		notification.put("body", body);
//
//		JSONObject data = new JSONObject();
//		data.put("value", value);
//
//		httpBody.put("notification", notification);
//		httpBody.put("to",
//				"e2MD1JFxcjYgKM_Breyi1E:APA91bGHH1SHgXzyQa95LlZfp9gVR0kSKatZwy-FvZ4relwb28MzP3tBGkwZJZOawMSWvtKdnKrA6Mo6BeWPD8VdSxrhtm-udLZCPS9225oTPf8Vyw4d2XxxbkmEq_MvbSEdeUiHFG18");
//		httpBody.put("data", data);
//
//		connection.setUseCaches(false);
//		connection.setDoInput(true);
//		connection.setDoOutput(true);
//
//		byte[] outputInBytes = httpBody.toString().getBytes(StandardCharsets.UTF_8);
//		OutputStream os = connection.getOutputStream();
//		os.write(outputInBytes);
//		os.close();
//
//		return connection.getResponseCode();
		return 0;
	}

	@Override
	public int switchValue(long id, boolean value) {
//		SwitchWidget b = switchWidgetDAO.findByTemplateId(id);
		try {
			// call or whatever
		} catch (Exception e) {
			return (value) ? 0 : 1;
		}

		return (value) ? 1 : 0;
	}

	@Override
	public int changeSliderValue(long id, int value) {
		Optional<SliderWidget> optSlider = sliderWidgetDAO.findById(id);
		if (optSlider.isPresent()) {
			SliderWidget slider = optSlider.get();
			// call or whatever
			try {
				slider.setValue(value);
				sliderWidgetDAO.save(slider);
				return value;
			} catch (Exception e) {
				return slider.getValue();
			}
		}
		return value;
	}

	@Override
	public int clickButtonWidget(long id) {
		return 0;
	}

	@Override
	public Set<AbstractWidget> getWidgets(long[] ids) {
		Set<AbstractWidget> widgets = new HashSet<>();

		for (long id : ids) {
			AbstractWidget w = new AbstractWidget();

			Optional<WidgetTemplate> optTemplate = widgetTemplateDAO.findById(id);
			if (optTemplate.isPresent()) {
				WidgetTemplate template = optTemplate.get();
				switch (template.getType()) {
				case ALERT:
					w = alertWidgetDAO.findByTemplateId(id);
					break;
				case BUTTON:
					w = buttonWidgetDAO.findByTemplateId(id);
					break;
				case CHART:
					w = chartWidgetDAO.findByTemplateId(id);
					break;
				case SLIDER:
					w = sliderWidgetDAO.findByTemplateId(id);
					break;
				case SWITCH:
					w = switchWidgetDAO.findByTemplateId(id);
					break;
				default:
					break;
				}
				widgets.add(w);
			}
		}

		return widgets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Long, List<Integer>> getWidgetsData(long[] ids) {
		try {
			Map<Long, List<Integer>> data = new HashMap<>();
			Class<Data> dataClass = Data.class;
			Object dataObject = dataClass.getDeclaredConstructor().newInstance();
			Method m;
			for (long id : ids) {
				Optional<WidgetTemplate> optTemplate = widgetTemplateDAO.findById(id);
				if (optTemplate.isPresent()) {
					WidgetTemplate template = optTemplate.get();
					List<Integer> value = new ArrayList<>();
					if (template.getType().equals(ALERT)) {
						AlertWidget a = alertWidgetDAO.findByTemplateId(template.getId());
						if (template.getDataMode().equals("local")) {
							m = dataClass.getDeclaredMethod(template.getUrl());
							value = (List<Integer>) m.invoke(dataObject);
						}
					} else if (template.getType().equals(CHART)) {
						ChartWidget c = chartWidgetDAO.findByTemplateId(template.getId());
						if (template.getDataMode().equals("local")) {
							m = dataClass.getDeclaredMethod(template.getUrl());
							value = (List<Integer>) m.invoke(dataObject);
						}
					}
					data.put(template.getId(), value);
				}
			}
			return data;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AbstractWidget getWidget(long templateId, String type) {
		switch (type) {
		case ALERT:
			return alertWidgetDAO.findByTemplateId(templateId);
		case BUTTON:
			return buttonWidgetDAO.findByTemplateId(templateId);
		case CHART:
			return chartWidgetDAO.findByTemplateId(templateId);
		case SLIDER:
			return sliderWidgetDAO.findByTemplateId(templateId);
		case SWITCH:
			return switchWidgetDAO.findByTemplateId(templateId);
		default:
			break;
		}
		return null;
	}

	@Override
	public Set<WidgetTemplate> getAllWidgetTemplates() {
		return new HashSet<>((Collection<? extends WidgetTemplate>) widgetTemplateDAO.findAll());
	}

	@Override
	public List<EditWidgetMetadata> getAllEditWidgetMetadata() {
		return new ArrayList<>((Collection<? extends EditWidgetMetadata>) editWidgetMetadataDAO.findAll());
	}

	@Override
	public boolean saveWidget(AbstractWidgetDTO widget) {
		try {

			widget.setTemplate(widgetTemplateDAO.save(widget.getTemplate()));

			Widget w = widgetDAO.findByTemplateId(widget.getTemplate().getId());
			if (w != null) {
				w.setRows(widget.getTemplate().getRows());
				w.setCols(widget.getTemplate().getCols());
				widgetDAO.save(w);
			}

			switch (widget.getTemplate().getType()) {
			case ALERT:
				AlertWidget a = new AlertWidget();
				a.setId(widget.getId());
				a.setTemplate(widget.getTemplate());
				a.setRefreshTime(widget.getRefreshTime());
				a.setLow(widget.getLow());
				a.setHigh(widget.getHigh());
				alertWidgetDAO.save(a);
				return true;
			case BUTTON:
				ButtonWidget b = new ButtonWidget();
				b.setId(widget.getId());
				b.setTemplate(widget.getTemplate());
				buttonWidgetDAO.save(b);
				return true;
			case CHART:
				ChartWidget c = new ChartWidget();
				c.setId(widget.getId());
				c.setTemplate(widget.getTemplate());
				c.setChartType(widget.getChartType());
				c.setRefreshTime(widget.getRefreshTime());
				chartWidgetDAO.save(c);
				return true;
			case SLIDER:
				SliderWidget s = new SliderWidget();
				s.setId(widget.getId());
				s.setTemplate(widget.getTemplate());
				s.setMin(widget.getMin());
				s.setMax(widget.getMax());
				sliderWidgetDAO.save(s);
				return true;
			case SWITCH:
				SwitchWidget sw = new SwitchWidget();
				sw.setId(widget.getId());
				sw.setTemplate(widget.getTemplate());
				switchWidgetDAO.save(sw);
				return true;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteWidget(long templateId) {
		try {
			Optional<WidgetTemplate> optTemplate = widgetTemplateDAO.findById(templateId);
			if (optTemplate.isPresent()) {
				WidgetTemplate template = optTemplate.get();

				widgetDAO.deleteByTemplateId(templateId);

				switch (template.getType()) {
				case ALERT:
					alertWidgetDAO.deleteByTemplateId(templateId);
					break;
				case BUTTON:
					buttonWidgetDAO.deleteByTemplateId(templateId);
					break;
				case CHART:
					chartWidgetDAO.deleteByTemplateId(templateId);
					break;
				case SLIDER:
					sliderWidgetDAO.deleteByTemplateId(templateId);
					break;
				case SWITCH:
					switchWidgetDAO.deleteByTemplateId(templateId);
					break;
				default:
					break;
				}
				widgetTemplateDAO.deleteById(templateId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
