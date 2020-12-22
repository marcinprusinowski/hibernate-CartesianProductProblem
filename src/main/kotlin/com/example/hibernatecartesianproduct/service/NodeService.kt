package com.example.hibernatecartesianproduct.service

import com.example.hibernatecartesianproduct.model.Fork
import com.example.hibernatecartesianproduct.model.Node
import com.example.hibernatecartesianproduct.model.SubNode

interface NodeService {
   fun add(node: Node): Node
   fun get(id: Long) :Node
   fun addSubNode(parentId: Long, subNode: SubNode) :Node
   fun getAll() : Collection<Node>
   fun addFork(parentId: Long,fork: Fork): Node
}