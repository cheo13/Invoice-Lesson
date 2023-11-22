package com.example.evaluacion.service


import com.example.evaluacion.model.InvoiceModel
import com.example.evaluacion.repository.InvoiceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import javax.transaction.Transactional
import javax.xml.bind.ValidationException


@Service
class InvoiceService {
    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    @Transactional
    fun list(): List<InvoiceModel> {
        return invoiceRepository.findAll()
    }

    @Transactional
    fun save(invoice: InvoiceModel): InvoiceModel {
        validateInvoice(invoice)
        return invoiceRepository.save(invoice)
    }

    @Transactional
    fun update(invoice: InvoiceModel): InvoiceModel {
        if (invoice.idn == null) {
            throw ValidationException("ID no proporcionada para actualizar")
        }
        validateInvoice(invoice)
        return invoiceRepository.save(invoice)
    }

    @Transactional
    fun updateDetails(invoice: InvoiceModel): InvoiceModel {
        if (invoice.idn == null) {
            throw ValidationException("ID no proporcionada para actualizar detalles")
        }
        // Actualizar detalles específicos del invoice si es necesario
        // Puedes implementar la lógica según tus requisitos
        // Por ejemplo: invoice.detail = invoiceDetails
        return invoiceRepository.save(invoice)
    }

    @Transactional
    fun listById(idn: Long):    InvoiceModel {
        return (invoiceRepository.findById(idn)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Invoice no encontrado")) as InvoiceModel
    }

    @Transactional
    fun delete(idn: Long) {
        val existingInvoice = invoiceRepository.findById(idn)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Invoice no encontrado") }

        invoiceRepository.delete(existingInvoice)
    }

    private fun validateInvoice(invoice: InvoiceModel) {
        // Implementa las validaciones necesarias para el Invoice aquí
        // Por ejemplo: asegurarse de que los campos obligatorios no estén vacíos
        // if (invoice.codInvoice.isNullOrBlank() || ...)
    }
}

