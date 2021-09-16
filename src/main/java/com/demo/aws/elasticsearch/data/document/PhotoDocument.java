package com.demo.aws.elasticsearch.data.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * PhotoDocument annotated with @{@link Document} where the @{@link Document#createIndex()} false prevents the spring data to
 * create and index during application boot
 */
@Data
@Document(indexName = "customer-data-for-matching-ohio-v3", type = "_doc", createIndex = false)
public class PhotoDocument {
    @Id
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
