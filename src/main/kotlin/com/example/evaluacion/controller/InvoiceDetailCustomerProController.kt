package com.example.evaluacion.controller

import com.example.evaluacion.model.InvoiceDetailCustomerProductModel
import com.example.evaluacion.service.InvoiceDetailCustomerProService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoice_detail_customer_product")
class InvoiceDetailCustomerProductController {
    @Autowired
    lateinit var invoiceDetailCustomerProService: InvoiceDetailCustomerProService

    @GetMapping
    fun list (invoiceDetailCustomerProductModel: InvoiceDetailCustomerProductModel, pageable: Pageable):ResponseEntity<*>{
        val response= invoiceDetailCustomerProService.list(pageable,invoiceDetailCustomerProductModel)
        return ResponseEntity(response, HttpStatus.OK)
    }

//@RequestParam searchValue:String

    @GetMapping("/{cod_invoice}")
    fun getById(@PathVariable cod_invoice: Long): ResponseEntity<InvoiceDetailCustomerProductModel> {
        val item = invoiceDetailCustomerProService.findById(cod_invoice)
        return if (item != null) {
            ResponseEntity(item, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

}