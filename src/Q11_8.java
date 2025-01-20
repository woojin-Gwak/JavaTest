import java.util.*;


class Student implements Comparable<Student>{
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    int total;
    int schoolRank;
    int classRank;

    Student (String name, int ban, int no, int kor, int eng, int math){
        this.name = name;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;

        total = kor+eng+math;
    }

    int getTotal(){
        return total;
    }

    float getAverage(){
        return Math.round(getTotal()/3f*100)/100.0f;
        //return (int)((getTotal()/3f)*10+0.5)/10f;
    }

    @Override
    public int compareTo(Student o) {
        //내림차순 정렬
        return o.total - this.total;
    }

    @Override
    public String toString(){
        return name
               +","+no
               +","+kor
               +","+eng
               +","+math
               +","+getTotal()
               +","+getAverage()
               +","+schoolRank
               +","+classRank;

    }

}

class ClassTotalComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.ban-o2.ban==0)
            return o1.total - o2.total;
        return o1.ban-o2.ban;
    }
}

public class Q11_8 {
    public static void calculateSchoolRank(List list){
        Collections.sort(list); // compareTo 오버라이딩 내림차순 정렬

        int preRank = -1;
        int prevTotal = -1;
        //int length = list.size();
        int num = 0;

        for(Object i : list) {
            Student s = (Student) i;
            num += 1;
            if (s.total == prevTotal) {
                s.schoolRank = preRank;
            } else {
                // 총점이 서로 다르면,
                // 등수(schoolRank)의 값을 알맞게 계산해서 저장한다.
                // 이전에 동점자였다면, 그 다음 등수는 동점자의 수를 고려해야한다.
                s.schoolRank = num;
            }

            prevTotal = s.total;
            preRank = s.schoolRank;

        }

    }

    //11_9
    public static void calculateClassRank(List<Student> list){
        // 반별 총점기준 내림차순 정렬
        list.sort(new ClassTotalComparator());

        int prevBan = -1;
        int prevRank = -1;
        int prevTotal = -1;
        int n = 0;

        for(Student s : list){
            n += 1;
            if(s.ban != prevBan){
                prevRank = -1;
                prevTotal = -1;
            }

            if(s.total == prevTotal){
                prevRank = s.classRank;
            }else{
                s.classRank = n;
            }
            prevBan = s.ban;
            prevRank = s.classRank;
            prevTotal = s.total;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("이자바",2,1,70,90,70));
        list.add(new Student("안자바",2,2,60,100,80));
        list.add(new Student("홍길동",1,3,100,100,100));
        list.add(new Student("남궁성",1,1,90,70,80));
        list.add(new Student("김자바",1,2,80,80,90));

        calculateSchoolRank(list);
        calculateClassRank(list);
//        Student s = list.get(1);
//        System.out.println(s.getTotal());

//        Iterator it = list.iterator();
//
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
        for(Student s : list){
            System.out.println(s);
        }



        }
    }