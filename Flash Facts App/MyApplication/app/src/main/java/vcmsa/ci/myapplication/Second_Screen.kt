package vcmsa.ci.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Second_Screen() : AppCompatActivity() {
    private val questions = arrayOf(
        "Nelson Mandela was the first black president",
        "Apartheid was abolished in 1980 ",
        "South Africa became a republic in 1961",
        "The Sharpville Massacre took place in the year 1960",
        "South Africa's first democratic elections took place in 1994",
        "Desmond Tutu was awarded the nobel Peace prize in 1984",
        "South Africa's national soccer team won the 1998 Fifa World cup",
        "The boer war was fought between the british empire and the dutch settlers"

    )
    private val answers = arrayOf(
        true, false, true, true, true, true, false, true

    )
    private var currentQuestionIndex = 0
    private var score = 0

    private lateinit var questionTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var feedbackTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_screen)


        //The UI Elements
        questionTextView = findViewById(R.id.txtQuestion)
        trueButton = findViewById(R.id.btnTrue)
        falseButton = findViewById(R.id.btnFalse)
        nextButton = findViewById(R.id.btnNext)
        feedbackTextView = findViewById(R.id.txtFeedback)

        // Output first question
        loadQuestion()

        // True button uses the set on click listener to see if the answer is correct
        trueButton.setOnClickListener { checkAnswer(true) }

        // The false button uses the set on click listener to see if the answer is false
        falseButton.setOnClickListener { checkAnswer(false) }

        // Next button moves to the following question
        nextButton.setOnClickListener { nextQuestion() }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentQuestionIndex]
        if (userAnswer == correctAnswer) {
            feedbackTextView.text = "Correct!"
            score++
        } else {
            feedbackTextView.text = "Incorrect."
        }
        trueButton.isEnabled = false
        falseButton.isEnabled = false
        nextButton.isEnabled = true
    }

    private fun nextQuestion() {
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size) {
            loadQuestion()
        } else {
            val intent = Intent(this, third_screen::class.java)
            intent.putExtra("SCORE", score)
            intent.putExtra("TOTAL", questions.size)
            startActivity(intent)
            finish()
        }
    }

    private fun loadQuestion() {
        // Set the current question text to the TextView
        questionTextView.text = questions[currentQuestionIndex]

        // Reset feedback text
        feedbackTextView.text = ""

        // Enable the answer buttons for the next question
        trueButton.isEnabled = true
        falseButton.isEnabled = true
        nextButton.isEnabled = false
    }


}





    






