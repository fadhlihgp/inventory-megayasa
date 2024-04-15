package com.megayasa.Backend.Models;

import com.megayasa.Backend.Annotations.Db.Column;
import com.megayasa.Backend.Annotations.Db.Id;
import com.megayasa.Backend.Annotations.Db.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Table(name = "login_information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInformation {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "role")
    private String role;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "expired_login")
    private LocalDateTime expiredLogin;
}
