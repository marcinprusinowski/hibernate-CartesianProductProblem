package com.example.hibernatecartesianproduct.repo

import com.example.hibernatecartesianproduct.model.Node
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface NodeRepo : CrudRepository<Node, Long> {

}