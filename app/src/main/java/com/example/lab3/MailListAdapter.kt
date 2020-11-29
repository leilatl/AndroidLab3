package com.example.lab3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MailListAdapter:
    RecyclerView.Adapter<MailListAdapter.MyViewHolder>() {
    private val titles = arrayOf("Winter is coming", "Fire and Blood", "Hear me Roar")
    private val texts = arrayOf("House Stark of Winterfell is a Great House of Westeros and the royal house of the Kingdom of the North.",
        "House Targaryen of Dragonstone is a noble family of Valyrian descent who once ruled the Seven Kingdoms of Westeros.",
        "House Lannister is one of the Great Houses of Westeros. Their lands are in the far west of the continent.")
    private val senders = arrayOf("John Snow", "Daenerys Targaryen", "Cersei Lannister")
    fun getTitles(): Array<String>{
        return titles
    }
    fun getTexts(): Array<String>{
        return texts
    }
    fun getSenders(): Array<String>{
        return senders
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.senderText.text = "sender: "+senders[position]
        holder.titleText.text = "title: "+titles[position]
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var senderText: TextView
        var titleText: TextView

        init{
            senderText = itemView.findViewById(R.id.senderTV)
            titleText = itemView.findViewById(R.id.titleTV)

            itemView.setOnClickListener{
                var position: Int = getAdapterPosition()
                val context = itemView.context
                val intent = Intent(context, DetailActivity::class.java).apply {
                    val adapter = MailListAdapter()
                    putExtra("NUMBER", position)
                    putExtra("title", adapter.getTitles()[position])
                    putExtra("sender", adapter.getSenders()[position])
                    putExtra("text", adapter.getTexts()[position])

            }
                context.startActivity(intent)
        }


    }

}
}