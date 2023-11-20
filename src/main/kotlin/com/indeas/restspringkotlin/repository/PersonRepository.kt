package com.indeas.restspringkotlin.repository

import com.indeas.restspringkotlin.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Long?> {

}