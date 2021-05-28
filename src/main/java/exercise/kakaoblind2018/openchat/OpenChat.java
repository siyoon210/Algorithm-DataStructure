package exercise.kakaoblind2018.openchat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChat {
    public static String[] solution(String[] record){
        List<String> resultList = new ArrayList<String>();

        //닉넴을 정한다.
        //change했거나, enter한 이력이 있다면 그것이 닉넴이다. 같은 id가 있다면 덮어씌운다.
        //"id" => "닉네임"
        Map<String, String> nickName = new HashMap<String, String>();
        for(int i=0; i<record.length; i++){
            String[] str = record[i].split(" ");
            if (str[0].equals("Enter")) {
                nickName.put(str[1], str[2]);
            } else if (str[0].equals("Change")) {
                nickName.put(str[1], str[2]);
            }
        }

        //알맞은 닉네임으로 result 입력
        for(int i=0; i<record.length; i++){
            String[] str = record[i].split(" ");
            if (str[0].equals("Enter")) {
                resultList.add(nickName.get(str[1])+"님이 들어왔습니다.");
            } else if (str[0].equals("Leave")) {
                resultList.add(nickName.get(str[1])+"님이 나갔습니다.");
            }
        }

        String[] result = new String[resultList.size()];
        for(int i=0; i<result.length; i++){
            result[i] = resultList.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        String[] record = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] result = solution(record);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
