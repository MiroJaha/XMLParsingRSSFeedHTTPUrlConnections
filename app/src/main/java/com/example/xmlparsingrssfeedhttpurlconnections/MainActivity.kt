package com.example.xmlparsingrssfeedhttpurlconnections

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.ImageView
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlparsingrssfeedhttpurlconnections.model.Rss
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var myRV: RecyclerView
    private lateinit var questionsList: ArrayList<Group>
    private lateinit var questionsList2: ArrayList<Group>
    private lateinit var adapter: RVAdapter
    private lateinit var refreshImage: ImageView
    private lateinit var searchView: SearchView

    private val baseURL= "https://news.xbox.com/en-us/"
    private val tag= "MainActivity"
    private var call: Call<Rss?>? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionsList= arrayListOf()
        questionsList2= arrayListOf()
        myRV= findViewById(R.id.myRv2)
        refreshImage= findViewById(R.id.refreshImage)
        searchView= findViewById(R.id.searchV)

        adapter= RVAdapter(questionsList2)
        myRV.adapter= adapter
        myRV.layoutManager= LinearLayoutManager(this@MainActivity)

        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        val feedAPI = retrofit.create(APIClient::class.java)
        call = feedAPI.rss

        adapter.setOnItemClickListener(object : RVAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                AlertDialog.Builder(this@MainActivity)
                    .setMessage(questionsList2[position].summary)
                    .setCancelable(false)
                    .setPositiveButton("OK"){dialog,_ -> dialog.cancel()}
                    .show()
            }
        })

        refreshImage.setOnClickListener{
            callingData()
            questionsList.clear()
            questionsList.addAll(questionsList2)
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                questionsList2.clear()
                for (i in questionsList){
                    if(i.title.contains(p0!!,true))
                        questionsList2.add(i)
                }
                adapter.notifyDataSetChanged()
                return false
            }

        })
    }

    private fun callingData(){
        call!!.clone().enqueue(object : Callback<Rss?> {
            override fun onResponse(call: Call<Rss?>, response: Response<Rss?>) {
                Log.d(tag, "onResponse: feed: " + response.body().toString())
                Log.d(tag, "onResponse: Server Response: $response")
                //val channels = response.body()!!.channel?.item
                val channels = response.body()!!.item
                for (channel in channels!!) {
                    Log.d(tag, "onResponse: " + channel.title)
                    questionsList2.add(Group(channel.title!!,
                        channel.author!!,
                        channel.description!!,
                        Html.fromHtml(Html.fromHtml(channel.contentEncoded!!).toString()).toString()))
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<Rss?>, t: Throwable) {
                Log.e(tag, "onFailure: Unable to retrieve RSS: " + t.message)
                Toast.makeText(this@MainActivity, "An Error Occurred", Toast.LENGTH_SHORT).show()
            }
        })
    }
}