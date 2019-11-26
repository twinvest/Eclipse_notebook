
public class Main {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String skill = "CBD";
		String skill_trees[] = {"BACDE", "CBADF", "AECB", "BDA"};
		int a = solution(skill, skill_trees);
		System.out.println(a);
	}
	
	static public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int treeLength = skill_trees.length;

        for(int i=0; i<treeLength; i++){
            boolean flag = true;
            String[] skills = skill_trees[i].split("");
            int cnt=0;

            int skillsLen = skills.length;
            for(int j=0; j<skills.length; j++){
                if(cnt < skill.indexOf(skills[j])){
                    flag = false;
                    break;
                }else if(cnt == skill.indexOf(skills[j])){
                    cnt++;
                }
            }

            if(flag){
                answer++;
            }
        }
        return answer;
    }
}
