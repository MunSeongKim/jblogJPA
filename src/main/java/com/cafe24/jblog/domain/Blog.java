package com.cafe24.jblog.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="blog")
@Getter @Setter
@ToString
public class Blog {
    @Id
    private String id;
    
    @Column(name="title", nullable=false, length=50)
    private String title;
    
    @Column(name="img_path", nullable=false, length=100)
    private String imagePath;
    
    @MapsId // @Id 필드에 매핑되어 Id로 사용되게 하는 Annotation
    @OneToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name="member_id", unique=true)
    private Member member;
    
}
