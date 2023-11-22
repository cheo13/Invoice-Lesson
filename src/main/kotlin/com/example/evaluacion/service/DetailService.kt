package com.example.evaluacion.service



import com.example.evaluacion.model.DetailModel
import com.example.evaluacion.repository.DetailRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import javax.transaction.Transactional
import javax.xml.bind.ValidationException

@Service
class DetailService {
    @Autowired
    lateinit var detailRepository: DetailRepository

    @Transactional
    fun list(): List<DetailModel> {
        return detailRepository.findAll()
    }

    @Transactional
    fun save(detail: DetailModel): DetailModel {
        validateDetail(detail)
        return detailRepository.save(detail)
    }

    @Transactional
    fun update(detail: DetailModel): DetailModel {
        if (detail.idd == null) {
            throw ValidationException("ID no proporcionada para actualizar")
        }
        validateDetail(detail)
        return detailRepository.save(detail)
    }

    @Transactional
    fun updateDetails(detail: DetailModel): DetailModel {
        if (detail.idd == null) {
            throw ValidationException("ID no proporcionada para actualizar detalles")
        }
        // Actualizar detalles específicos del detail si es necesario
        // Puedes implementar la lógica según tus requisitos
        // Por ejemplo: detail.qualification = newQualification
        return detailRepository.save(detail)
    }

    @Transactional
    fun listById(idd: Long): DetailModel {
        return (detailRepository.findById(idd)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Detalle no encontrado")) as DetailModel
    }

    @Transactional
    fun delete(idd: Long) {
        val existingDetail = detailRepository.findById(idd)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Invoice no encontrado") }

        detailRepository.delete(existingDetail)
    }


    private fun validateDetail(detail: DetailModel) {
        // Implementa las validaciones necesarias para el Detail aquí
        // Por ejemplo: asegurarse de que los campos obligatorios no estén vacíos
        // if (detail.quantity == null || ...)
    }
}

