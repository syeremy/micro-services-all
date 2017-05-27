package com.syeremy.demodockercompose.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by syeremy on 5/25/17.
 */
@Entity
@Table(name = "people")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(updatable = false)
    private String id;

    @Version
    private Long version;

    private String name;

    private String email;

//    public Long getVersion() {
//        return version;
//    }
//
//    public void setVersion(Long version) {
//        this.version = version;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
}
