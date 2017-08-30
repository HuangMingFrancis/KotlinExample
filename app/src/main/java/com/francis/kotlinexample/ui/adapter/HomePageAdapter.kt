package com.francis.kotlinexample.ui.adapter

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.francis.kotlinexample.R
import com.francis.kotlinexample.api.model.HomeBean
import com.francis.kotlinexample.util.ImageLoadUtils
import kotlinx.android.synthetic.main.item_home.view.*

/**
 * Created by Francis on 2017-8-25.
 */
class HomePageAdapter(val context: Context, private val itemList: MutableList<HomeBean.IssueListBean.ItemListBean>,
                      val onClick: (HomeBean.IssueListBean.ItemListBean) -> Unit) : RecyclerView.Adapter<HomePageAdapter.HomeViewHolder>() {
    override fun onBindViewHolder(holder: HomeViewHolder?, position: Int) {
        holder ?.bindData(itemList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeViewHolder {
        return LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_home, parent, false)
                .let { HomeViewHolder(context, it, onClick) }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class HomeViewHolder(val context: Context, itemView: View?, val onClick: (HomeBean.IssueListBean.ItemListBean) -> Unit)
        : RecyclerView.ViewHolder(itemView) {
        fun bindData(itemListBean: HomeBean.IssueListBean.ItemListBean){
            with(itemListBean){
                itemView.tv_title.typeface = Typeface.createFromAsset(context?.assets, "fonts/FZLanTingHeiS-DB1-GB-Regular.TTF")
                itemView.setOnClickListener { onClick(this) }

                var title = itemListBean?.data?.title
                var category = itemListBean?.data?.category
                var minute = itemListBean?.data?.duration?.div(60)
                var second = itemListBean?.data?.duration?.minus((minute?.times(60)) as Long )
                var realMinute : String
                var realSecond : String
                if(minute!!<10){
                    realMinute = "0"+minute
                }else{
                    realMinute = minute.toString()
                }
                if(second!!<10){
                    realSecond = "0"+second
                }else{
                    realSecond = second.toString()
                }
                var playUrl = itemListBean?.data?.playUrl
                var photo = itemListBean?.data?.cover?.feed
                var author = itemListBean?.data?.author
                ImageLoadUtils.display(context!!, itemView.iv_photo, photo as String)
                itemView.tv_title?.text = title
                itemView.tv_detail?.text = "发布于 $category / $realMinute:$realSecond"
                if(author!=null){
                    ImageLoadUtils.display(context!!, itemView.iv_user,author.icon as String)
                }else{
                    itemView.iv_user?.visibility = View.GONE
                }
            }
        }
    }
}