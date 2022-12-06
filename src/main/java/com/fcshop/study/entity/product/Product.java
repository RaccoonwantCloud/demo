package com.fcshop.study.entity.product;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
public class Product {
    @Id
    private String pId;

    private String pName;

    private int pPrice;

    private String pDescription;

    private String pImageUrl;

    private String pOwner;
}
