package com.example.testmircod.data.firebase

import java.io.Serializable

data class PushData(val id: String, val title: String, val body: String, val payload: Map<String, String>):Serializable