package com.fcshop.study.dto;

import com.fcshop.study.entity.member.Member;
import lombok.Getter;

@Getter
public class ShoppingResponseDto {
    private String id;
    private String name;
    private String password;

    public ShoppingResponseDto(Member entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.password = entity.getPassword();
    }

}
