package app.wataso_.watanabe.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//"DataStore"という名前でインスタンスを生成
        val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)
        saveButton.setOnClickListener {

            //エディットテキストのテキストを取得
            val stringText = editText.text.toString()
            saveText.text = stringText

            //  入力文字列を”Input”に書き込む
            val editor = dataStore.edit()
            editor.putString("Input",stringText)

            //新たな文字を書き込めるようにする
            editor.apply()

        }
        readButton.setOnClickListener {

            //"Input"から読み出す
            val str = dataStore.getString("Input","NoData")
            readText.text = str

        }
    }
}