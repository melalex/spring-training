package ua.room414.web.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ua.room414.dto.EventDto;
import ua.room414.event.*;
import ua.room414.facade.EventFacade;
import ua.room414.response.Response;
import ua.room414.response.ResponseType;

/**
 * @author Alexander Melashchenko
 * @version 1.0 02 Jun 2017
 */
@Endpoint
public class EventEndpoint {
    private static final String NAMESPACE_URI = "http://ws/namespace/service/event";

    private EventFacade eventFacade;
    private ObjectFactory eventObjectFactory = new ObjectFactory();
    private ua.room414.response.ObjectFactory responseObjectFactory = new ua.room414.response.ObjectFactory();

    @Autowired
    public EventEndpoint(EventFacade eventFacade) {
        this.eventFacade = eventFacade;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveEventRequest")
    public SaveEventResponse save(@RequestPayload SaveEventRequest request) {
        SaveEventResponse saveEventResponse = eventObjectFactory.createSaveEventResponse();
        EventDto response = eventFacade.save(request.getObject());

        saveEventResponse.setObject(response);

        return saveEventResponse;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeEventRequest")
    public RemoveEventResponse remove(@RequestPayload RemoveEventRequest request) {
        RemoveEventResponse removeEventResponse = eventObjectFactory.createRemoveEventResponse();

        eventFacade.remove(request.getObject());

        Response response = responseObjectFactory.createResponse();
        response.setType(ResponseType.SUCCESS);
        removeEventResponse.setResponse(response);

        return removeEventResponse;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getByIdEventRequest")
    public GetByIdEventResponse getById(@RequestPayload GetByIdEventRequest request) {
        GetByIdEventResponse getByIdEventResponse = eventObjectFactory.createGetByIdEventResponse();
        EventDto response = eventFacade.getById(request.getId());

        getByIdEventResponse.setResult(response);

        return getByIdEventResponse;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEventRequest")
    public GetAllEventResponse getAll() {
        GetAllEventResponse getAllEventResponse = eventObjectFactory.createGetAllEventResponse();
        EventList eventList = eventFacade.getAll();

        getAllEventResponse.setResult(eventList);

        return getAllEventResponse;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEventByNameRequest")
    public GetEventByNameResponse getEventByName(@RequestPayload GetEventByNameRequest request) {
        GetEventByNameResponse getByIdEventResponse = eventObjectFactory.createGetEventByNameResponse();
        EventDto response = eventFacade.getByName(request.getName());

        getByIdEventResponse.setResult(response);

        return getByIdEventResponse;
    }
}
