package com.example.evaluacion.model

import javax.persistence.*

@Entity
@Table(name = "invoice_detail_product_info") // Nombre de la vista
class InvoiceDetailProductInfoModel {
    // Mapeo de los campos de la vista
    @Id
    @Column(name = "idd")
    var idd: Long? = null

    @Column(name = "qua_detail")
    var quaDetail: Int? = null

    @Column(name = "pri_detail")
    var priDetail: Double? = null

    @Column(name = "idn_invoice")
    var idnInvoice: Long? = null

    @Column(name = "idp_product")
    var idpProduct: Long? = null

    @Column(name = "cod_invoice")
    var codInvoice: String? = null

    @Column(name = "des_product")
    var desProduct: String? = null

    @Column(name = "pri_product")
    var priProduct: Double? = null
}