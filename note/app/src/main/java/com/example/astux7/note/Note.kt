package com.example.astux7.note

/**
 * Created by abe29 on 21/08/2017.
 */
class Note {
    var noteId:Int?=null
    var noteTitle:String?=null
    var noteDes:String?=null

    constructor(noteId:Int,noteTitle:String,noteDes:String){
        this.noteId=noteId
        this.noteTitle=noteTitle
        this.noteDes=noteDes
    }
}