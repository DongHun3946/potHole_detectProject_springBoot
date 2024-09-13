package com.mysite.pothole_capstone.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateForm {
    @Size(min = 4, max = 15)
    @NotEmpty(message = "사용자 이름은 필수 항목입니다.")
    private String username;

    @NotEmpty(message = "사용자 아이디는 필수 항목입니다.")
    private String userID;

    @Size(min = 8, max = 16)
    @NotEmpty(message = "비밀번호는 필수 항목입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인란을 입력해주세요")
    private String password2;

    @NotEmpty(message = "이메일은 필수 항목입니다.")
    @Email
    private String email;

}
