package com.fawez.news.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@RequiredArgsConstructor
public class HealthController {
    @Data
    public String userInfos;

    /**
     * Returns the statusCode to measure the uptime of the BE service.
     * @return
     */
    @PostMapping(value = "/statusCheck")
    public String giveStatus200(){
        return HttpStatus.OK;
    }

    /**
     * Takes the userName and Role which should be passed as Headers as follows:
     * "userName": "FirstName|LastName" e.g. "userName": "John|Doe"
     * and
     * "userRole": "title" e.g. "userRole": "superUser"
     * and returns the lastName followed by the role.
     * //TODO: not working? commit anyways :P
     * @param userInfo
     * @return
     */
    @GetMapping(value = "/userInformation")
    public String giveHeaderInformation(@RequestHeader(value = "userName", required = false) String userInfo, @RequestHeader(value = "userRole") String role) {
        String[] parts = userInfo.split("|");
        String firstName = parts[0]; // FirstName
        String lastName = parts[1]; // LastName
        userInfos = lastName.concat("role");
        return userInfos;
    }
}
