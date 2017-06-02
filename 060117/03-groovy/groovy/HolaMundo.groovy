/*
 * En Groovy no hay necesidad de escribir un metodo main para ejecutar un clase.
 */

println 'Hola mundo'


/*
 * ¿Como le hago para acceder a los parametros que la JVM pasa a la clase?
 */

println "Parametros recibidos '$args'"

println 'Parametros recibidos \'' + args + '\''

println "La suma es:  ${ 1 + 2 }"

println args



for(String param : args) {
	System.out.println(param);
}

/*
 * Observen la diferencia en las comillas simple y dobles. GStrings hacen interpolacion de variables
 */

