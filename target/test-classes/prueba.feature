Feature: Prueba para agendar una cita

  Scenario Outline: AgendarCita
    Given Abrimos el navegador y vamos al sitio web de agregar doctores
    And El usuario ingrese el nombre del doctor "<nombreDoctor>", los apellidos "<apellidosDoctor>", el telefono "<telefono>", el tipo de documento "<tipoDocumento>" y el numero de identidad
    And El usuario presione el boton guardar
    And vamos al sitio web de agregar pacientes
    And El usuario ingrese el nombre del paciente "<nombrePaciente>", los apellidos "<apellidosPaciente>", el telefono "<telefono2>", el tipo de documento "<tipoDocumento2>", el numero de identidad y si la salud es prepagada "<saludPrepagada>"
    And El usuario presione el boton guardar paciente
    And vamos al sitio web de agendar citas
    When El usuario ingrese el dia de la cita "<diaCita>", el documento de identidad del paciente, el documento de identidad del doctor y las observaciones "<observaciones>"
    And El usuario presione el boton guardar cita
    Then El usuario debe ver el mensaje "<mensaje>"

    Examples: 
      | nombreDoctor | apellidosDoctor | telefono | tipoDocumento        | nombrePaciente | apellidosPaciente | telefono2 | tipoDocumento2       | saludPrepagada | mensaje                        | diaCita    | observaciones              |
      | Pedro        | Perez           |  5558000 | Cédula de ciudadanía | Carlos         | Martinez Rendon   |   5558000 | Pasaportes           | true           | Datos guardados correctamente. | 07/05/2018 | Cita para revisión general |
      |              | Sepulveda       |  4567834 | Cédula de ciudadanía |                | Quintero          |   4567834 | Cédula de ciudadanía | false          | No se pudo guardar debido a:   | 07/28/2018 |                            |
