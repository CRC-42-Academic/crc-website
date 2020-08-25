package com.github.wiwiho.crcwebsite

import kotlinx.html.*
import kotlinx.html.stream.createHTML

enum class Page(val chinese: String, val color: String, val url: String) {
    INTRODUCTION("社團簡介", "red", "introduction.html"),
    ACTIVITY("課程活動", "yellow", "activity.html"),
    STAFF("幹部介紹", "green", "staff.html"),
    ACHIEVEMENT("成果發表", "blue", "achievement.html")
}

fun HTML.generateHead(pageName: String) {
    head {
        meta {
            charset = "UTF-8"
        }
        link(rel = "stylesheet", href = "style/bootstrap.css")
        link(rel = "stylesheet", href = "style/custom.css")
        link(rel = "icon", href = "img/favicon.ico")
        meta {
            name = "viewport"
            content = "width=device-width, initial-scale=1.0"
        }
        title {
            +pageName
        }
    }
}

fun BODY.generateNav(active: Page) {

    fun UL.generateNavItem(page: Page, active: Boolean) {
        li {
            classes = setOf("nav-item", "d-none", "d-md-inline", "mx-auto")
            style = "width: 50%"
            a {
                classes = setOf("nav-link", "color-trans", "hover-" + page.color)
                if (active) {
                    classes += "active-" + page.color
                }
                href = page.url
                +page.chinese
            }
        }
        li {
            classes = setOf("nav-item", "d-inline", "d-md-none", "mx-auto")
            style = "width: 50"
            a {
                classes = setOf("nav-link", "color-trans", "hover-" + page.color)
                style = "font-size: 1rem"
                if (active) {
                    classes += "active-" + page.color
                }
                href = page.url
                +page.chinese.substring(0, 2)
                br()
                +page.chinese.substring(2)
            }
        }
    }

    nav {
        classes = setOf("navbar", "navbar-expand", "navbar-dark", "bg-black")
        div {
            classes = setOf("container", "align-items-center")

            ul {
                classes = setOf("navbar-nav", "ml-auto", "text-center")
                style = "width: 40%"

                generateNavItem(Page.INTRODUCTION, Page.INTRODUCTION == active)
                generateNavItem(Page.ACTIVITY, Page.ACTIVITY == active)
            }

            a {
                classes = setOf("mx-auto")
                href = "index.html"
                img {
                    width = "80"
                    src = "img/CRC.svg"
                }
            }

            ul {
                classes = setOf("navbar-nav", "mr-auto", "text-center")
                style = "width: 40%"

                generateNavItem(Page.STAFF, Page.STAFF == active)
                generateNavItem(Page.ACHIEVEMENT, Page.ACHIEVEMENT == active)
            }
        }
    }

}

fun BODY.generateFooter() {

    footer {
        classes = setOf("container", "bg-dark", "text-white", "mt-5", "text-center", "page-footer")
        style = "font-size: 0.8rem"
        div {
            +"國立臺灣師範大學附屬高級中學電子計算機研究社"
        }
        div {
            +"Computer Research Club, HSNU"
        }
        unsafe {
            raw("<div>Icons made by <a href=\"https://www.flaticon.com/authors/freepik\" title=\"Freepik\">Freepik</a> from <a href=\"https://www.flaticon.com/\" title=\"Flaticon\">www.flaticon.com</a></div>")
            raw("<div>Icons made by <a href=\"https://www.flaticon.com/authors/prosymbols\" title=\"Prosymbols\">Prosymbols</a> from <a href=\"https://www.flaticon.com/\" title=\"Flaticon\">www.flaticon.com</a></div>")
            raw("<div>Icons made by <a href=\"https://www.flaticon.com/authors/pixel-perfect\" title=\"Pixel perfect\">Pixel perfect</a> from <a href=\"https://www.flaticon.com/\" title=\"Flaticon\">www.flaticon.com</a></div>")
        }

    }

}

fun HTML.generateBody(page: Page, content: DIV.() -> Unit) {
    body {
        classes = setOf("bg-dark")

        generateNav(page)

        div {
            classes = setOf("container", "mt-5", "bg-dark", "text-white")
            content()
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

fun generatePage(page: Page, content: DIV.() -> Unit): String {

    return "<!DOCTYPE html>\n" + createHTML(prettyPrint = true).html {
        generateHead(page.chinese + " | 師大附中電算社")
        generateBody(page, content)
    }

}