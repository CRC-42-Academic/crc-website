package com.github.wiwiho.crcwebsite

import kotlinx.html.h1
import kotlinx.html.p

fun generateStaff(): String {
    return generatePage(Page.STAFF) {
        h1 {
            +"幹部介紹"
        }
        p {
            +"敬請期待"
        }
    }
}