package it.infopowerresearch.dashboard.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class WebSocketController {

	@Autowired
	private SimpMessagingTemplate template;

	@PostMapping("/notify")
	public String getNotification(final HttpEntity<Map<Integer, List<Integer>>> body) {

		Map<Integer, List<Integer>> data = body.getBody();
		
		// Push notifications to front-end
		template.convertAndSend("/message", data);

		return "Notifications successfully sent to Angular !";
	}

}
