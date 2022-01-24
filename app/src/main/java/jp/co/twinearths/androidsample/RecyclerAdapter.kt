package jp.co.twinearths.androidsample

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val context: Context, private val list: MutableList<TableData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val HEADER_TYPE = 1
        const val ITEM_TYPE = 2
    }
    // 全体のItemの数を設定
    override fun getItemCount(): Int = list.size
    // viewTypeを設定
    override fun getItemViewType(position: Int): Int {
        return list[position].viewType
    }
    // viewType: SectionとItemを使い分ける
    // 要素のUIを作成
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HEADER_TYPE) {
            HeaderViewHolder(
                LayoutInflater.from(context).inflate(R.layout.header_recycleview, parent, false)
            )
        } else  { // if (viewType == ITEM_TYPE)
            ItemViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent, false)
            )
        }
    }
    // それぞれのItemの中身を設定
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemData = list[position]
        if (itemData.viewType == RecyclerAdapter.HEADER_TYPE) {
            val headerViewHolder = holder as HeaderViewHolder
            headerViewHolder.txtHeader.text = itemData.textTitle
        } else if (itemData.viewType == RecyclerAdapter.ITEM_TYPE) {
            val itemViewHolder = holder as ItemViewHolder
            itemViewHolder.txtItem.text = itemData.textTitle
        }
    }
}