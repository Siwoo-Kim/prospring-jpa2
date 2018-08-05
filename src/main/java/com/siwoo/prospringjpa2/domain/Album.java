package com.siwoo.prospringjpa2.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter @ToString
public class Album {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "SINGER_ID")
    private Singer singer;
    private String title;
    @Column(name = "RELEASE_DATE")
    private Date releaseDate;
    @Version
    private int version;
}
