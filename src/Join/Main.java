package Join;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) throws IOException{
    memberInformation.setInformation();
    Scanner scan=new Scanner(System.in);
    int num=0;
    String call="";
    while(num!=3) {
      System.out.print("1. 로그인 2. 회원가입 3. EXIT : ");
      num=scan.nextInt();
      scan.nextLine();
      switch(num) {
        case 1:
          String[] user = memberInformation.login();
          if (user == null) {
            continue;
          } else {
            // 쇼핑 목록 출력 매서드
            MenuAfterLogin.selectMenu(user);
          }
          break;
        case 2:
          System.out.println("전화번호를 입력해주세요");
          call=scan.nextLine();
          if(memberInformation.map.containsKey(call)) {
            System.out.println("이미 존재하는 회원입니다");
            break;
          }
          memberInformation.setId(call);
          break;
        case 3:
          break;
      }

    }

  }
}


class MenuAfterLogin{


  static void selectMenu(String[] user){
    int num = 0;
    int deeperNum = 0;
    int deepestNum = 0;
    Scanner scan = new Scanner(System.in);
    while (num != 7) {
      System.out.print("1.쇼핑 2.장바구니 3.주문/배송조회 4.취소/반품/교환 5.쿠폰 6.회원정보 7.로그아웃: ");
      num = scan.nextInt();
      scan.nextLine();
      switch(num){
        case 1:
          while (deeperNum != 5) {
            System.out.print("1.검색 2. .. 5.이전메뉴: ");
            deeperNum = scan.nextInt();
            scan.nextLine();
            switch (deeperNum) {
              case 1:
                System.out.print("1.검색어로 상품조회하기 2.검색+카테고리로 상품조회하기 3.카테고리별 상품조회하기 4.이전메뉴로 : ");
                deepestNum = scan.nextInt();
                scan.nextLine();
                // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                break;
              default:
                System.out.println("메뉴입력 오류.");
            }
          }
          break;
        case 2:
          System.out.println("------현재 " + user[0] + "님의 장바구니------");
          // 장바구니에 담은 것 출력하기.
          // user 가 장바구니에 처음 물건을 담으면, 해당 user 의 id로 파일 만들기.
          break;
        case 3:
          // 주문/배송 조회 하는 매서드
          break;
        case 4:
          // 취소/반품/교환 하는 매서드
          break;
        case 5:
          // 현재 user 가 가지고 있는 쿠폰 매서드
          break;
        case 6:
          System.out.println("----------회원정보----------");
          System.out.println("전화번호: " + user[0]);
          System.out.println("ID: " + user[1]);
          // 비밀번호는 앞에 4자리를 제외하고 *로 바꾸기.
          String line = user[2].substring(0,4);
          line += user[2].substring(4);
          System.out.println("PW: " + line);
          break;
        case 7:
          break;
        default:
          System.out.println("메뉴입력 오류.");
      }
    }
  }


}



class memberInformation {

  static HashMap<String, JoinMembership> map = new HashMap<>();

  static String[] login() throws IOException {
    String id, pw, line;
    Scanner scan = new Scanner(System.in);
    File information = new File("src\\Join\\information.txt");
    FileReader fr = new FileReader(information);
    BufferedReader br = new BufferedReader(fr);

    for(int i = 4; i >= 0; i --){
      System.out.print("ID: ");
      id = scan.nextLine();
      System.out.print("PW : ");
      pw = scan.nextLine();

      while ((line = br.readLine()) != null) {
        String[] split = line.split(" ");
        if (split[1].equals(id) && split[2].equals(pw)) {
          System.out.println(split[0] + "님, 환영합니다^^");
          return new String[] { split[0], split[1], split[2] };
        }
      }

      if (i == 0) {
        System.out.println("로그인 5회 연속 실패로, 프로그램을 종료합니다.");
        return null;
      }
      System.out.println("입력하신 정보는 없습니다." + i + "번 남았습니다.");

    }
    br.close();
    return null;
  }

  static boolean setInformation() throws IOException{
    File information=new File("src\\Join\\information.txt");
    if(!information.exists())
      return false;
    FileReader fr = new FileReader(information);
    BufferedReader br = new BufferedReader(fr);
    String line;
    while ((line = br.readLine()) != null) {
      String[] split = line.split(" ");
      if (split.length < 3) {
        System.err.println("빈칸 or 3조각 미만인 문장 포함됌.");
        continue;
      }
      JoinMembership newMem = new JoinMembership(split[1], split[2]);
      map.put(split[0], newMem);
    }
    br.close();
    return true;
  }

  static boolean setId(String number) throws IOException {
    Scanner sc=new Scanner(System.in);
    File information=new File("src\\Join\\information.txt");
    FileWriter fw=new FileWriter(information,true);
    BufferedWriter bw=new BufferedWriter(fw);
    String s1="";
    String s2 ="";
    while(true) {
      System.out.printf("id를 입력해주세요");
      s1 =sc.nextLine();
      JoinMembership newMember=new JoinMembership(s1,"");
      if(map.containsValue(newMember))
      {
        System.out.println("이미 존재하는 ID입니다.");
        continue;
      }
      else{
        break;
      }
    }
    System.out.print("비밀번호를 입력해주세요");
    s2=sc.nextLine();
    JoinMembership newMember=new JoinMembership(s1,s2);
    map.put(number,newMember);
    bw.write(number+" "+newMember.getId()+" "+newMember.getPw()+'\n');
    bw.close();
    return true;
  }

}

class JoinMembership {
  private String id;
  private String pw;
  JoinMembership(String id,String pw) {this.id=id; this.pw=pw;}

  public boolean equals(Object obj) {
    if(obj instanceof JoinMembership) {
      return id.equals(((JoinMembership)obj).id);
    }
    else return false;

  }
  public int hashCode() {
    return Objects.hash(id,pw);
  }
  String getId() {return this.id;}
  String getPw() {return this.pw;}
}

