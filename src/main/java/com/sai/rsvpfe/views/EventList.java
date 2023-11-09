package com.sai.rsvpfe.views;

import com.sai.commons.objects.AEventList;
import com.sai.rsvpfe.dto.EventDetailsDto;
import com.sai.rsvpfe.service.EventDetailService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.PermitAll;

import java.util.List;

@Route("/events") // map view to the root
@AnonymousAllowed
public class EventList extends VerticalLayout {

    EventDetailService eventDetailService;
    Grid<EventDetailsDto> grid = new Grid<>(EventDetailsDto.class);
    TextField filterText = new TextField();

    public EventList(EventDetailService eventDetailService) {
        this.eventDetailService = eventDetailService;
        List<EventDetailsDto> events = eventDetailService.getEvents();
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        add(getToolbar(), grid);
        updateList();
    }

    private void configureGrid() {

        grid.addClassNames("event-grid");
        grid.setSizeFull();
        grid.setColumns("name", "description");
//        grid.addColumn(event -> event.getName()).setHeader("name");
//        grid.addColumn(event -> event.getDescription()).setHeader("description");

    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button addContactButton = new Button("Add Event");
        
        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void updateList() {
        grid.setItems(eventDetailService.getEvents());
    }
}
