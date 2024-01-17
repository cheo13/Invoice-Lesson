package com.example.evaluacion.repository

import com.example.evaluacion.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, String> {
    fun findByUsername(username: String): UserEntity?
}