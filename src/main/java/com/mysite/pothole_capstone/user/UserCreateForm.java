package com.mysite.pothole_capstone.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateForm {

    @NotEmpty
    private String username;

    @NotEmpty
    private String userID;

    @Size(min = 8, max = 16)
    @Pattern(regexp="^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=]).*$", message="비밀번호는 영문, 숫자, 특수문자를 각각 포함해야 합니다.")
    @NotEmpty
    private String password1;

    @NotEmpty
    private String password2;

    @NotEmpty
    @Email
    private String email;

}
