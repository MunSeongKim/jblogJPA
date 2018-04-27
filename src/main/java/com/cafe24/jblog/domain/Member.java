package com.cafe24.jblog.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="member")
@Getter
@Setter
@ToString
public class Member {

    @Id
    @Column(name="member_id")
    private String id;
    
    @Column(name="name", nullable=false, length=10)
    private String name;
    
    @Column(name="password", nullable=false, length=128)
    private String password;
    
    @Temporal(value=TemporalType.DATE)
    @Column(name="reg_date", nullable=false)
    private Date regDate;
}
