package com.example.evaluacion.repository


import com.example.evaluacion.model.DetailModel
import com.example.evaluacion.model.InvoiceModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
@Autowired
lateinit var  invoiceRepository: InvoiceRepository

@Repository
interface DetailRepository : JpaRepository<DetailModel, Long?> {
    fun findById(idd: Long?): DetailModel?
    // Otros métodos de consulta o personalizados si son necesarios
 //   @Query(nativeQuery = true)
   // fun sumTotal(@Param("invoiceId") invoiceId: Long): Double

    fun findByInvoice_Idn (idnInvoice: Long?): List<DetailModel>



}