package com.github.wiwiho.crcwebsite

import kotlinx.html.h1
import kotlinx.html.p

fun generateAchievement(): String {
    return generatePage(Page.ACHIEVEMENT) {
        h1 {
            +"成果發表"
        }
        p {
            +"敬請期待"
        }
    }
}