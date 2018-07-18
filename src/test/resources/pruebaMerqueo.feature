Feature: Prueba para agregar un producto al carrito e insertar la direccion para el domicilio

  Scenario Outline: AgregaraticuloAlCarrito
    Given Abrimos el navegador y vamos al sitio de merqueo.com
    When El usuario seleccione la categoria "<categoria1>"
    And El usuario seleccione la subcategoria "<subcategoria1>"
    And El usuario da click en el producto "<producto1>"
    And El usuario da click en el boton para agregar al carrito
    And El usuario asigna la direccion con Ciudad "<ciudad>", zona "<zona>", calle "<calle>", numero1 "<numero>" y numero2 "<numero2>"
    And El usuario da click en validar
    Then El carrito cambia la cantidad de los articulos a "<cantidadEsperada>"

    Examples: 
      | categoria1       | subcategoria1      | producto1                                 | ciudad   | zona  | calle | numero | numero2 | cantidadEsperada |
      | Lácteos y huevos | Bebidas Lácteas    | Leche Saborizada chocolate Alpin caja x 6 | Medellín | Bello |    26 | 58dd   |      69 |                1 |
      | Bebés            | Alimento para Bebé | Compota Babyfruit Frasco Manzana          | Medellín | Bello |    26 | 58dd   |      69 |                1 |
