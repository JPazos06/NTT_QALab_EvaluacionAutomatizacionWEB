@store
  Feature: Product - Store
    Scenario Outline: Validacion del precio de un producto

      Given estoy en la pagina de la tienda
      And me logueo con mi usuario "<usuario>" y clave "<contrasena>"
      When navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
      And agrego 2 unidades del primer producto al carrito
      Then valido en el popup la confirmacion del producto agregado
      And valido en el popup que el monto total sea calculado correctamente
      When finalizo la compra
      Then valido el titulo de la pagina del carrito
      And vuelvo a validar el calculo de precios en el carrito
  Examples:
    | usuario               | contrasena   | categoria | subcategoria |
    | cjpazos@outlook.com   | Pazos19A!    | CLOTHES   | Men          |
    | userfalso@outlook.com | Contrasena1! | CLOTHES   | Men          |
    | cjpazos@outlook.com   | Pazos19A!    | AUTO      | Men          |