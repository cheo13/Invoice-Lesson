package com.example.evaluacion.repository


import com.example.evaluacion.model.InvoiceCustomerInfoModel

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface InvoiceCustomerInRepository : JpaRepository<InvoiceCustomerInfoModel, Long?> {
    fun findById(id: Long?): InvoiceCustomerInfoModel?
    // Otros métodos de consulta o personalizados si son necesarios
}