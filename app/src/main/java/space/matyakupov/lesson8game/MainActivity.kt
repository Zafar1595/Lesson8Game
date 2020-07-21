package space.matyakupov.lesson8game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_start.setOnClickListener {
            var intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            finish()
        }

        button_exit.setOnClickListener {
            finish()
        }

        button_about.setOnClickListener {
            var intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    private var back_pressed: Long = 0
    override fun onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()){
            finish()

        }else{
            Toast.makeText(
                baseContext, "Нажмите еще раз чтобы выйти!",
                Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
    }



}