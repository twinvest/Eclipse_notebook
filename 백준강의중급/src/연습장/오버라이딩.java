package 연습장;

class Woman{ //부모클래스
    public String name;
    public int age;

    //info 메서드
    public void info(){
        System.out.println("여자의 이름은 "+name+", 나이는 "+age+"살입니다.");
    }

}

class Job extends Woman{ //Woman클래스(부모클래스)를 상속받음 :

    String job;

    @Override
	public void info() {//부모(Woman)클래스에 있는 info()메서드를 재정의
        super.info();
        System.out.println("여자의 직업은 "+job+"입니다.");
    }
}

public class 오버라이딩 {

    public static void main(String[] args) {

        //Job 객체 생성
        Job job = new Job();

        //변수 설정
        job.name = "유리";
        job.age = 30;
        job.job = "프로그래머";

        //호출
        job.info();

    }

}