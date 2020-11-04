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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.infopowerresearch.dashboard.bean.AlertWidget;
import it.infopowerresearch.dashboard.bean.ButtonWidget;
import it.infopowerresearch.dashboard.bean.ChartWidget;
import it.infopowerresearch.dashboard.bean.EditWidgetMetadata;
import it.infopowerresearch.dashboard.bean.SliderWidget;
import it.infopowerresearch.dashboard.bean.SwitchWidget;
import it.infopowerresearch.dashboard.bean.WidgetTemplate;
import it.infopowerresearch.dashboard.dao.AlertWidgetDAO;
import it.infopowerresearch.dashboard.dao.ButtonWidgetDAO;
import it.infopowerresearch.dashboard.dao.ChartWidgetDAO;
import it.infopowerresearch.dashboard.dao.EditWidgetMetadataDAO;
import it.infopowerresearch.dashboard.dao.SliderWidgetDAO;
import it.infopowerresearch.dashboard.dao.SwitchWidgetDAO;
import it.infopowerresearch.dashboard.dao.WidgetTemplateDAO;
import it.infopowerresearch.dashboard.data.Data;
import it.infopowerresearch.dashboard.managers.WidgetManager;

@Component
public class WidgetManagerImpl implements WidgetManager {

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
	public Set<AlertWidget> getAlertWidgets(long[] ids) {
		Set<AlertWidget> alerts = new HashSet<>();

		for (long id : ids) {
			AlertWidget a = alertWidgetDAO.findByTemplateId(id);
			alerts.add(a);
		}

		return alerts;
	}

	@Override
	public Set<ChartWidget> getChartWidgets(long[] ids) {
		Set<ChartWidget> charts = new HashSet<>();

		for (long id : ids) {
			ChartWidget c = chartWidgetDAO.findByTemplateId(id);
			charts.add(c);
		}

		return charts;
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
					if (template.getType().equals("alert")) {
						AlertWidget a = alertWidgetDAO.findByTemplateId(template.getId());
						if (a.getDataMode().equals("local")) {
							m = dataClass.getDeclaredMethod(a.getUrl());
							value = (List<Integer>) m.invoke(dataObject);
						}
					} else if (template.getType().equals("chart")) {
						ChartWidget c = chartWidgetDAO.findByTemplateId(template.getId());
						if (c.getDataMode().equals("local")) {
							m = dataClass.getDeclaredMethod(c.getUrl());
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
	public AlertWidget getAlertWidget(long templateId) {
		return alertWidgetDAO.findByTemplateId(templateId);
	}

	@Override
	public ButtonWidget getButtonWidget(long templateId) {
		return buttonWidgetDAO.findByTemplateId(templateId);
	}

	@Override
	public ChartWidget getChartWidget(long templateId) {
		return chartWidgetDAO.findByTemplateId(templateId);
	}

	@Override
	public SliderWidget getSliderWidget(long templateId) {
		return sliderWidgetDAO.findByTemplateId(templateId);
	}

	@Override
	public SwitchWidget getSwitchWidget(long templateId) {
		return switchWidgetDAO.findByTemplateId(templateId);
	}

	@Override
	public Set<WidgetTemplate> getAllWidgetTemplates() {
		return new HashSet<>((Collection<? extends WidgetTemplate>) widgetTemplateDAO.findAll());
	}

	@Override
	public List<EditWidgetMetadata> getAllEditWidgetMetadata() {
		return new ArrayList<>((Collection<? extends EditWidgetMetadata>) editWidgetMetadataDAO.findAll());
	}

}
