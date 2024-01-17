package ch07;

public class ParserTest {
    public static void main(String[] args) {
        /**
         * 위, 아래에서 같은 구문이지만 서로 다른 클래스의 인스턴스를 사용하고 있다.
         * 이 인스턴스의 공통점은 Parseable 인터페이스를 구현했다는 점이며,
         * 이후에 Parseable 인터페이스를 구현한 클래스가 확장되더라도 똑같이 활용할 수 있다.
         */
        Parseable parser = ParserManager.getParser("XML");
        parser.parse("document.xml");  // document.xml- XML parsing completed

        parser = ParserManager.getParser("HTML");
        parser.parse("document2.html");  // document2.html-HTML parsing completed
    }
}

/**
 * 매개변수 입력값(타입)에 따라 다른 인스턴스를 생성하여 반환하는 메서드(getParser)를 가진 클래스
 */
class ParserManager {
    // 리턴타입이 Parseable 인터페이스
    public static Parseable getParser(String type) {
        if (type.equals("XML")) {
            return new XMLParser();
        } else {
            Parseable p = new HTMLParser();
            return p;
            // = return new HTMLParser();
        }
    }
}

interface Parseable {
    // 구문 분석작업을 수행
    public abstract void parse(String fileName);
    // void parse(String fileName);  -> 인터페이스의 추상메서드에서 public abstract는 생략가능하다.
}

class XMLParser implements Parseable {
    public void parse(String fileName) {
//        구문 분석작업을 수행하는 코드 구현
        System.out.println(fileName + "- XML parsing completed");
    }
}

class HTMLParser implements Parseable {
    public void parse(String fileName) {
        System.out.println(fileName + "-HTML parsing completed");
    }
}
