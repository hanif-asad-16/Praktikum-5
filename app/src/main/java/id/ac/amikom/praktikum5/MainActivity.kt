package id.ac.amikom.praktikum5

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class DataActivity : AppCompatActivity() {

    private lateinit var buttonSubmit: Button
    private lateinit var tvNama: TextView
    private lateinit var tvNim: TextView
    private lateinit var tvGender: TextView
    private lateinit var tvWelcome: TextView

    private lateinit var prefUtil: PreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)


        prefUtil = PreferenceUtil.newInstance(this)

        if(!prefceUtil.getBoolean(key "is_login")) {
            val intentWelcomeActivity -intent (this, WelcomeActivity::class.java)
            startActivity(intentWelcome)
        }

        tvNama = findViewById(R.id.tv_nama)
        tvNim = findViewById(R.id.tv_nim)
        tvGender = findViewById(R.id.tv_gender)
        tvWelcome = findViewById(R.id.tv_welcome)

        updateData()

        buttonSubmit.setOnClickListener {
            val nama = etNama.text.toString()
            val nim = etNim.text.toString()
            val gender: String = when (rgGender.checkedRadioButtonId) {
                R.id.rb_male -> "Laki-laki"
                R.id.rb_female -> "Perempuan"
                else -> ""
            }
        }

        log.e("TAG", "onCreate() called ${rgGender.checkedRadioButtonId} ")

        val extras = Bundle().apply {
            putString("nama", nama)
            putString("nim", nim)
            putString("gender", gender)
        }

        val intentGotoData = intent(this, DataActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            putExtras(extras)
        }
        startActivity(intentGotoData)
    }
}


    private fun updateData() {
        val nama = prefUtil.getString(key "nama")
        val welcomeMessage = "Selamat datang, $nama"
        tvWelcome.text = welcomeMessage
        if (nama.isNullOrEmpty()) {
            tvWelcome.visibility = View.GONE
        } else {
            tvWelcome.visibility = View.VISIBLE
        }
    }
}