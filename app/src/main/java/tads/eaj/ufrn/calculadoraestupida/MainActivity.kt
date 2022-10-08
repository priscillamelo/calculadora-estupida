package tads.eaj.ufrn.calculadoraestupida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    var txtX: Int = 0
    var txtY: Int = 0
    var resultado: Int = 0

    val setVariableXLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
            if(result.resultCode == RESULT_OK){
                txtX = result.data!!.getIntExtra("Valor", 0)
                val txtvariableX = findViewById<TextView>(R.id.txtX)
                txtvariableX.text = "${txtX}"
            } else {
                Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
            }
    }

    val setVariableYLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            txtY = result.data!!.getIntExtra("Valor", 0)
            val txtvariableY = findViewById<TextView>(R.id.txtY)
            txtvariableY.text = "${txtY}"
        } else {
            Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtvariableX = findViewById<TextView>(R.id.txtX)
        val txtvariableY = findViewById<TextView>(R.id.txtY)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        txtvariableX.text = "${txtX}"
        txtvariableY.text = "${txtY}"
        txtResult.text = "${resultado}"

        val btnVariableX = findViewById<Button>(R.id.btnVariable_x)
        val btnVariableY = findViewById<Button>(R.id.btnVariable_y)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)

        btnVariableX.setOnClickListener {
            val intent = Intent(this, ActivityValores::class.java)
            val bundle = Bundle()

            bundle.putString("Variavel", "Variable X")
            bundle.putInt("Valor", txtX)
            intent.putExtras(bundle)

            setVariableXLauncher.launch(intent)
        }

        btnVariableY.setOnClickListener {
            val intent = Intent(this, ActivityValores::class.java)
            val bundle = Bundle()

            bundle.putString("Variavel", "Variable Y")
            bundle.putInt("Valor", txtY)
            intent.putExtras(bundle)

            setVariableYLauncher.launch(intent)
        }

        btnCalculate.setOnClickListener {
            txtResult.text = (txtX + txtY).toString()
            Toast.makeText(this, getString(R.string.realizando_calculo), Toast.LENGTH_SHORT).show()
        }
    }
}