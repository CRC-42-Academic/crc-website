package com.github.wiwiho.crcwebsite

import kotlinx.html.*
import kotlinx.html.dom.*
import kotlinx.html.stream.createHTML
import java.io.FileWriter
import java.io.Writer

fun main(args: Array<String>) {

    FileWriter("index.html").apply { write(generateHomePage()) }.close()
    FileWriter("introduction.html").apply { write(generateIntroduction()) }.close()
    FileWriter("activity.html").apply { write(generateActivity()) }.close()
    FileWriter("staff.html").apply { write(generateStaff()) }.close()
    FileWriter("achievement.html").apply { write(generateAchievement()) }.close()

}