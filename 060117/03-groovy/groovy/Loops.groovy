def contador = 5

println contador.class.name

contador.times {
  // Todos los closures en Groovy reciben por default un parametro que se llama it
	println "Iteracion $it"
}

println "_" * 80

4.times {
  println 'Hola'
}

println "_" * 80

0.upto (10) {
	print "$it "
}

println """
____

$args

Ciclo con step


Multiples saltos


____
"""

0.step(10, 2) {
	print "$it "
}
