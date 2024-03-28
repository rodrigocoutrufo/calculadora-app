import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvFormula: TextView
    private lateinit var tvResult: TextView

    private var currentNumber: String = ""
    private var currentOperator: String = ""
    private var currentFormula: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvFormula = findViewById(R.id.tvFormula)
        tvResult = findViewById(R.id.tvResult)

        val buttons = listOf<MaterialButton>(
            findViewById(R.id.apagar), findViewById(R.id.mais), findViewById(R.id.divisao),
            findViewById(R.id.sete), findViewById(R.id.oito), findViewById(R.id.novw),
            findViewById(R.id.vezes), findViewById(R.id.quatro), findViewById(R.id.cinco),
            findViewById(R.id.seis), findViewById(R.id.menus), findViewById(R.id.um),
            findViewById(R.id.dois), findViewById(R.id.tres), findViewById(R.id.igual),
            findViewById(R.id.zero), findViewById(R.id.ponto)
        )

        for (button in buttons) {
            button.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.apagar -> {
                currentNumber = ""
                currentOperator = ""
                currentFormula = ""
            }
            R.id.mais, R.id.divisao, R.id.vezes, R.id.menus -> {
                if (currentNumber.isNotEmpty()) {
                    currentOperator = (v as MaterialButton).text.toString()
                    currentFormula += currentNumber + currentOperator
                    currentNumber = ""
                }
            }
            R.id.igual -> {
                if (currentNumber.isNotEmpty() && currentOperator.isNotEmpty()) {
                    currentFormula += currentNumber
                    val result = calculateResult(currentFormula)
                    tvResult.text = result.toString()
                    currentNumber = result.toString()
                    currentOperator = ""
                    currentFormula = ""
                }
            }
            else -> {
                currentNumber += (v as MaterialButton).text.toString()
            }
        }
        tvFormula.text = currentFormula + currentNumber
    }

    private fun calculateResult(formula: String): Double {
        return try {
            val parts = formula.split(Regex("(?<=[+\\-*/])|(?=[+\\-*/])"))
            var result = parts[0].toDouble()
            for (i in 1 until parts.size step 2) {
                val operator = parts[i]
                val operand = parts[i + 1].toDouble()
                result = when (operator) {
                    "+" -> result + operand
                    "-" -> result - operand
                    "*" -> result * operand
                    "/" -> result / operand
                    else -> throw IllegalArgumentException("Invalid operator")
                }
            }
            result
        } catch (e: Exception) {
            0.0
        }
    }
}
