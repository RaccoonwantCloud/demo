package com.fcshop.study.dto;

import com.fcshop.study.entity.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShoppingRequestDto {
    private String id;
    private String name;
    private String password;

    public Member toEntity(){
        return Member.builder().id(id).name(name).password(password).build();
    }

    /*
    ID VARCHAR(200),
    NAME VARCHAR(200),
    PASSWORD VARCHAR(200),
*/

}
