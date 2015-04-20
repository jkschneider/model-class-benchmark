package com.netflix.model.kotlin

import java.util.Objects
import kotlin.properties.Delegates

data class KotlinLazyModel(val myInt: Int, val myList: List<String>, val str1: String,
                           val str2: String, val str3: String, val str4: String,
                           val str5: String, val str6: String, val doub: Double) {
    val hash by Delegates.lazy { Objects.hash(myInt, myList, str1, str2, str3, str4, str5, str6) }

    override fun hashCode(): Int {
        return hash
    }
}