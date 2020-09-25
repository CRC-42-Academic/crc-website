package com.github.wiwiho.crcwebsite

import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun DIV.generateLogo() {
    div{
        img {
            src = "img/CRC.svg"
            width = "70%"
        }
    }
    div {
        classes = setOf("mt-5")
        img {
            src = "img/text.svg"
            width = "90%"
        }
    }
}

fun DIV.generateLinks() {

    div {
        classes = setOf("row", "mt-5")
        for (i in Page.values()) {
            div {
                classes = setOf("col-3", "mx-auto", "d-none", "d-md-inline")
                style = "font-size: 1.5rem"
                a {
                    href = i.url
                    classes = setOf("hover-" + i.color, "color-trans")
                    +i.chinese
                }
            }
            div {
                classes = setOf("col-3", "mx-auto", "d-inline", "d-md-none")
                style = "font-size: 1.2rem"
                a {
                    href = i.url
                    classes = setOf("hover-" + i.color, "color-trans")
                    +i.chinese.substring(0, 2)
                    br()
                    +i.chinese.substring(2)
                }
            }
        }
    }

    div {
        classes = setOf("row", "mt-5")
        style = "font-size: 1rem"

        div {
            classes = setOf("col-12", "col-sm-6", "mx-auto", "mt-2")
            a{
                href = "https://www.facebook.com/hsnu.computer.research.club"
                img {
                    src = "img/fb.svg"
                    width = "30"
                }
                +" 師大附中電算社"
            }
        }

        div {
            classes = setOf("col-12", "col-sm-6", "mx-auto", "mt-2")
            a{
                href = "https://www.instagram.com/hsnu_crc/"
                img {
                    src = "img/ig.svg"
                    width = "30"
                }
                +" hsnu_crc"
            }
        }

        div {
            classes = setOf("col-12", "col-sm-6", "mx-auto", "mt-2")
            a{
                href = "https://oj.crc.hs.ntnu.edu.tw/"
                img {
                    src = "img/crcoj.svg"
                    width = "30"
                }
                +" CRC OJ"
            }
        }

        div {
            classes = setOf("col-12", "col-sm-6", "mx-auto", "mt-2")
            a{
                href = "https://forms.gle/oARanR9dbhxe84qB6"
                img {
                    src = "img/document.svg"
                    width = "30"
                }
                +" 地社報名"
            }
        }
    }
}

fun generateHomePage(): String {
    return "<!DOCTYPE html>\n" + createHTML(prettyPrint = true).html {
        generateHead("師大附中電算社")

        body {
            classes = setOf("bg-dark", "text-white")

            div {
                classes = setOf("container", "h-100", "w-75")

                div {
                    classes = setOf("text-center", "h-100", "row")

                    div {
                        classes = setOf("my-auto", "mx-auto")
                        generateLogo()
                        generateLinks()
                    }
                }
            }

            script {
                src = "js/jquery-3.4.1.min.js"
            }
            script {
                src = "js/popper.min.js"
            }
            script {
                src = "js/bootstrap.min.js"
            }

            generateFooter()
        }
    }
}