package com.github.wiwiho.crcwebsite

import kotlinx.html.*

fun DIV.generateCard(
    name: String,
    time: String,
    target: String,
    location: String,
    image: String,
    content: DIV.() -> Unit
) {

    div {
        classes = setOf("card", "bg-secondary", "text-white", "mt-5")

        div {
            classes = setOf("card-header")
            +name
        }

        div {
            classes = setOf("card-body", "row")

            div {
                classes = setOf("col-3", "col-md-2", "my-auto")
                img {
                    src = "img/$image"
                    width = "100%"
                }
            }

            div {
                classes = setOf("card-text", "col-9", "col-md-10")
                content()
            }
        }

        div {
            classes = setOf("card-footer")
            small {
                img {
                    src = "img/calendar.svg"
                    width = "20"
                    classes = setOf("ml-2")
                }
                +" $time "
                img {
                    src = "img/group.svg"
                    width = "20"
                    classes = setOf("ml-2")
                }
                +" $target "
                img {
                    src = "img/location.svg"
                    width = "20"
                    classes = setOf("ml-2")
                }
                +" $location "
            }
        }
    }

}

fun generateActivity(): String {
    return generatePage(Page.ACTIVITY) {
        h1 {
            +"課程活動"
        }

        p {
            classes = setOf("mt-5")
            img {
                src = "img/calendar.svg"
                width = "20"
                classes = setOf("ml-2")
            }
            +" 時間 "
            img {
                src = "img/group.svg"
                width = "20"
                classes = setOf("ml-2")
            }
            +" 對象 "
            img {
                src = "img/location.svg"
                width = "20"
                classes = setOf("ml-2")
            }
            +" 地點 "
        }

        generateCard("社團博覽會", "2020-08-25 15:00-17:00", "新生", "電腦教室", "computer.svg") {
            +"社團博覽會在每年新生訓練的最後一天下午舉行，每個社團都會利用這個時間讓新生認識自己。電算社在社團博覽會時，"
            +"會在電腦教室展示社員的作品，社員也會在那裡和新生聊天。"
        }
        generateCard("上學期大社課 — C++ 與程式語言導論", "每週五第七節課", "正社社員", "電腦教室", "cpp.svg") {
            +"大社課指的就是每週五下午的社團課。大社課主要的內容是 C++，包含判斷、迴圈等基礎語法，還有 STL 的使用，"
            +"在大社課除了可以學習 C++ 以外，也可以學到資訊的基本知識。大社課的目的是讓學員對程式語言有初步的認識，"
            +"讓學員在上完之後，可以靠自己的能力學會其他程式語言。"
        }
        generateCard("小社課 — 競技程式", "未定", "社員", "未定", "algo.svg") {
            +"競技程式指的是演算法競賽，包含資訊學科能力競賽、資訊奧林匹亞和 APCS，都是屬於競技程式的範疇。"
            +"在這門課中，學員可以學到各種演算法，和解題的思路。"
        }
        generateCard("小社課 — Python", "未定", "社員", "未定", "python.svg") {
            +"Python 是近年相當流行的程式語言，經常被應用在許多領域，例如網頁爬蟲、人工智慧等等。"
            +"這門課會讓學員學到 Python 的語法和各種模組的使用。"
        }
        generateCard("秋烤", "未定", "社員", "未定", "bbq.svg") {
            +"秋烤是認識其他社員的好時機，大家會一起到外面烤肉，增進彼此的感情。"
        }
        generateCard("秋遊", "未定", "社員", "中央研究院", "academia.svg") {
            +"每年十月都有中研院開放日，這天電算社的社員們會一起去參加這個一年一度的活動。"
        }
        generateCard("寒訓", "未定", "社員", "未定", "laptop.svg") {
            +"寒訓是三天兩夜的活動，這三天中除了有學術課程外，也有 RPG 之類的活動，更是好好認識其他人的好機會。"
        }
    }
}