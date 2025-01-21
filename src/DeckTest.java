//public class DeckTest {
//    public static void main(String[] args) {
//        // 덱 생성
//        Deck d = new Deck();
//        // 제일 위의 카드 뽑기
//        Card c = d.pick(0);
//        System.out.println(c);
//
//        d.shuffle(); // 카드 섞기
//        c = d.pick(0); // 섞은 후 제일 위의 카드 뽑기
//        System.out.println(c);
//
//        c = d.pick();
//        System.out.println(c);
//    }
//}
//
//class Deck{
//    final int CARD_NUM = 52; // 덱의 카드 총 개수: 52장
//    Card[] cardArr = new Card[CARD_NUM]; // Card 객체 배열을 포함
//
//    // Deck의 카드 초기화
//    Deck (){
//        int i = 0;
//
//        for(int k = Card.KIND_MAX; k>0; k--){   // 카드의 최대 무늬 개수 ~ 0 || k = 0; k < Card.KIND_MAX; k++ 랑 같은 결과
//            for(int n=0; n<Card.NUM_MAX; n++){  // 0 ~ 카드 무늬별 카드장 수
//                cardArr[i++] = new Card(k, n+1);
//            }
//        }
//
//    }// Deck()
//
//    Card pick(int index){   // index에 있는 카드를 꺼내서 반환
//        return cardArr[index];
//    }
//
//    Card pick(){
//        int index = (int)(Math.random() * CARD_NUM); // 0~(52-1)
//        return pick(index);
//    }
//
//    void shuffle(){
//        for(int i=0; i< cardArr.length; i++){
//            int r = (int)(Math.random()*CARD_NUM);
//
//            Card temp = cardArr[i];
//            cardArr[i] = cardArr[r];
//            cardArr[r] = temp;
//        }
//    }
//
//}   // Deck
//
//class Card{
//    static final int KIND_MAX = 4; // 카드 무늬 수
//    static final int NUM_MAX = 13; // 무늬별 카드 수
//
//    static final int SPADE = 4;
//    static final int DIAMOND = 3;
//    static final int HEART = 2;
//    static final int CLOVER = 1;
//    int kind;
//    int number;
//
//    Card(){
//        this(SPADE, 1);
//    }
//
//
//    public Card(int kind, int number) {
//        this.kind = kind;
//        this.number = number;
//    }
//
//    @Override
//    public String toString(){
//        String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
//        String numbers = "123456789XJQKA"; // 숫자 10 은 X로 표현
//        return "kind: "+kinds[this.kind]+", number: "+numbers.charAt(this.number);
//    }
//}
//
