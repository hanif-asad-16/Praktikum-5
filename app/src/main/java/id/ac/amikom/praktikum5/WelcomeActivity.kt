package id.ac.amikom.praktikum5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class WelcomeActivity : AppCompatActivity() {

    lateinit var etNama : EditText
    lateinit var btnSubmit : Button

    lateinit var prefUtil : PreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        prefUtil = PreferenceUtil.newInstance(this)

        etNama = findViewById(R.Id.et_nama)
        btnSubmit = findViewById(R.Id.btn_submit)

        etNama.setText(prefUtil.getString("nama"))

        btnSubmit.setOnClickListener {
            saveData()
            val intentmainActivity - Intent (packageContent this , MainActivity :: class.java). apply {
                addFlag( intent.FLAG_ACTIVITY_CLEAR_TASK or intent.FLAG_ACTIVITY_NEW_TASK)
        }
            startActivity(intentmainActivity)
        }
    }

        private fun saveData() {
            val nama - atNama.text.toString().trim()
            prefUtil.setString("nama", nama)
            prefUtil.setBoolean("is_login", true)
        }
}