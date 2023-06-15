package gisa.lesson2;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class GisaQuiz {
    private ArrayList<StudentDTO> dataList;

    public GisaQuiz(ArrayList<StudentDTO> dataList) {
        this.dataList = dataList;
    }

    public String solveQuiz1(){

        // 지역코드 B 인것만 임시 배열 생성
        ArrayList<StudentDTO> tmpList = new ArrayList<>();
        for (StudentDTO student: dataList){
            if (student.getLocCode().equals("B")){
                tmpList.add(student);
            }
        }

        // 국어+영어 점수로 내림차순 정렬
        tmpList.sort(new Comparator<StudentDTO>() {
            @Override
            public int compare(StudentDTO s1, StudentDTO s2) {
                int order = Integer.compare(s2.getKor() + s2.getEng(), s1.getKor() + s1.getEng());
                if (order == 0){
                    order = Integer.compare(s1.getStdNo(), s2.getStdNo());
                }
                if (order == 0){
                    order = s1.getEmail().compareTo(s2.getEmail());
                }
                return order;
            }
        });

//        for (StudentVO st: tmpList) {
//            System.out.print(st.getStdNo() + " ");
//            System.out.println(st.getKor() + st.getEng());
//        }

        // 정답 배열에 생성 후 5번째 학생을 추가
        ArrayList<StudentDTO> ansList = new ArrayList<>();
        int selectedNum = tmpList.get(4).getEng() + tmpList.get(4).getKor();

        // 동점자 확인
        for (StudentDTO student: tmpList){
            if (student.getKor() + student.getEng() == selectedNum){
                ansList.add(student);
            } else if (student.getKor() + student.getEng() < selectedNum){
                break;
            }
        }

        System.out.print("문제 1의 정답은 >> ");

        // 정답 문자열 생성
        String answer = "";
        for (StudentDTO student: ansList){
            answer += (student.getStdNo()+ " ");
        }

        System.out.println(answer);

        return answer;
    }
    public String solveQuiz2(){

        // 지역코드 B 인것만 임시 배열 생성
        ArrayList<StudentDTO> tmpList = new ArrayList<>();
        for (StudentDTO student: dataList){
            if (student.getLocCode().equals("B")){
                tmpList.add(student);
            }
        }

        tmpList.sort(new Comparator<StudentDTO>() {
            @Override
            public int compare(StudentDTO o1, StudentDTO o2) {
                return Integer.compare(o2.getKor()+o2.getEng(), o1.getKor()+o1.getEng());
            }
        });

        System.out.print("문제 2의 정답은 >> ");
        String answer = Integer.toString(tmpList.get(0).getKor()+tmpList.get(0).getEng());
        System.out.println(answer);
        return answer;
    }
    public String solveQuiz3(){
        HashMap<String, Integer> accCodes = new HashMap<>();
        accCodes.put("A", 5);
        accCodes.put("B", 15);
        accCodes.put("C", 20);

        // 영어 + 수학 120 이상인 임시 배열 생성
        ArrayList<StudentDTO> tmpList = new ArrayList<>();
        for (StudentDTO student: dataList){
            if (student.getEng() + student.getMath() > 120){
                tmpList.add(student);
            }
        }

        // 임시 배열의 총점 + 점수포인트 합 구하기
        int sum = 0;
        for (StudentDTO student: tmpList) {
            int total = student.getTotal();
            int point = accCodes.get(student.getAccCode());
            sum += total + point;
        }

        String answer = Integer.toString(sum);
        System.out.print("문제 3의 정답은 >> ");
        System.out.println(answer);

        return answer;
    }
    public String solveQuiz4(){
        HashMap<String, Integer> locCodes = new HashMap<>();
        locCodes.put("A", 5);
        locCodes.put("B", 10);
        locCodes.put("C", 15);

        // 성취도 A,B인 임시 배열 생성
        ArrayList<StudentDTO> tmpList = new ArrayList<>();
        for (StudentDTO student: dataList){
            if (student.getLocCode().equals("A") || student.getLocCode().equals("B")){
                tmpList.add(student);
            }
        }

        // 국어점수 + 지역포인트 50이상인 자료
        int cnt = 0;
        for (StudentDTO student: tmpList){
            if (student.getKor() + locCodes.get(student.getLocCode()) >= 50) {
                cnt ++;
            }
        }

        String answer = Integer.toString(cnt);
        System.out.print("문제 4의 정답은 >> ");
        System.out.println(answer);

        return answer;
    }
}
