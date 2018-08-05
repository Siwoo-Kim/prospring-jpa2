package com.siwoo.prospringjpa2.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @ToString(exclude = {"albums", "instruments"})
@NamedQueries({
        @NamedQuery(name = Singer.FIND_ALL,
                query = "select s from Singer s"),
        @NamedQuery(name = Singer.FIND_ALL_FETCHED,
                query = "select distinct s from Singer s " +
                        "left join fetch s.albums a " +
                        "left join fetch s.instruments i "),
        @NamedQuery(name = Singer.FIND_BY_ID,
                query = "select distinct s from Singer s " +
                        "left join fetch s.albums a " +
                        "left join fetch s.instruments i " +
                        "where s.id = :id ")})
public class Singer {
    public static final String FIND_ALL = "Singer.findAll";
    public static final String FIND_ALL_FETCHED = "Singer.findAllFetched";
    public static final String FIND_BY_ID = "Singer.findById";


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Version
    private int version;

    @OneToMany(mappedBy = "singer",
    orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Album> albums = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "singer_instrument",
    joinColumns = @JoinColumn(name = "SINGER_ID"),
    inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
    private Set<Instrument> instruments = new HashSet<>();
}
