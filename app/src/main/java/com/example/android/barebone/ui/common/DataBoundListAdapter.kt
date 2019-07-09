package com.example.android.barebone.ui.common

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * A generic RecyclerView adapter that uses Data Binding & DiffUtil.
 *
 * Here is an example of adapter with diff utils and click listener implemented.
 * ```kotlin
 * class ExampleListAdapter(
 *     private val itemClickCallback: ((ModelObject) -> Unit)?
 * ) : DataBoundListAdapter<ModelObject, ListItemBinding>(
 *     diffCallback = object : DiffUtil.ItemCallback<ModelObject>() {
 *         override fun areItemsTheSame(oldItem: ModelObject, newItem: ModelObject): Boolean {
 *             return oldItem.id == newItem.id
 *         }
 *
 *         override fun areContentsTheSame(oldItem: ModelObject, newItem: ModelObject): Boolean {
 *             return oldItem == newItem
 *         }
 *     }
 * ) {
 *
 *     override fun createBinding(parent: ViewGroup): ListItemBinding {
 *         val binding = DataBindingUtil.inflate<ListItemBinding>(
 *             LayoutInflater.from(parent.context), R.layout.list_item,
 *             parent, false)
 *
 *         binding.root.setOnClickListener {
 *             binding.data?.let {
 *                 itemClickCallback?.invoke(it)
 *             }
 *         }
 *         return binding
 *     }
 *
 *     override fun bind(binding: ListItemBinding, item: ModelObject) {
 *         binding.idea = item
 *     }
 * }
 * ```
 *
 * And here is how the adapter is instantiated in Fragment/Activity
 * ```
 * val ideaListAdapter = ExampleListAdapter { modelObject ->
 *     doActionOnModelObjectSelected(modelObject)
 * }
 * ```
 *
 * @param <T> Type of the items in the list
 * @param <V> The type of the ViewDataBinding
 */
abstract class DataBoundListAdapter<T, V : ViewDataBinding>(
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, DataBoundViewHolder<V>>(
    AsyncDifferConfig.Builder<T>(diffCallback).build()
) {
    /**
     * Provides [ViewDataBinding] for the list item after it's inflated with DataBinding.
     */
    protected abstract fun createBinding(parent: ViewGroup): V

    /**
     * API where view should bound with the data model item.
     */
    protected abstract fun bind(binding: V, item: T)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder<V> {
        val binding = createBinding(parent)
        return DataBoundViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<V>, position: Int) {
        bind(holder.binding, getItem(position))
        holder.binding.executePendingBindings()
    }
}
