package jp.co.twinearths.androidsample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder {
    class ViewHolderList (item: View) : RecyclerView.ViewHolder(item) {
        val characterList: TextView = item.findViewById(R.id.Title)
    }
}

class HeaderViewHolder(private val headerView: View) : RecyclerView.ViewHolder(headerView) {
    val txtHeader = headerView.findViewById(R.id.Title) as TextView
}

class ItemViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    val txtItem = itemView.findViewById(R.id.Title) as TextView
}