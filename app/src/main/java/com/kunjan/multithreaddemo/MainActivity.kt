package com.kunjan.multithreaddemo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var edtInput: EditText
    private lateinit var txtOutput: TextView
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtInput = findViewById<EditText>(R.id.input);
        txtOutput = findViewById<TextView>(R.id.output);
        btn = findViewById(R.id.submit)

        btn.setOnClickListener {
            Thread(Runnable {
                runOnUiThread {
                    txtOutput.text = capitalizeFirstLetter(edtInput.text.toString())
                }
            }).start()
        }
    }

    private fun capitalizeFirstLetter(s:String):String {
        var result = "" + s[0].toUpperCase()
        result += s[1]
        for(i in 2 until s.length){
            result = if(result[i-1] == '.')
                result + s[i].toUpperCase()
            else
                result + s[i]
        }
        return result

    }
}
        /*edtInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,before: Int, count: Int) {
                if (s.contains('.')) {
                    Thread(Runnable {
                        runOnUiThread {
                            capitalizeFirstLetter(s.toString());
                        }
                    })
                }
            }
        })*/


