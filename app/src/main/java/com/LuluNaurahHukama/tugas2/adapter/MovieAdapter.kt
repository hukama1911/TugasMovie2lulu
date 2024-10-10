package com.LuluNaurahHukama.tugas2.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.LuluNaurahHukama.tugas2.Detailmovie
import com.LuluNaurahHukama.tugas2.MovieActivity
import com.LuluNaurahHukama.tugas2.R // Correct import for your app's resources
import com.LuluNaurahHukama.tugas2.model.ModelMovie

class MovieAdapter constructor(
    private val getActivity: MovieActivity,
    private val movieList: List<ModelMovie>
) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtMovie: TextView = itemView.findViewById(R.id.txtMovie)
        val imageMovie: ImageView = itemView.findViewById(R.id.imgMovie)
        val cardMovie: CardView = itemView.findViewById(R.id.cardMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_card, parent, false) // Added missing comma
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = movieList[position]
        holder.txtMovie.text = movie.title
        holder.imageMovie.setImageResource(movie.image)

        // Set click listener for each card
        holder.cardMovie.setOnClickListener {
            val modelMovie = movieList[position]
            val title = modelMovie.title
            val image = modelMovie.image


            holder.itemView.setOnClickListener(){
                val intent = Intent(getActivity, Detailmovie::class.java)

                intent.putExtra("image", movieList[position].image)
                intent.putExtra("judul", movieList[position].title)

                getActivity.startActivity(intent)
            }

            // You can add logic here, such as navigating to a new activity or showing a dialog
            // For example:
            // val intent = Intent(getActivity, DetailMovieActivity::class.java)
            // intent.putExtra("TITLE", title)
            // intent.putExtra("IMAGE", image)
            // getActivity.startActivity(intent)
        }
    }
}
