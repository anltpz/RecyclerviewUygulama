package com.example.recyclerviewuygulama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerviewuygulama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), KopeklerAdapter.SecilenKopekListener {

    private lateinit var binding: ActivityMainBinding
    var kopekTur: String? = null;
    var secilenKopek: KopekModel? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var kopeklerList = arrayListOf(

            KopekModel(R.drawable.avustralyacoban, "Avustralya Cobanı"),
            KopekModel(R.drawable.danua, "Danua"),
            KopekModel(R.drawable.golden, "Golden"),
            KopekModel(R.drawable.husky, "Husky"),
            KopekModel(R.drawable.jackrussellterrier, "Jackrussellterrier"),
            KopekModel(R.drawable.leonberger, "Leonberger"),

            )


//Adapter baglama
        val kopeklerAdapter = KopeklerAdapter(kopeklerList, this);

        binding.kopeklerRecylerView.layoutManager = LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        ) /// normal düzende alt alta
        //binding.kopeklerRecylerView.layoutManager=GridLayoutManager(applicationContext,2,GridLayoutManager.VERTICAL,false)
        // binding.kopeklerRecylerView.layoutManager =
        //    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        binding.kopeklerRecylerView.adapter = kopeklerAdapter

        binding.kopeklerRecylerView.setHasFixedSize(true)


        //onİtemclik işlemi burda yapıalcak
        kopeklerAdapter.onItemClick = ::secilenKopekOnClick

        //RecykerView veri ekleme
        binding.addFab.setOnClickListener {
            kopeklerList.add(KopekModel(R.drawable.leonberger, "Yeni leonberger"))
            kopeklerList.add(KopekModel(R.drawable.husky, "Yeni Husky"))
            kopeklerAdapter.kopeklerListGuncelle(kopeklerList);
        }

        binding.deleteFab.setOnClickListener {
            val silinecekIndex = kopeklerList.indexOf(secilenKopek);

            kopeklerList.removeAt(silinecekIndex)
            kopeklerAdapter.kopeklerListGuncelle(kopeklerList);


        }
    }

    fun secilenKopekOnClick(gelenSecilenKopek: KopekModel) {

        Log.e("Secilen  kopek2", gelenSecilenKopek.kopekTur)

        secilenKopek = gelenSecilenKopek
    }

    override fun secilenKopen(gelenSecilenKopek: KopekModel) {
        //   kopekTur = kopek.kopekTur;

        secilenKopek = gelenSecilenKopek
    }


}