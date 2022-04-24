package github;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
    }



    /*
  1. Есть ли разница между $("h1 div"); и $("h1").$("div");
  - может ли привести к тому что, поиск найдёт разные элементы?
  Если может - приведите пример, когда.

  Ответ:
  Да, разница есть.
  - Вариант $("h1 div") найдет первый элемент "h1 div" на любой вложенности;
  - Вариант $("h1").$("div") найдет первый попавшийся элемент "h1" и внутри него будет искать "div"
  Если в первом "h1" не будет "div" - произойдет ошибка;

  Пример 1
  {
  <body>
  <h1><a>Hello</a></h1>
  <h1><div>Hello</div></h1>
  </body>

  - - $("h1 div") найдет элемент
  }

  Пример 2

    {
  <body>
  <h1><a>Hello</a></h1>
  <h1><div>Hello</div></h1>
  </body>

  - - $("h1").$("div") не найдет элемент
  }


    * */
    @Test
    void solntsevShouldBeFirstContributor(){
        open("https://github.com/selenide/selenide");
        $("span[data-content=Wiki]").click();
        $("li.wiki-more-pages-link").$("button").click();
        $$("div[class=' js-wiki-sidebar-toggle-display'] ul li").shouldHave(itemWithText("SoftAssertions"));
        $("ul[data-filterable-for=wiki-pages-filter]").$(byText("SoftAssertions")).click();//рабочий клик 2
        $("h4", 2).shouldHave(text("3. Using JUnit5 extend test class:"));
    }

}
