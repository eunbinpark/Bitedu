package gisa.lesson3;


import java.sql.SQLException;

public class GisaQuiz {
    private GisaDAO dao;
    public GisaQuiz(){
        dao = new GisaDAO();
    }

    public String solveQuiz1() throws SQLException, ClassNotFoundException {
        String answer = null;

        // 로직 처리(SQL)
        StringBuffer sb = new StringBuffer("select id from studentinfo ");
        sb.append("where reg = 'B' ");
        sb.append("order by (kor+eng) desc, id asc limit 4,1");
        String sql = sb.toString();

        int stdNo = dao.selectQuiz1(sql);
        answer = String.valueOf(stdNo);

        return answer;
    }

    public String solveQuiz2() throws SQLException, ClassNotFoundException {
        String answer = null;

        // 로직 처리(SQL)
        StringBuffer sb = new StringBuffer("select (kor+eng) from student.studentinfo ");
        sb.append("where reg='b' order by (kor+eng) desc limit 0,1");
        String sql = sb.toString();

        int score = dao.selectQuiz2(sql);
        answer = String.valueOf(score);

        return answer;
    }

    public String solveQuiz3() throws SQLException, ClassNotFoundException {
        String answer = null;

        StringBuffer sb = new StringBuffer("select case when acc = 'A' then total + 5 ");
        sb.append("when acc = 'B' then total + 15 ");
        sb.append("when acc = 'C' then total + 20 ");
        sb.append("end as sum_score from student.studentinfo where (eng+math) >= 120");
        String sql = sb.toString();

        int score = dao.selectQuiz3(sql);
        answer = String.valueOf(score);

        return answer;
    }
    public String solveQuiz4() throws SQLException, ClassNotFoundException {
        String answer = null;


        StringBuffer sb = new StringBuffer("select id, case when reg = 'A' then kor + 5 ");
        sb.append("when reg = 'B' then kor + 10 ");
        sb.append("when reg = 'C' then kor + 15 ");
        sb.append("end as sum_score from student.studentinfo where acc = 'A' or acc = 'B'");
        String sql = sb.toString();

        int score = dao.selectQuiz4(sql);
        answer = String.valueOf(score);

        return answer;
    }
}
