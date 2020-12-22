package com.example.hibernatecartesianproduct.model

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.springframework.lang.Nullable
import javax.persistence.*


@Entity
class Node (
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "node_id")
        @Nullable
        var id: Long ? = null,
        var name: String,

        @OneToMany(mappedBy = "parentNode" , cascade = [CascadeType.PERSIST], fetch = FetchType.EAGER )
        @Fetch(FetchMode.SELECT)
        @Column(name = "parent_node")
        var nodes: MutableSet<SubNode>  = HashSet(),

        @OneToMany(mappedBy = "parentNode" , cascade = [CascadeType.PERSIST], fetch = FetchType.EAGER )
        @Fetch(FetchMode.SELECT)
        @Column(name = "parent_node")
        var forks: MutableSet<Fork> = HashSet()
)
{
        fun addSubNode(node:SubNode){
                this.nodes.add(node);
                node.parentNode = this
        }

        fun addFork(fork: Fork) {
                this.forks.add(fork)
                fork.parentNode=this
        }
}