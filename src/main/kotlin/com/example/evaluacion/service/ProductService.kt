package com.example.evaluacion.service


import com.example.evaluacion.model.ProductModel
import com.example.evaluacion.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import javax.transaction.Transactional
import javax.xml.bind.ValidationException

@Service
class ProductService {
    @Autowired
    lateinit var productRepository: ProductRepository

    @Transactional
    fun list(): List<ProductModel> {
        return productRepository.findAll()
    }

    @Transactional
    fun save(product: ProductModel): ProductModel {
        validateProduct(product)
        return productRepository.save(product)
    }

    @Transactional
    fun update(product: ProductModel):ProductModel {
        if (product.idp == null) {
            throw ValidationException("ID no proporcionada para actualizar")
        }
        validateProduct(product)
        return productRepository.save(product)
    }

    @Transactional
    fun updateDetails(product: ProductModel): ProductModel {
        if (product.idp == null) {
            throw ValidationException("ID no proporcionada para actualizar detalles")
        }
        // Actualizar detalles específicos del producto si es necesario
        // Puedes implementar la lógica según tus requisitos
        // Por ejemplo: product.stock = newStock
        return productRepository.save(product)
    }

    @Transactional
    fun listById(idp: Long): ProductModel {
        return (productRepository.findById(idp)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado")) as ProductModel
    }

    @Transactional
    fun delete(idp: Long) {
        val existingProduct = productRepository.findById(idp)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado") }

        productRepository.delete(existingProduct)
    }

    private fun validateProduct(product: ProductModel) {
        // Implementa las validaciones necesarias para el Product aquí
        // Por ejemplo: asegurarse de que los campos obligatorios no estén vacíos
        // if (product.desProduct.isNullOrBlank() || ...)
    }
}

