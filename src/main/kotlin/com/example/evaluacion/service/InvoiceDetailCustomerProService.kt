package com.example.evaluacion.service

import com.example.evaluacion.model.InvoiceDetailCustomerProductModel

import com.example.evaluacion.repository.InvoiceDetailCustomerProRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional;


@Service
class InvoiceDetailCustomerProService {
    @Autowired
    lateinit var invoiceDetailCustomerProRepository: InvoiceDetailCustomerProRepository

    @Transactional
    fun findAll(): List<InvoiceDetailCustomerProductModel> {
        return invoiceDetailCustomerProRepository.findAll()
    }

    @Transactional
    fun findById(codInvoice: Long): InvoiceDetailCustomerProductModel? {
        return invoiceDetailCustomerProRepository.findById(codInvoice).orElse(null)
    }

    fun list (pageable: Pageable,invoiceDetailCustomerProductModel: InvoiceDetailCustomerProductModel):Page<InvoiceDetailCustomerProductModel>{
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return invoiceDetailCustomerProRepository.findAll(Example.of(invoiceDetailCustomerProductModel, matcher), pageable)
    }
}


