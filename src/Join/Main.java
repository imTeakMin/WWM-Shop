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
      System.out.println("1. 로그인 2. 회원가입 3. EXIT");
      num=scan.nextInt();
      switch(num) {
        case 1:
          break;
        case 2:
          System.out.println("전화번호를 입력해주세요");
          scan.nextLine();
          call=scan.nextLine();
          if(memberInformation.map.containsKey(call))
          {
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

class memberInformation {

  static HashMap<String,JoinMembership> map=new HashMap<>();

  static boolean setInformation() throws IOException{
    File information=new File("src\\Join\\information.txt");
    if(!information.exists())
      return false;
    FileReader fr=new FileReader(information);
    BufferedReader br=new BufferedReader(fr);
    String line="";
    while((line=br.readLine())!=null) {
      String[] split=line.split(" ");
      JoinMembership newMem=new JoinMembership(split[1],split[2]);
      map.put(split[0],newMem);
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
    System.out.printf("비밀번호를 입력해주세요");
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
