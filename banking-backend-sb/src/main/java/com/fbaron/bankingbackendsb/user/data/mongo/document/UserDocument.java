package com.fbaron.bankingbackendsb.user.data.mongo.document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDocument {
    @Id
    private String id;
    private String username;
    private String password;

    @Version
    private long version;

    //In mongodb without this version we can't update any document
}
