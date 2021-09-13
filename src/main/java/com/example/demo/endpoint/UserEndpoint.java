package com.example.demo.endpoint;

import com.example.demo.service.UserService;
import com.test.soaptest.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class UserEndpoint {
    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = "http://test.com/soaptest",
            localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUser(request.getName()));
        return response;
    }

    @PayloadRoot(namespace = "http://test.com/soaptest",
            localPart = "addUserRequest")
    @ResponsePayload
    public AddUserResponse addUserResponse(@RequestPayload AddUserRequest request) {
        AddUserResponse response = new AddUserResponse();
        userService.addUser(request.getUser());
        response.setUser(request.getUser());
        return response;
    }
    @PayloadRoot(namespace = "http://test.com/soaptest",
            localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUserResponse(@RequestPayload UpdateUserRequest request) {
        User user = request.getUser();
        UpdateUserResponse response = new UpdateUserResponse();
        User newUser = userService.updateUser(user);
        response.setUser(newUser);
        return response;
    }
    @PayloadRoot(namespace = "http://test.com/soaptest",
            localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUserResponse(@RequestPayload DeleteUserRequest  request) {
        String user = request.getName();
        DeleteUserResponse response = new DeleteUserResponse();
        User newUser = userService.deleteUser(user);
        response.setUser(newUser);
        return response;
    }
}
