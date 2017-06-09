package ua.room414.web.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ua.room414.dto.UserDto;
import ua.room414.facade.UserFacade;
import ua.room414.response.Response;
import ua.room414.response.ResponseType;
import ua.room414.user.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 02 Jun 2017
 */
@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://ws/namespace/service/user";

    private UserFacade userFacade;
    private ObjectFactory userObjectFactory = new ObjectFactory();
    private ua.room414.response.ObjectFactory responseObjectFactory = new ua.room414.response.ObjectFactory();

    @Autowired
    public UserEndpoint(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saveUserRequest")
    public SaveUserResponse save(@RequestPayload SaveUserRequest request) {
        SaveUserResponse saveUserResponse = userObjectFactory.createSaveUserResponse();
        UserDto response = userFacade.save(request.getObject());

        saveUserResponse.setObject(response);

        return saveUserResponse;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeUserRequest")
    public RemoveUserResponse remove(@RequestPayload RemoveUserRequest request) {
        RemoveUserResponse removeUserResponse = userObjectFactory.createRemoveUserResponse();

        userFacade.remove(request.getObject());

        Response response = responseObjectFactory.createResponse();
        response.setType(ResponseType.SUCCESS);
        removeUserResponse.setResponse(response);

        return removeUserResponse;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getByIdUserRequest")
    public GetByIdUserResponse getById(@RequestPayload GetByIdUserRequest request) {
        GetByIdUserResponse getByIdUserResponse = userObjectFactory.createGetByIdUserResponse();
        UserDto response = userFacade.getById(request.getId());

        getByIdUserResponse.setResult(response);

        return getByIdUserResponse;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUserRequest")
    public GetAllUserResponse getAll() {
        GetAllUserResponse getAllUserResponse = userObjectFactory.createGetAllUserResponse();
        UserList userList = userFacade.getAll();

        getAllUserResponse.setResult(userList);

        return getAllUserResponse;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByEmailResponse")
    public GetUserByEmailResponse getByEmail(GetUserByEmailRequest request) {
        GetUserByEmailResponse getUserByEmailResponse = userObjectFactory.createGetUserByEmailResponse();
        UserDto response = userFacade.getUserByEmail(request.getEmail());

        getUserByEmailResponse.setResult(response);

        return getUserByEmailResponse;
    }
}
