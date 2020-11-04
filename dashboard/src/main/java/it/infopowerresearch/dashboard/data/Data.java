package it.infopowerresearch.dashboard.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data {

	public List<Integer> getChartData() {
		List<Integer> data = new ArrayList<>();

		for (int i = 0; i < 10; i++)
			data.add(new Random().nextInt(100));

		return data;
	}

	public List<Integer> getAlertData() {
		List<Integer> data = new ArrayList<>();
		data.add(new Random().nextInt(60) + 40);
		return data;
	}

}
