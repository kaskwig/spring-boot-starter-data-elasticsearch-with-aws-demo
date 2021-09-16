package com.demo.aws.elasticsearch.data.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * PhotoDocument annotated with @{@link Document} where the @{@link Document#createIndex()} false prevents the spring data to
 * create and index during application boot
 */
@Data
@Document(indexName = "tmp-cmcustomersformatching-avro-v3", type = "_doc", createIndex = false)
public class PhotoDocument {
    @Id
    private String id;
    private Integer UserID;
//    private Integer ChannelID;
//    private String DateOfBirth;
//    private String EmailAddress;
//    private String Firstname;
//    private String Lastname;
//    private String Gender;
//    private Integer GenderID;
}
