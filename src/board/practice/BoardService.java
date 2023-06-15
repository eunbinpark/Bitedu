package board.practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardService {

    private Scanner scanner = new Scanner(System.in);

    // list
    public void list() {
        Connection conn = ConnectionManager.getConnection();

        //타이틀 및 컬럼명 출력
        System.out.println();
        System.out.println("[게시물 목록]");
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-6s%-15s%-30s%-40s\n", "no", "writer", "date", "title");
        System.out.println("-----------------------------------------------------------------------");

        //boads 테이블에서 게시물 정보를 가져와서 출력하기
        try {
            String sql = "" +
                    "SELECT * " +
                    "FROM posts " +
                    "ORDER BY bno DESC";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                BoardDAO board = new BoardDAO();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("title"));
                board.setBcontent(rs.getString("content"));
                board.setBwriter(rs.getString("writer"));
                board.setBdate(rs.getString("date"));
                System.out.printf("%-6s%-15s%-30s%-40s \n",
                        board.getBno(),
                        board.getBwriter(),
                        board.getBdate(),
                        board.getBtitle());
            }
            ConnectionManager.closeConnection(rs, pstmt, conn);
        } catch(SQLException e) {
            e.printStackTrace();
            exit();
        }

        UseBoard use = new UseBoard();
        //메인 메뉴 출력
        use.mainMenu();
    }

    // 메인 메뉴

    public void create() {
        Connection conn = ConnectionManager.getConnection();

        //입력 받기
        BoardDAO board = new BoardDAO();
        System.out.println("[새 게시물 입력]");
        System.out.print("제목: ");
        board.setBtitle(scanner.nextLine());
        System.out.print("내용: ");
        board.setBcontent(scanner.nextLine());
        System.out.print("글쓴이: ");
        board.setBwriter(scanner.nextLine());

        //보조메뉴 출력
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("보조메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴선택: ");
        String menuNo = scanner.nextLine();
        if(menuNo.equals("1")) {
            //boards 테이블에 게시물 정보 저장
            try {
                String sql = "" +
                        "INSERT INTO posts (title, content, writer, date) " +
                        "VALUES (?, ?, ?, now())";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, board.getBtitle());
                pstmt.setString(2, board.getBcontent());
                pstmt.setString(3, board.getBwriter());
                pstmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
                exit();
            }
        }

        //게시물 목록 출력
        list();
    }

    public void read() {
        Connection conn = ConnectionManager.getConnection();

        //입력 받기
        System.out.println("[게시물 읽기]");
        System.out.print("bno: ");
        int bno = Integer.parseInt(scanner.nextLine());

        //boards 테이블에서 해당 게시물을 가져와 출력
        try {
            String sql = "" +
                    "SELECT bno, title, content, writer, date " +
                    "FROM posts " +
                    "WHERE bno=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bno);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                BoardDAO board = new BoardDAO();

                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("title"));
                board.setBcontent(rs.getString("content"));
                board.setBwriter(rs.getString("writer"));
                board.setBdate(rs.getString("date"));
                System.out.println("#############");
                System.out.println("번호: " + board.getBno());
                System.out.println("제목: " + board.getBtitle());
                System.out.println("내용: " + board.getBcontent());
                System.out.println("쓴이: " + board.getBwriter());
                System.out.println("날짜: " + board.getBdate());
                //보조메뉴 출력
                System.out.println("-------------------------------------------------------------------");
                System.out.println("보조메뉴: 1.Update | 2.Delete | 3.List");
                System.out.print("메뉴선택: ");
                String menuNo = scanner.nextLine();
                System.out.println();

                if(menuNo.equals("1")) {
                    update(board);
                } else if(menuNo.equals("2")) {
                    delete(board);
                }
            }
            ConnectionManager.closeConnection(rs, pstmt, conn);
        } catch (Exception e) {
            e.printStackTrace();
            exit();
        }

        list();

        //게시물 목록 출력
    }

    public void update(BoardDAO board) {
        Connection conn = ConnectionManager.getConnection();

        //수정 내용 입력 받기
        System.out.println("[수정 내용 입력]");
        System.out.print("제목: ");
        board.setBtitle(scanner.nextLine());
        System.out.print("내용: ");
        board.setBcontent(scanner.nextLine());
        System.out.print("글쓴이: ");
        board.setBwriter(scanner.nextLine());

        //보조메뉴 출력
        System.out.println("-------------------------------------------------------------------");
        System.out.println("보조메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴선택: ");
        String menuNo = scanner.nextLine();
        if(menuNo.equals("1")) {
            //boards 테이블에서 게시물 정보 수정
            try {
                String sql = "" +
                        "UPDATE posts SET title=?, content=?, writer=? " +
                        "WHERE bno=?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, board.getBtitle());
                pstmt.setString(2, board.getBcontent());
                pstmt.setString(3, board.getBwriter());
                pstmt.setInt(4, board.getBno());
                pstmt.executeUpdate();
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
                exit();
            }
        }

        //게시물 목록 출력
        list();
    }

    public void delete(BoardDAO board) {
        Connection conn = ConnectionManager.getConnection();

        //boards 테이블에 게시물 정보 삭제
        try {
            String sql = "DELETE FROM posts WHERE bno=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, board.getBno());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            exit();
        }

        //게시물 목록 출력
        list();
    }

    public void clear() {
        Connection conn = ConnectionManager.getConnection();

        System.out.println("[게시물 전체 삭제]");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("보조메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴선택: ");
        String menuNo = scanner.nextLine();
        if(menuNo.equals("1")) {
            //boards 테이블에 게시물 정보 전체 삭제
            try {
                String sql = "TRUNCATE TABLE posts";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
                exit();
            }
        }

        //게시물 목록 출력
        list();
    }

    public void exit() {
        Connection conn = ConnectionManager.getConnection();

        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        System.out.println("** 게시판 종료 **");
        System.exit(0);
    }


}
