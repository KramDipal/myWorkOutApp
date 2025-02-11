package com.example.myplanetapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

class myCustomAdapter(val context: Context, val activity: Activity, val planets:List<Planets>): BaseAdapter() {
    /**
     * Gets the number of items in the adapter.
     * This will be the number of items in the list.
     */
    override fun getCount(): Int {
        //return the number of items in the planets list
        return planets.size
    }

    /**
     * Gets the item at the specified position in the adapter.
     * The type of the item is Any, but it is really a Planets object.
     */
    override fun getItem(position: Int): Any {
        //return the item at the specified position in the planets list
        return planets[position]
    }

    /**
     * Gets the item id of the item at the specified position in the adapter.
     * This is used to identify the item in the list.
     * In this case, we are just using the position as the id.
     */
    override fun getItemId(position: Int): Long {
        //return the position as the id
        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //get the layout inflater
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        //declare the view variable
        var view: View

        //if the convertView is null, inflate a new view
        if(convertView == null){
            //inflate the view
            view = inflater.inflate(R.layout.item_list_layout, parent, false)
        }else{
            //if the convertView is not null, use it
            view = convertView
        }

        //get the item at the position
        val item = getItem(position) as Planets

        //get the planet name and moon count views
        val planetName = view.findViewById<TextView>(R.id.planet_name)
        val moonCount = view.findViewById<TextView>(R.id.moon_count)
        val imagePlanet = view.findViewById<ImageView>(R.id.imageView)

        //set the text of the views
        moonCount.text = item.moonCount
        planetName.text = item.title
        imagePlanet.setImageResource(item.imagePlanet)

        //set the click listener

        view.setOnClickListener {

                    val intent = Intent(context, ChestWorkOutPage::class.java)

                    //startActivity(intent) is a method of the Activity class,
                    // but you are calling it from within the getView method of the myCustomAdapter class,
                    // which is not an Activity.
                    intent.putExtra("position", position)
                    activity.startActivity(intent)


           Toast.makeText(context, "You clicked: ${planets[position].title} $position", Toast.LENGTH_SHORT).show()
        }
        return view
    }
}