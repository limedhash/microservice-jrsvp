package com.sai.rsvpfe.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sai.commons.objects.AEventDetails;
import com.sai.commons.objects.AEventList;
import com.sai.rsvpfe.dto.EventDetailsDto;
import com.sai.rsvpfe.views.EventList;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventDetailServiceImpl implements EventDetailService {

    private String storeUrll = "http://localhost:8080/event/search?searchkey=*";

    public List<EventDetailsDto> getEvents() {

        List<EventDetailsDto> eventDetailsDtos = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(storeUrll, String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            AEventList eventList = mapper.readValue(response.getBody(), AEventList.class);
            eventList.getEventDetailsList().stream().forEach(a -> {
                EventDetailsDto edd = new EventDetailsDto();
                BeanUtils.copyProperties(a, edd);
                eventDetailsDtos.add(edd);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


        return eventDetailsDtos;
    }
}
