package vcmsa.ci.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class third_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third_screen)


        val scoreTextView = findViewById<TextView>(R.id.txtScore)
        val reviewTextView = findViewById<TextView>(R.id.reviewTextView)
        val exitButton = findViewById<Button>(R.id.btnExit)

        val score = intent.getIntExtra("score",0)
        val total= intent.getIntExtra("Total",8)

        scoreTextView.text = "you scored $score out of $total"

        val message = when(score){
            5-> "Excellent work!"
            4-> "Great Job!"
            3-> "Good Effort"
            else-> "keep practicing!"
        }

        reviewTextView.text = message

        // Go back to mainActivity when the button is clicked
        exitButton.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP )
            startActivity(intent)
            finish()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}