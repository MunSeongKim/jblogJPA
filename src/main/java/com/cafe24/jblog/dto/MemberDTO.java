package com.cafe24.jblog.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MemberDTO {
    private String id;
    private String name;
    private Date regDate;
}
