package tads.eaj.ufrn.calculadoraestupida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ActivityValores : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_valores)

        val variable = intent.extras?.getString("Variavel")
        val value = intent.extras?.getInt("Valor")

        val txtVariable = findViewById<TextView>(R.id.txtVariable)
        val editText: EditText = this.findViewById(R.id.inputVariable)

        txtVariable.text = variable
        editText.setText(value.toString())

        val btnOk = findViewById<Button>(R.id.btnOk)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        btnOk.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()

            val editTextVariable = findViewById<EditText>(R.id.inputVariable)
            bundle.putInt("Valor", editTextVariable.text.toString().toInt())
            intent.putExtras(bundle)

            setResult(RESULT_OK, intent)
            finish()
        }

        btnCancel.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}