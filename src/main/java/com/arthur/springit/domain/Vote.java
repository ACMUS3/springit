package com.arthur.springit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
@Data
@NoArgsConstructor
public class Vote {

    @Id
    @GeneratedValue
    private Long id;
   // private User user;
   // private Link link;
    private int vote;

}
