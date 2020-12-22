package com.example.hibernatecartesianproduct.service

import com.example.hibernatecartesianproduct.model.Fork
import com.example.hibernatecartesianproduct.model.Node
import com.example.hibernatecartesianproduct.model.SubNode
import com.example.hibernatecartesianproduct.repo.NodeRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class CrudNodeService(@Autowired val repo:NodeRepo) : NodeService {

    override fun add(node: Node): Node {
        return repo.save(node);
    }

    override fun get(id: Long): Node {
        return repo.findById(id).orElseThrow{ NoSuchElementException() }
    }


    @Transactional
    override fun addSubNode(parentId: Long, subNode: SubNode): Node {
        val parent: Node  = repo.findById(parentId).orElseThrow{ NoSuchElementException() }
        parent.addSubNode(subNode);
        return parent
    }

    @Transactional
    override fun addFork(parentId: Long,fork: Fork): Node {
        val parent: Node = repo.findById(parentId).orElseThrow{ NoSuchElementException() }
        parent.addFork(fork)
        return parent
    }

    override fun getAll(): Collection<Node> {
        return repo.findAll() as Collection<Node>
    }

}