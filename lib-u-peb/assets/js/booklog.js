const bookLogJson = {
    1 : {
        "bookNo" : 2222,
        "image" : "../assets/images/elasearch.webp",
        "bookTitle" : "엘라스틱서치 실무 가이드",
        "author" : "권택환, 김동우, 김홍래, 박진현, 최용호",
        "createAt" : "2023-06-09",
        "endedAt" : "2023-06-15"
    },
    2 : {
        "bookNo" : 1234,
        "image" : "../assets/images/이것이 자바다.jpg",
        "bookTitle" : "This is Java!",
        "author" : "신용권, 임경균",
        "createAt" : "2023-06-08",
        "endedAt" : "2023-06-14"
    },
    3 : {
        "bookNo" : 319,
        "image" : "../assets/images/modernjava.webp",
        "bookTitle" : "모던 자바 인 액션",
        "author" : "라울-게이브리얼 우르마, 마리오 푸스코, 앨런 마이크로프트",
        "createAt" : "2022-04-23",
        "endedAt" : "2022-05-01"
        
    },
    4 : {
        "bookNo" : 3333,
        "image" : "../assets/images/jpa.webp",
        "bookTitle" : "자바 ORM 표준 JPA 프로그래밍",
        "author" : "김영한",
        "createAt" : "2022-05-08",
        "endedAt" : "2022-05-14"
    },
    5 : {
        "bookNo" : 955,
        "image" : "../assets/images/toby.webp",
        "bookTitle" : "토비의 스프링 3.1 Vol. 1 스프링의 이해와 원리",
        "author" : "토비",
        "createAt" : "2021-08-30",
        "endedAt" : "2021-09-12"
    },
    6 : {
        "bookNo" : 721,
        "image" : "../assets/images/springboot.webp",
        "bookTitle" : "스프링 부트로 개발하는 MSA 컴포넌트",
        "author" : "김병부",
        "createAt" : "2021-06-01",
        "endedAt" : "2021-06-08"
    }
}


const bookLogTableBody = document.querySelector(".loans_list_table tbody");

document.addEventListener("DOMContentLoaded", getBookLog());


function getBookLog(){

    let bookLogContent = "";
    for(key in bookLogJson){

        bookLogContent += `
            <tr class="active_row">
                <td>${key}</td>
                <td>${bookLogJson[key].bookNo}</td>
                <td class="loans_book_info">
                    <img
                        src=${bookLogJson[key].image}
                        alt=""
                        class="loans_book_img"
                    />
                    <p>${bookLogJson[key].bookTitle}</p>
                </td>
                <td>${bookLogJson[key].author}</td>
                <td>${bookLogJson[key].createAt}</td>
                <td>${bookLogJson[key].endedAt}</td>
            </tr>
        `
    }

    bookLogTableBody.innerHTML = bookLogContent;
}