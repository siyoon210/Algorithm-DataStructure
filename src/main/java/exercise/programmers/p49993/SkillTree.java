package exercise.programmers.p49993;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> skillSet = new HashSet<>();
        for (final char c : skill.toCharArray()) {
            skillSet.add(c);
        }

        for (final String skill_tree : skill_trees) {
            int skillSequence = 0;
            if (checkSkillTrees(skill, skillSet, skill_tree, skillSequence)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean checkSkillTrees(final String skill, final Set<Character> skillSet, final String skill_tree, int skillSequence) {
        for (int i = 0; i < skill_tree.length(); i++) {
            char currentSkill = skill_tree.charAt(i);
            if (skillSet.contains(currentSkill)) {
                if (skill.charAt(skillSequence) != currentSkill) {
                    return false;
                }
                skillSequence++;
            }
        }

        return true;
    }
}

public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};

        Solution solution = new Solution();
        System.out.println("solution.solution(skill, skillTrees) = " + solution.solution(skill, skillTrees));
    }
}
