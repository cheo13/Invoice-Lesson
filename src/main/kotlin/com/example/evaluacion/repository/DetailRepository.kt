package com.example.evaluacion.repository


import com.example.evaluacion.model.DetailModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DetailRepository : JpaRepository<DetailModel, Long?> {
    fun findById(idd: Long?): DetailModel?
    // Otros métodos de consulta o personalizados si son necesarios
}