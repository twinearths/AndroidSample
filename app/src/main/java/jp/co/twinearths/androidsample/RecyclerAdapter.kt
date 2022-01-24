package jp.co.twinearths.androidsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val context: Context, private val list: MutableList<TableData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val HEADER_TYPE = 1
        const val ITEM_TYPE = 2
    }

    class HeaderViewHolder(private val headerView: View) : RecyclerView.ViewHolder(headerView) {
        val txtHeader = headerView.findViewById(R.id.Title) as TextView
    }

    class ItemViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtItem = itemView.findViewById(R.id.Title) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == HEADER_TYPE) {
            return HeaderViewHolder(
                LayoutInflater.from(context).inflate(R.layout.header_recycleview, parent, false)
            )
        } else if (viewType == ITEM_TYPE) {
            return ItemViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent, false)
            )
        }
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return ViewHolder.ViewHolderList(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemData = list[position]
        if (itemData.viewType == RecyclerAdapter.HEADER_TYPE) {
            val headerViewHolder = holder as RecyclerAdapter.HeaderViewHolder
            headerViewHolder.txtHeader.text = itemData.textTitle
        } else if (itemData.viewType == RecyclerAdapter.ITEM_TYPE) {
            val itemViewHolder = holder as RecyclerAdapter.ItemViewHolder
            itemViewHolder.txtItem.text = itemData.textTitle
        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].viewType
    }

    override fun getItemCount(): Int = list.size
}