package com.example.evaluacion.repository


import com.example.evaluacion.model.ClientModel

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ClientRepository : JpaRepository<ClientModel, Long?> {
    fun findById(idc: Long?): ClientModel?
    // Otros métodos de consulta o personalizados si son necesarios
}