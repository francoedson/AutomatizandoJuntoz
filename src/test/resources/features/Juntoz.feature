@FeatureJuntoz
Feature: Agregar producto al carrito en el sitio web de Juntoz

  @ScenarioJuntoz
  Scenario Outline: Agregar un producto al carrito desde la página de Envío Gratis
    Given El usuario abre el navegador e ingresa a la página de Juntoz
    When doy click en iniciar sesion para navegar al login
    And El usuario inicia sesión con las credenciales usuario: "<correo>" y contraseña: "<contra>"
    Then El usuario debe ser autenticado exitosamente encontrando su "<nombre>" en algún elemeto de la página

    When El usuario haya inciaido sesión navega a la categoría de Envio Gratis
    And Debo haber más de una tarjeta de productos en la página
    And Agregar un producto al carrito
    Then El usuario se dirige al carrito de compras
    And Verifica que haya más de un elemeto en la página

    Examples:
      | correo                       | contra    | nombre |
      | franco.edson.18014@gmail.com | Franco123 | Franco |
