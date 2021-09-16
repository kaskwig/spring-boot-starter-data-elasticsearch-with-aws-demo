package com.demo.aws.elasticsearch.data.model;

import lombok.Data;

@Data
public class PhotoDto {
    private String id;
    private Integer userId;
    private Integer channelId;
    private String dateOfBirth;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer genderID;
    private String address1;
    private String address2;
    private String city;
    private String postalCode;
    private Integer stateId;
}
