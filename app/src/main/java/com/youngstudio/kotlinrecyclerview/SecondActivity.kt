package com.youngstudio.kotlinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_second.*
import java.util.ArrayList

class SecondActivity : AppCompatActivity() {

    //대량의 데이터 멤버변수[property]
    var items= ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //연습 : 대량의 데이터 추가
        items.add( Item("sam", "Hello Kotlin.", R.drawable.bg_one01) )
        items.add( Item("robin", "Nice Kotlin.", R.drawable.bg_one02) )
        items.add( Item("tom", "Good Kotlin.", R.drawable.bg_one03) )
        items.add( Item("lee", "aaa Kotlin.", R.drawable.bg_one04) )
        items.add( Item("hong", "ddd Kotlin.", R.drawable.bg_one05) )
        items.add( Item("kim", "ccc Kotlin.", R.drawable.battle1) )
        items.add( Item("sara", "fff Kotlin.", R.drawable.battle2) )
        items.add( Item("sss", "eee Kotlin.", R.drawable.battle3) )
        items.add( Item("aaa", "ggg Kotlin.", R.drawable.battle4) )

        //리사이클러뷰 안에 이미 아답터 프로퍼티(멤버변수)가 있어서
        //아답터에 대한 별도의 멤버변수가 필요하지 않음.
        //또한, 리사이클러뷰도 id가 이미 변수로 되어 있기에
        //리사이클러뷰 참보변수도 별도로 만들 필요가 없음.
        recycler.adapter= MyAdapter(this, items)

        //레이아웃매니져 붙이기
        recycler.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onResume() {
        super.onResume()

        //리사이클러뷰 갱신해보기...[ !! null이 아닐때만 동작하도록 ]
        recycler.adapter!!.notifyDataSetChanged()
    }
}