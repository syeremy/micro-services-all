package com.syeremy.demodockercompose.repository;

import com.syeremy.demodockercompose.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by syeremy on 5/25/17.
 */
public interface IPersonRepository extends JpaRepository<Person, String> {
}
