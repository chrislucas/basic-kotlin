package br.com.xplorer.startactivities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonActionStartActivity = findViewById<Button>(R.id.button_start_activity)
        val op: (i: View) -> Unit = {
            val intent = Intent(this, AnotherActivity::class.java)
            startActivity(intent)
        }
        buttonActionStartActivity.setOnClickListener { op(it) }
    }
}
