import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alma.exame1_semi_marti_alberto.R
import com.alma.exame1_semi_marti_alberto.adapters.EventOnClickListener
import com.alma.exame1_semi_marti_alberto.databinding.ItemEventListBinding
import com.alma.exame1_semi_marti_alberto.pojo.Evento

class EventAdapter(private val context: Context, var itemClickListener: EventOnClickListener): RecyclerView.Adapter<EventAdapter.ProductsViewHolder>() {

    private lateinit var binding: ItemEventListBinding
    private var dataList = mutableListOf<Evento>()

    fun setListData(data: MutableList<Evento>) {
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        binding = ItemEventListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val productsList = dataList[position]
        holder.bindView(productsList)
    }

    override fun getItemCount(): Int {
        return if(dataList.size > 0) {
            dataList.size
        } else {
            0
        }
    }

    inner class ProductsViewHolder(private val itemBinding: ItemEventListBinding): RecyclerView.ViewHolder(itemBinding.root) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bindView(model: Evento) {
            if (model.typeEvent == Evento.TypeEvent.REUNION) {
                itemBinding.imageViewId.setImageDrawable(context.getDrawable(R.drawable.reunion))
            }
            if (model.typeEvent == Evento.TypeEvent.CUMPLE) {
                itemBinding.imageViewId.setImageDrawable(context.getDrawable(R.drawable.cumple))
            }
            if (model.typeEvent == Evento.TypeEvent.RECORDATORIO) {
                itemBinding.imageViewId.setImageDrawable(context.getDrawable(R.drawable.recordatorio))
            }
            itemBinding.textId.text = model.title
            itemView.setOnClickListener { itemClickListener.eventClick(model) }
        }
    }
}