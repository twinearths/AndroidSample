package jp.co.twinearths.androidsample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder {
    class ViewHolderList (item: View) : RecyclerView.ViewHolder(item) {
        val characterList: TextView = item.findViewById(R.id.Title)
    }
}