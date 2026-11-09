package com.example.chayani_3tib.Home.pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chayani_3tib.databinding.ItemProductBinding


class ProductAdapter(
    private val productList: List<ProductModel>,
    private val onItemClick: (ProductModel) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return ProductViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = productList[position]
        with(holder.binding) {
            tvProductName.text = item.name
            tvProductPrice.text = item.price

            // Memuat gambar menggunakan Glide
            Glide.with(holder.itemView.context)
                .load(item.imageUrl)
                .into(imgProduct)

            // SOLUSI: Pasang click listener langsung pada root (CardView)
            root.setOnClickListener {
                onItemClick(item)
            }

            // OPSIONAL: Jika diklik pada gambarnya langsung masih membandel tidak muncul,
            // pasang juga click listener langsung di imgProduct-nya seperti ini:
            imgProduct.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun getItemCount(): Int = productList.
    size
}