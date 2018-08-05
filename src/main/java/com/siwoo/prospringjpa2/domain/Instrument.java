package com.siwoo.prospringjpa2.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @ToString
public class Instrument {

    @Id @Column(name = "INSTRUMENT_ID")
    private String name;

    @ManyToMany
    @JoinTable(name = "SINGER_INSTRUMENT",
    joinColumns = @JoinColumn(name = "INSTRUMENT_ID"),
    inverseJoinColumns = @JoinColumn(name = "SINGER_ID"))
    private Set<Singer> singers = new HashSet<>();

}
