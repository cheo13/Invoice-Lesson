package com.example.evaluacion.service

import com.example.evaluacion.model.ClientModel

import com.example.evaluacion.repository.ClientRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import javax.transaction.Transactional
import javax.xml.bind.ValidationException
import kotlin.math.asin

@Service
class ClientService {
    @Autowired
    lateinit var clientRepository: ClientRepository

    @Transactional
    fun list(): List<ClientModel> {
        return clientRepository.findAll()
    }

    @Transactional
    fun save(client: ClientModel): ClientModel {
        validateClient(client)
        return clientRepository.save(client)
    }

    @Transactional
    fun update(client: ClientModel): ClientModel {
        if (client.idc == null) {
            throw ValidationException("ID no proporcionada para actualizar")
        }
        validateClient(client)
        return clientRepository.save(client)
    }

    @Transactional
    fun updateName(client: ClientModel): ClientModel {
        if (client.idc == null) {
            throw ValidationException("ID no proporcionada para actualizar el nombre")
        }
        val existingClientOptional = clientRepository.findById(client.idc!!)
        val existingClient = existingClientOptional.orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado")
        }

        existingClient.fulNamClient = client.fulNamClient // Actualizar solo el nombre

        return clientRepository.save(existingClient)
    }

    @Transactional
    fun listById(idc: Long): ClientModel {
        return (clientRepository.findById(idc)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado")) as ClientModel
    }

    @Transactional
    fun delete(idc: Long) {
        val existingClient = clientRepository.findById(idc)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Invoice no encontrado") }

        clientRepository.delete(existingClient)
    }


    private fun validateClient(client: ClientModel) {
        // Realizar validaciones sobre el cliente aquí
        // Por ejemplo: asegurarse de que los campos obligatorios no estén vacíos
        if (client.nuiClient.isNullOrBlank() || client.fulNamClient.isNullOrBlank() || client.addressClient.isNullOrBlank()) {
            throw ValidationException("Campos obligatorios no pueden estar vacíos")
        }
    }
}

