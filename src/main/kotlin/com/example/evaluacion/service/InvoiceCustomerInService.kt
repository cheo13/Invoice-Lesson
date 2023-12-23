package com.example.evaluacion.service

import com.example.evaluacion.model.InvoiceCustomerInfoModel

import com.example.evaluacion.repository.InvoiceCustomerInRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class InvoiceCustomerInService {
    @Autowired
    lateinit var invoiceCustomerInRepository: InvoiceCustomerInRepository

    @Transactional
    fun findById(id: Long): InvoiceCustomerInfoModel? {
        // Implementa la lógica para convertir un ClientModel a un InvoiceCustomerInfoModel si es necesario
        val clientModel = invoiceCustomerInRepository.findById(id).orElse(null)
        // Lógica de conversión o adaptación de ClientModel a InvoiceCustomerInfoModel
        // Por ejemplo: InvoiceCustomerInfoModel(clientModel.id, clientModel.name, ...)
        return null // Debes convertir clientModel a InvoiceCustomerInfoModel y retornarlo aquí
    }

    @Transactional
    fun findAll(): List<InvoiceCustomerInfoModel> {
        // Implementa la lógica para convertir una lista de ClientModel a una lista de InvoiceCustomerInfoModel
        val clientModels = invoiceCustomerInRepository.findAll()
        // Lógica de conversión o adaptación de cada ClientMo000000000000000000000000000000000000000000000000000000000000000000000del a InvoiceCustomerInfoModel
        // Por ejemplo: clientModels.map { InvoiceCustomerInfoModel(it.id, it.name, ...) }
        return emptyList() // Debes convertir clientModels a List<InvoiceCustomerInfoModel> y retornarlo aquí
    }

    fun list (pageable: Pageable,invoiceCustomerInfoModel: InvoiceCustomerInfoModel):Page<InvoiceCustomerInfoModel>{
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return invoiceCustomerInRepository.findAll(Example.of(invoiceCustomerInfoModel, matcher), pageable)
    }

}

