package com.youngstudio.kotlinrecyclerview

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_item.view.*

class MyAdapter constructor(var context: Context, var items:ArrayList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater= LayoutInflater.from(context)
        val itemView= inflater.inflate(R.layout.recycler_item, parent, false)
        val vh= VH(itemView)
        return vh
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val vh= holder as VH //코틀린에서의 다운캐스팅

        val item= items.get(position)
        //vh.tvTitle.setText(item.title)
        vh.itemView.tvTitle.text= item.title
        vh.itemView.tvMsg.text= item.msg

        //Glide 라이브러리로 이미지 설정
        Glide.with(context).load(item.img).into(vh.itemView.iv)


        //여기서 itemView 클릭리스너를 추가해도 됨.
//        vh.itemView.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//
//                val intent= Intent(context, ItemActivity::class.java)
//                intent.putExtra("title", item.title)
//                intent.putExtra("msg", item.msg)
//                intent.putExtra("img", item.img)
//
//                context.startActivity(intent)
//            }
//        })

    }

    //ViewHoler클래스 inner클래스
    inner class VH constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        //멤버변수[property]
//        var tvTitle: TextView= itemView.tvTitle
//        var tvMsg= itemView.tvMsg
//        var iv= itemView.iv

//        init {
//            tvTitle= itemView.findViewById(R.id.tvTitle)
//        }

        init {
            //클릭리스너를 붙이는 작업을 onBindViewHolder()에서 작성
            itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    //Log.i("TAG", ""+adapterPosition+" , " + layoutPosition);
                    //Toast.makeText(context, ""+adapterPosition+" , " + layoutPosition, Toast.LENGTH_SHORT).show()

                    val intent= Intent(context, ItemActivity::class.java)
                    intent.putExtra("title", items.get(layoutPosition).title)
                    intent.putExtra("msg", items.get(layoutPosition).msg)
                    intent.putExtra("img", items.get(layoutPosition).img)

                    context.startActivity(intent)
                }
            })

        }
    }



}