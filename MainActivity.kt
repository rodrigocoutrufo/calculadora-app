import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoratop.R

class CalculatorActivity : AppCompatActivity() {

    private lateinit var tvFormula: TextView
    private lateinit var tvResult: TextView

    private var currentInput: String = ""
    private var currentOperator: String = ""
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        tvFormula = findViewById(R.id.tvFormula)
        tvResult = findViewById(R.id.tvResult)

        // Set OnClickListener for numeric buttons
        val numericButtonIds = listOf(
            R.id.um, R.id.dois, R.id.tres, R.id.quatro,
            R.id.cinco, R.id.seis, R.id.sete, R.id.oito,
            R.id.novw, R.id.zero, R.id.ponto
        )
        numericButtonIds.forEach { id ->
            findViewById<Button>(id).setOnClickListener {
                onNumericButtonClick((it as Button).text.toString())
            }
        }

        // Set OnClickListener for operator buttons
        val operatorButtonIds = listOf(R.id.mais, R.id.menus, R.id.vezes, R.id.divisao)
        operatorButtonIds.forEach { id ->
            findViewById<Button>(id).setOnClickListener {
                onOperatorButtonClick((it as Button).text.toString())
            }
        }

        // Set OnClickListener for equals button
        findViewById<Button>(R.id.igual).setOnClickListener {
            calculateResult()
        }

        // Set OnClickListener for clear button
        findViewById<Button>(R.id.apagar).setOnClickListener {
            clear()
        }
    }

    private fun onNumericButtonClick(input: String) {
        currentInput += input
        updateFormula(currentInput)
    }

    private fun onOperatorButtonClick(operator: String) {
        if (currentInput.isNotEmpty()) {
            operand1 = currentInput.toDouble()
            currentInput = ""
            currentOperator = operator
            updateFormula("$operand1 $currentOperator ")
        }
    }

    private fun calculateResult() {
        if (currentInput.isNotEmpty() && currentOperator.isNotEmpty()) {
            operand2 = currentInput.toDouble()
            val result = when (currentOperator) {
                "+" -> operand1 + operand2
                "-" -> operand1 - operand2
                "*" -> operand1 * operand2
                "/" -> operand1 / operand2
                else -> 0.0
            }
            updateResult(result.toString())
            currentInput = result.toString()
            currentOperator = ""
        }
    }

    private fun clear() {
        currentInput = ""
        currentOperator = ""
        operand1 = 0.0
        operand2 = 0.0
        updateFormula("")
        updateResult("0")
    }

    private fun updateFormula(formula: String) {
        tvFormula.text = formula
    }

    private fun updateResult(result: String) {
        tvResult.text = result
    }
}import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoratop.R

class CalculatorActivity : AppCompatActivity() {

    private lateinit var tvFormula: TextView
    private lateinit var tvResult: TextView

    private var currentInput: String = ""
    private var currentOperator: String = ""
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        tvFormula = findViewById(R.id.tvFormula)
        tvResult = findViewById(R.id.tvResult)

        // Set OnClickListener for numeric buttons
        val numericButtonIds = listOf(
            R.id.um, R.id.dois, R.id.tres, R.id.quatro,
            R.id.cinco, R.id.seis, R.id.sete, R.id.oito,
            R.id.novw, R.id.zero, R.id.ponto
        )
        numericButtonIds.forEach { id ->
            findViewById<Button>(id).setOnClickListener {
                onNumericButtonClick((it as Button).text.toString())
            }
        }

        // Set OnClickListener for operator buttons
        val operatorButtonIds = listOf(R.id.mais, R.id.menus, R.id.vezes, R.id.divisao)
        operatorButtonIds.forEach { id ->
            findViewById<Button>(id).setOnClickListener {
                onOperatorButtonClick((it as Button).text.toString())
            }
        }

        // Set OnClickListener for equals button
        findViewById<Button>(R.id.igual).setOnClickListener {
            calculateResult()
        }

        // Set OnClickListener for clear button
        findViewById<Button>(R.id.apagar).setOnClickListener {
            clear()
        }
    }

    private fun onNumericButtonClick(input: String) {
        currentInput += input
        updateFormula(currentInput)
    }

    private fun onOperatorButtonClick(operator: String) {
        if (currentInput.isNotEmpty()) {
            operand1 = currentInput.toDouble()
            currentInput = ""
            currentOperator = operator
            updateFormula("$operand1 $currentOperator ")
        }
    }

    private fun calculateResult() {
        if (currentInput.isNotEmpty() && currentOperator.isNotEmpty()) {
            operand2 = currentInput.toDouble()
            val result = when (currentOperator) {
                "+" -> operand1 + operand2
                "-" -> operand1 - operand2
                "*" -> operand1 * operand2
                "/" -> operand1 / operand2
                else -> 0.0
            }
            updateResult(result.toString())
            currentInput = result.toString()
            currentOperator = ""
        }
    }

    private fun clear() {
        currentInput = ""
        currentOperator = ""
        operand1 = 0.0
        operand2 = 0.0
        updateFormula("")
        updateResult("0")
    }

    private fun updateFormula(formula: String) {
        tvFormula.text = formula
    }

    private fun updateResult(result: String) {
        tvResult.text = result
    }
}
