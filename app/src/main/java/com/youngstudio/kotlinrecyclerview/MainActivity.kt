package com.youngstudio.kotlinrecyclerview
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //id가 btn인 버튼에 클릭리스너 추가하기 [코틀린은 id가 참조변수 임]
//        btn.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                //SecondActivity를 실행해주는 Intent객체 생성
//                var intent= Intent(this@MainActivity, SecondActivity::class.java)
//                startActivity(intent)
//            }
//        })


        //코틀린에서는 SAM(Single Abstract Method)에 대해
        //람다식 표현을 제공함.
        btn.setOnClickListener{

            //매개변수 it [ click을 한 View]
            //var b= it as Button
            //이 영역은 익명클래스가 아니어서 this를 MainActivity로 인지함.
            //Toast.makeText(this, b.text, Toast.LENGTH_SHORT).show()
            startActivity( Intent(this, SecondActivity::class.java))
        }





    }

    fun clickExit(view: View) {
        finish()
    }
}
