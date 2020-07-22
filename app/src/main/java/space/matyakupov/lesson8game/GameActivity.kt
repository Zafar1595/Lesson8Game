package space.matyakupov.lesson8game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    var firstNumber: Int = 0
    var operator: String = ""
    var secondNumber: Int = 0
    private var tuwri: Int = 0
    private var qate: Int = 0
    val INTENT_KEY = "result"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        tuwri = 0
        qate = 0
        playGame()
    }

    fun onClick(view: View){

        if((view as Button).text == tuwriAnswer().toString()){
            tuwri++
        }else{
            qate++
        }

        if(tuwri + qate == 10){
            var intent = Intent(this, SecondActivity::class.java)
            if(tuwri == 10){
                intent.putExtra(INTENT_KEY, "Пздравляем ваш результат 10 из 10")
            }else {
                intent.putExtra(INTENT_KEY, "Правилные: $tuwri \nНеправильные: $qate")
            }
                finish()
            startActivity(intent)
        }else{ playGame() }
    }


    private fun playGame(){
        operator = generateRandomOperator()
        if(operator == "/") {
            do {
                firstNumber = Random.nextInt(10, 100)
                secondNumber = Random.nextInt(10, 100)
            }while (firstNumber % secondNumber != 0)
        }else{
            firstNumber = Random.nextInt(10, 100)
            secondNumber = Random.nextInt(10, 100)
        }
        var firstNumberStr = firstNumber.toString()
        var secondNumberStr = secondNumber.toString()

        textViewoperator.text = "$firstNumberStr $operator $secondNumberStr"
        setBtnAnswer()
    }

    private fun generateRandomOperator(): String{
        return when(Random.nextInt(0,4)){
            0 -> "+"
            1 -> "-"
            2 -> "*"
            3 -> "/"
            else -> "+"
        }
    }

    private fun tuwriAnswer(): Int{
        return when(operator){
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "*" -> firstNumber * secondNumber
            "/" -> firstNumber / secondNumber
            else -> 0
        }
    }

    private fun setBtnAnswer(){
        var answer = tuwriAnswer()
        try {
            var variantA = when(Random.nextInt(0, 2)){
                0 -> answer + Random.nextInt(3, 100)
                1 -> answer - Random.nextInt(3, 100)
                else -> answer + 5
            }
            var variantB = when(Random.nextInt(0, 2)){
                0 -> answer + Random.nextInt(3, 100)
                1 -> answer - Random.nextInt(3, 100)
                else -> answer + 5
            }
            var variantC = when(Random.nextInt(0, 2)){
                0 -> answer + Random.nextInt(3, 100)
                1 -> answer - Random.nextInt(3, 100)
                else -> answer + 5
            }
            var variantD = when(Random.nextInt(0, 2)){
                0 -> answer + Random.nextInt(3, 100)
                1 -> answer - Random.nextInt(3, 100)
                else -> answer + 5
            }

            when(Random.nextInt(0,4)){
                0 -> variantA = answer
                1 -> variantB = answer
                2 -> variantC = answer
                3 -> variantD = answer
                else -> variantA = answer
            }

            btnA.text = variantA.toString()
            btnB.text = variantB.toString()
            btnC.text = variantC.toString()
            btnD.text = variantD.toString()
        }catch (e: Exception){
            Toast.makeText(this,e.toString(), Toast.LENGTH_LONG).show()
        }
    }

    override fun onBackPressed() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}