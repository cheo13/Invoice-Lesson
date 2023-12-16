package com.example.evaluacion.controller

import ch.qos.logback.core.net.server.Client
import com.example.evaluacion.model.ClientModel
import com.example.evaluacion.service.ClientService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController   //Define una responsabilidad a un componente
@RequestMapping("/client")   //endpoint
class ClientController {
    @Autowired
    lateinit var clientService: ClientService

    @GetMapping
    fun list(): List<ClientModel> {
        return clientService.list()
    }

    @PostMapping
    fun save(@RequestBody @Valid client: ClientModel): ResponseEntity<ClientModel> {
        return ResponseEntity(clientService.save(client), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody client: ClientModel): ResponseEntity<ClientModel> {
        return ResponseEntity(clientService.update(client), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody client: ClientModel): ResponseEntity<ClientModel> {
        return ResponseEntity(clientService.updateName(client), HttpStatus.OK)
    }

    @GetMapping("/{idc}")
    fun listById(@PathVariable("idc") idc: Long): ResponseEntity<*> {
        return ResponseEntity(clientService.listById(idc), HttpStatus.OK)
    }


    @DeleteMapping("/delete/{idc}")
    fun delete(@PathVariable("idc") idc: Long): Boolean? {
        clientService.delete(idc)
        return true
    }
}


