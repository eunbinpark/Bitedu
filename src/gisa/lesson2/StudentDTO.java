package gisa.lesson2;

public class StudentDTO {
    private int stdNo;
    private String email;
    private int kor;

    private int math;
    private int eng;
    private int sci;
    private int hist;
    private String locCode;
    private int total;
    private String teacherCode;
    private String accCode;

    public StudentDTO(int stdNo, String email, int kor, int eng, int math, int sci, int hist, int total, String teacherCode, String accCode, String locCode) {
        this.stdNo = stdNo;
        this.email = email;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.sci = sci;
        this.hist = hist;
        this.total = total;
        this.locCode = locCode;
        this.accCode = accCode;
        this.teacherCode = teacherCode;
    }

    public int getSci() {
        return sci;
    }

    public int getHist() {
        return hist;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public int getStdNo(){
        return stdNo;
    }
    public int getKor(){
        return kor;
    }

    public int getTotal() {
        return total;
    }

    public int getMath() {
        return math;
    }

    public String getAccCode() {
        return accCode;
    }

    public int getEng(){
        return eng;
    }

    public String getLocCode() {
        return locCode;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "stdNo=" + stdNo +
                ", email='" + email + '\'' +
                ", kor=" + kor +
                ", math=" + math +
                ", eng=" + eng +
                ", sci=" + sci +
                ", hist=" + hist +
                ", locCode='" + locCode + '\'' +
                ", total=" + total +
                ", teacherCode='" + teacherCode + '\'' +
                ", accCode='" + accCode + '\''  +
                '}' + '\n';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
