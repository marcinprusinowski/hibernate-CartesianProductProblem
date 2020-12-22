package com.example.hibernatecartesianproduct.controller

import com.example.hibernatecartesianproduct.model.Fork
import com.example.hibernatecartesianproduct.model.Node
import com.example.hibernatecartesianproduct.model.SubNode
import com.example.hibernatecartesianproduct.repo.NodeRepo
import com.example.hibernatecartesianproduct.service.CrudNodeService
import org.hibernate.annotations.Parent
import org.springframework.web.bind.annotation.*


@RestController
class NodeController(val service: CrudNodeService, val repo: NodeRepo) {

    @GetMapping("/nodes")
    fun getAll(): Collection<Node> {
        return service.getAll()
    }

    @GetMapping("/nodes/{nodeId}")
    fun get(@PathVariable nodeId: Long): Node{
        return service.get(nodeId)
    }
    @PostMapping("/nodes")
    fun add(@RequestBody node: Node): Node{
        return service.add(node)
    }
    @PostMapping("/nodes/{parentId}/forks")
    fun addFork(@PathVariable parentId: Long ,
                @RequestBody fork: Fork): Node{
        return service.addFork(parentId, fork)
    }

    @PostMapping("/nodes/{parentId}/subNodes")
    fun addSubNode(@PathVariable parentId: Long,
                   @RequestBody subNode: SubNode): Node{
        return service.addSubNode(parentId , subNode)
    }

}