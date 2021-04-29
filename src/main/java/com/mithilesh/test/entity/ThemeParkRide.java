package com.mithilesh.test.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class ThemeParkRide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    private int trillFactor;
    private int vomitFactor;

    public ThemeParkRide(String name, String desc, int trillFactor, int vomitFactor) {
        this.name = name;
        this.description = desc;
        this.trillFactor = trillFactor;
        this.vomitFactor = vomitFactor;
    }


}
