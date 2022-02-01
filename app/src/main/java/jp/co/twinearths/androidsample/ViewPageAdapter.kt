package jp.co.twinearths.androidsample
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPageAdapter(private var titles:List<String>, private var images:List<Int>):
    RecyclerView.Adapter<Page2ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Page2ViewHolder {
        return Page2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))
    }

    override fun onBindViewHolder(holder: Page2ViewHolder, position: Int) {
        holder.itemImage.setImageResource(images[position])
        holder.itemTitle.text = titles[position]
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}

 class  Page2ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
     var itemTitle: TextView = itemView.findViewById(R.id.textView)
     var itemImage : ImageView = itemView.findViewById(R.id.imageView)
     init{}
}