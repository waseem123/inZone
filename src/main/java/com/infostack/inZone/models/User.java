package com.infostack.inZone.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;
    String userFullName;
    String userEmail;
    String userPassword;
    String userMobile;
    String userDesignation;
    boolean userActive;
    String userPhotoUrl;
}
