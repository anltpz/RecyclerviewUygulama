package com.example.recyclerviewuygulama

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewuygulama.databinding.KopekCardTasarimBinding

class KopeklerAdapter(
    private var kopeklerList: ArrayList<KopekModel>,
    private val secilenKopekListener: SecilenKopekListener
) :
    RecyclerView.Adapter<KopeklerAdapter.KopekCardTasarim>() {

        var onItemClick : (KopekModel) ->Unit={}

    //kopekcard tasarim ile entegrasyonunu saglıyacaz
    //activitydeki setcontentView gibi düşünülebilir
    // ilgili viewbandingin baglanısı ve dönüşünü saglıyoruz
    //ViewHolder görüntü tutucu demeektir


    class KopekCardTasarim(val kopekCardTasarimBinding: KopekCardTasarimBinding) :
        RecyclerView.ViewHolder(kopekCardTasarimBinding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KopekCardTasarim {
        val layoutInflater = LayoutInflater.from(parent.context)
        val kopekCardTasarimBinding = KopekCardTasarimBinding.inflate(layoutInflater, parent, false)

        return KopekCardTasarim(kopekCardTasarimBinding)

    }


    // tasarimda olusmasını istedigim her cardı
    //kopyala cogalt

    //bir resme bastıgım an burası calısır
    override fun onBindViewHolder(holder: KopekCardTasarim, position: Int) {
        val kopek = kopeklerList.get(position)

        holder.kopekCardTasarimBinding.kopekImageView.setImageResource(kopek.kopekGorsel)
        holder.kopekCardTasarimBinding.kopekTurTextView.text = kopek.kopekTur
//
//        holder.kopekCardTasarimBinding.kopekImageView.setOnClickListener {
//            secilenKopekListener.secilenKopen(kopek)
//        }

        // CardView e bastıgım anda tetiklenir bir bütün olarak basma işlmei resme yada texte basma degildir
        holder.kopekCardTasarimBinding.root.setOnClickListener {
           onItemClick(kopek)

        }



    }

    override fun getItemCount(): Int = kopeklerList.size

    //bastıgım degeleri bunun içine yazdırıcam
    interface SecilenKopekListener {
        fun secilenKopen(kopek: KopekModel)


    }


    fun  kopeklerListGuncelle(guncellist:ArrayList<KopekModel>)
    {
        kopeklerList=guncellist
        notifyDataSetChanged()  // veri degişikligi oldugunu algıla
    }




}