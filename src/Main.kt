//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var cuentaAhorros = CuentaAhorros(10500.0f, 0.05f)
    cuentaAhorros.imprimir()
    cuentaAhorros.consignar(100.0f)
    cuentaAhorros.retirar(50.0f)
    cuentaAhorros.calcularExtracto()
}