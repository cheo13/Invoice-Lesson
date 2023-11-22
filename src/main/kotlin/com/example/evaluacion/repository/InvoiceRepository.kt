package com.example.evaluacion.repository


import com.example.evaluacion.model.InvoiceModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository : JpaRepository<InvoiceModel, Long?> {
    fun findById(idn: Long?):   InvoiceModel?
    // Otros métodos de consulta o personalizados si son necesarios
}