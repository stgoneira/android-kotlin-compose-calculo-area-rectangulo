package cl.stgoneira.learning.android.calculoarearectangulo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
// importante importar estos 4:
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculoAreaUI()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CalculoAreaUI() {
    // variables necesarias que mantienen su estado
    // similar a como funciona React
    var base by remember { mutableStateOf( "" ) }
    var altura by remember { mutableStateOf( "" ) }
    var resultado by remember { mutableStateOf("") }

    Column {
        Text("Cálculo Área Rectángulo")
        TextField(
            value = base,
            // cuando cambia el valor
            // se actualiza la variable de estado
            onValueChange = { base = it },
            label = { Text("Base") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        TextField(
            value = altura,
            onValueChange = { altura = it },
            label = { Text("Altura") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Button(onClick = {
            // si no puede convertir a número entero
            // se devuelve null
            // y finalmente si es null se devuelve 0
            val baseNumero = base.toIntOrNull() ?: 0
            val alturaNumero = altura.toIntOrNull() ?: 0
            val area = calcularAreaRectangulo(baseNumero, alturaNumero)
            resultado = "El área es: " + area
        }) {
            // Contenido del botón
            Text("Calcular")
        }
        Text(resultado ) // acá irá el resultado
    }
}

fun calcularAreaRectangulo(base:Int, altura:Int):Int {
    return base * altura
}