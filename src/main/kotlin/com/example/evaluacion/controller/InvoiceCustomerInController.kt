package com.example.evaluacion.controller

import com.example.evaluacion.model.InvoiceCustomerInfoModel
import com.example.evaluacion.service.InvoiceCustomerInService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoice_customer_info")
class InvoiceCustomerInfoController {
    @Autowired
    lateinit var invoiceCustomerInService: InvoiceCustomerInService

    @GetMapping
    fun list(invoiceCustomerInfoModel: InvoiceCustomerInfoModel, pageable: Pageable): ResponseEntity<*> {
       val response= invoiceCustomerInService.list(pageable,invoiceCustomerInfoModel)
        return ResponseEntity(response, HttpStatus.OK)

    }
    //@RequestParam searchValue:String
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<InvoiceCustomerInfoModel> {
        val item = invoiceCustomerInService.findById(id)
        return if (item != null) {
            ResponseEntity(item, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

}
