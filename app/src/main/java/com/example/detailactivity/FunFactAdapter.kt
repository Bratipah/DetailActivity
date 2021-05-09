package com.example.detailactivity

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FunFactAdapter(context: Context,Facts:List<FunFactModel>):ArrayAdapter<FunFactModel>(context,0,Facts) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val fact= getItem(position)

        if (view == null){
            view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item,parent,false)

            val logo = view?.findViewById<ImageView>(R.id.imageLogo)
            val name = view?.findViewById<TextView>(R.id.nameTextView)

            fact?.logo?.let{
                logo?.setImageResource(fact?.logo)
            }
            name?.text = fact?.name
        }
        view?.setOnClickListener {
            val intent = Intent(parent.context,ListDetailActivity::class.java)
            intent.putExtra(LOGO_EXTRAs,fact?.logo)
            intent.putExtra(NAME_EXTRAs,fact?.name)
            intent.putExtra(FACT_EXTRAs,fact?.fact)
            parent.context.startActivity(intent)
        }
        return view!!
    }
    companion object{
        val LOGO_EXTRAs="logo_extras"
        val NAME_EXTRAs ="name_extras"
        val FACT_EXTRAs ="fact_extras"
    }
}