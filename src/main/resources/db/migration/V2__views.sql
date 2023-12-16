
-- Creación o actualización de la tabla Product
CREATE TABLE IF NOT EXISTS product (
    idp SERIAL,
    des_product VARCHAR(100) NOT NULL,
    bra_product VARCHAR(50) NOT NULL,
    pri_product DECIMAL(10, 2) NOT NULL,
    stock_product INT NOT NULL,
    PRIMARY KEY (idp)
);

-- Creación o actualización de la tabla Client
CREATE TABLE IF NOT EXISTS client (
    idc SERIAL,
    nui_client VARCHAR(50) UNIQUE NOT NULL,
    ful_nam_client VARCHAR(100) NOT NULL,
    address_client VARCHAR(150) NOT NULL,
    PRIMARY KEY (idc)
);

-- Creación o actualización de la tabla Invoice
CREATE TABLE IF NOT EXISTS invoice (
    idn SERIAL,
    cod_invoice VARCHAR(10) UNIQUE NOT NULL,
    cre_at_invoice TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    tot_invoice DECIMAL(10, 2) NOT NULL,
    idc_client SERIAL,
    PRIMARY KEY (idn),
    FOREIGN KEY (idc_client) REFERENCES client(idc)
);

-- Creación o actualización de la tabla Detail
CREATE TABLE IF NOT EXISTS detail (
    idd SERIAL,
    qua_detail INT NOT NULL,
    pri_detail DECIMAL(10, 2) NOT NULL,
    idn_invoice SERIAL,
    idp_product SERIAL,
    PRIMARY KEY (idd),
    FOREIGN KEY (idn_invoice) REFERENCES invoice(idn),
    FOREIGN KEY (idp_product) REFERENCES product(idp)
);

-- VIEWS --

-- Vista para mostrar información detallada de la factura junto con el cliente y detalles del producto
CREATE VIEW IF NOT EXISTS invoice_detail_customer_product AS
    SELECT i.cod_invoice, c.ful_nam_client AS customer_name, d.qua_detail, d.pri_detail, p.des_product, p.bra_product
    FROM invoice i
    JOIN client c ON c.idc = i.idc_client
    JOIN detail d ON d.idn_invoice = i.idn
    JOIN product p ON p.idp = d.idp_product;

-- Vista para mostrar detalles de la factura junto con el nombre del cliente
CREATE VIEW IF NOT EXISTS invoice_customer_info AS
    SELECT i.*, c.ful_nam_client AS customer_name
    FROM invoice i
    JOIN client c ON c.idc = i.idc_client;

-- Vista para mostrar detalles de la factura junto con información del producto
CREATE VIEW IF NOT EXISTS invoice_detail_product_info AS
    SELECT d.*, i.cod_invoice, p.des_product, p.pri_product
    FROM detail d
    JOIN invoice i ON i.idn = d.idn_invoice
    JOIN product p ON p.idp = d.idp_product;
