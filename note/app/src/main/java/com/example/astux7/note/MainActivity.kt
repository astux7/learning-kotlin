package com.example.astux7.note

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ticket.view.*

class MainActivity : AppCompatActivity() {
    var ListNotes = ArrayList<Note>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ListNotes.add(Note(1,"First", "I love this long line"))
        ListNotes.add(Note(2,"Second", "I love this long line too"))
        ListNotes.add(Note(3,"Last", "I love this long line too 2"))

        var adapter = NotesAdapter(ListNotes)
        tvNote.adapter = adapter
    }

    inner class NotesAdapter:BaseAdapter {
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var myView = layoutInflater.inflate(R.layout.ticket, null)
            var myNote = ListNotesAdapter[p0]
            myView.tvTitle.text = myNote.noteTitle
            myView.tvDes.text = myNote.noteDes
            return myView
        }

        override fun getItem(p0: Int): Any {
            return ListNotesAdapter[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return ListNotesAdapter.size
        }

        var ListNotesAdapter = ArrayList<Note>()
        constructor(ListNotesAdapter:ArrayList<Note>):super() {
            this.ListNotesAdapter = ListNotesAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val sv=menu!!.findItem(R.id.app_bar_search).actionView as SearchView
        val sm = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        sv.setSearchableInfo(sm.getSearchableInfo(componentName))
        sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                Toast.makeText(applicationContext, p0, Toast.LENGTH_LONG).show()
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        } )
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when(item.itemId) {
                R.id.addNote->{
                    var intent = Intent(this, AddNotes::class.java)
                    startActivity(intent)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

