package com.example.evaluacion.service

import com.example.evaluacion.model.ClientModel
import com.example.evaluacion.model.InvoiceCustomerInfoModel
import com.example.evaluacion.model.InvoiceDetailCustomerProductModel
import com.example.evaluacion.model.InvoiceDetailProductInfoModel

import com.example.evaluacion.repository.ClientRepository
import com.example.evaluacion.repository.InvoiceCustomerInRepository
import com.example.evaluacion.repository.InvoiceDetailCustomerProRepository
import com.example.evaluacion.repository.InvoiceDetailProInfoRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import javax.transaction.Transactional
import javax.xml.bind.ValidationException
import kotlin.math.asin

@Service
class InvoiceCustomerInService {
    @Autowired
    lateinit var invoiceCustomerInRepository: InvoiceCustomerInRepository

    fun findById(idc: Long): ClientModel? {
        return invoiceCustomerInRepository.findById(idc).orElse(null)
    }

    fun findAll(): List<ClientModel> {
        return invoiceCustomerInRepository.findAll()
    }
}

