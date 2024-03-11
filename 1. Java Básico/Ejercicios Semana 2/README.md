---- BASE DE DATOS ----
**Nombre**: EMPLEADOS
**Campos**:
id					int
nombre				String
apellido			String
cargo				String? Considera Clase
salario				double
fecha_inicio		LocalDate
cuenta_activa		boolean		<-- Borrado lógico


---- LOGICA ----
Agregar Empleado **HECHO**
Borrar lógicamente Empleado: Actualiza cuenta_activa a FALSE. **HECHO**
Listar Empleados: Lista únicamente las cuentas activas.**HECHO**
Actualizar Empleado: implica búsqueda, recogida y modificación.

Listar Por Cargo: búsqueda filtrada (NamedQuery)

--- SUPUESTOS ---
Se supone que hay un campo NIF. Se supone que el usuario puede estar interesado en buscar a un empleado introduciendo su nif.
Si se busca a un empleado por ID, se puede buscar indiscriminadamente. Esto es, esté la cuenta activa o no.