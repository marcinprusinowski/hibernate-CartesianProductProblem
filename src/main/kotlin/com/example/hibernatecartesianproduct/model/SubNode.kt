package com.example.hibernatecartesianproduct.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class SubNode(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "sub_node_id")
        var id: Long ?,
        var name: String,

        @ManyToOne
        @JsonIgnore
        @JoinColumn(
                name = "parent_node" ,
                referencedColumnName = "node_id",
                foreignKey = ForeignKey(name = "fk_parent_node")
        )
        var parentNode: Node ?
)