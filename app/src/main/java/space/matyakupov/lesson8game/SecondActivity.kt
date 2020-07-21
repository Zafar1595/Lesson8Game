package space.matyakupov.lesson8game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textViewResult.text = intent.getStringExtra("result")

        buttonRestart.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            finish()
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        var intent = Intent(this, MainActivity::class.java)
        finish()
        startActivity(intent)
    }
}