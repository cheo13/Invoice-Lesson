
-- VIEWS --

-- Vista para mostrar información detallada de la factura junto con el cliente y detalles del producto
CREATE VIEW invoice_detail_customer_product AS
    SELECT i.cod_invoice, c.ful_nam_client AS customer_name, d.qua_detail, d.pri_detail, p.des_product, p.bra_product
    FROM invoice i
    JOIN client c ON c.idc = i.idc_client
    JOIN detail d ON d.idn_invoice = i.idn
    JOIN product p ON p.idp = d.idp_product;

-- Vista para mostrar detalles de la factura junto con el nombre del cliente
CREATE VIEW invoice_customer_info AS
    SELECT i.*, c.ful_nam_client AS customer_name
    FROM invoice i
    JOIN client c ON c.idc = i.idc_client;
