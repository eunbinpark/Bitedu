package gisa.lesson4;


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

        int stdNo = dao.selectQuiz(sql);
        answer = String.valueOf(stdNo);

        return answer;
    }

    public String solveQuiz2() throws SQLException, ClassNotFoundException {
        String answer = null;

        // 로직 처리(SQL)
        StringBuffer sb = new StringBuffer("select (kor+eng) from student.studentinfo ");
        sb.append("where reg='b' order by (kor+eng) desc limit 0,1");
        String sql = sb.toString();

        int score = dao.selectQuiz(sql);
        answer = String.valueOf(score);

        return answer;
    }

    public String solveQuiz3() throws SQLException, ClassNotFoundException {
        String answer = null;

        StringBuffer sb = new StringBuffer("select sum(total + case acc when 'A' then 5 ");
        sb.append("when 'B' then 15 ");
        sb.append("when 'C' then 20 ");
        sb.append("end) as sum from student.studentinfo where eng + math >= 120");
        String sql = sb.toString();

        int score = dao.selectQuiz(sql);
        answer = String.valueOf(score);

        return answer;
    }

    public String solveQuiz4() throws SQLException, ClassNotFoundException {
        String answer = null;

        StringBuffer sb = new StringBuffer("select count(*) from student.studentinfo ");
        sb.append("where acc in ('A','B') and kor + case reg ");
        sb.append("when 'A' then 5 when 'B' then 10 when 'C' then 15 end >= 50");
        String sql = sb.toString();

        int score = dao.selectQuiz(sql);
        answer = String.valueOf(score);

        return answer;
    }
}
