package codingTest.kaka0.kakao20blind.p3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    static class Applicant {
        private final int id;
        private final int score;

        public Applicant(int id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Applicant)) return false;

            Applicant applicant = (Applicant) o;

            return id == applicant.id;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }

    private static final String CPP = "cpp";
    private static final String JAVA = "java";
    private static final String PYTHON = "python";
    private static final String BACKEND = "backend";
    private static final String FRONTEND = "frontend";
    private static final String JUNIOR = "junior";
    private static final String SENIOR = "senior";
    private static final String CHICKEN = "chicken";
    private static final String PIZZA = "pizza";
    private static final String EMPTY = "-";

    private final Set<Applicant> applicants = new HashSet<>();

    private final Set<Applicant> cpps = new HashSet<>();
    private final Set<Applicant> javas = new HashSet<>();
    private final Set<Applicant> pythons = new HashSet<>();
    private final Set<Applicant> backEnds = new HashSet<>();
    private final Set<Applicant> frontEnds = new HashSet<>();
    private final Set<Applicant> juniors = new HashSet<>();
    private final Set<Applicant> seniors = new HashSet<>();
    private final Set<Applicant> chickens = new HashSet<>();
    private final Set<Applicant> pizzas = new HashSet<>();

    public int[] solution(String[] infos, String[] queries) {
        initApplicant(infos);
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String[] s = queries[i].split(" and ");
            String lang = s[0];
            String jobGroup = s[1];
            String career = s[2];
            String[] foodAndScore = s[3].split(" ");
            String soulFood = foodAndScore[0];
            int score = Integer.parseInt(foodAndScore[1]);

            Set<Applicant> langSet = getLangSet(lang);
            Set<Applicant> jobGroupSet = getJobGroupSet(jobGroup);
            Set<Applicant> careerSet = getCareerSet(career);
            Set<Applicant> soulFoodSet = getSoulFoodSet(soulFood);
            Set<Applicant> allApplicants = getMinSizeSet(langSet, jobGroupSet, careerSet, soulFoodSet);
            int size = allApplicants.size();

            for (Applicant applicant : allApplicants) {
                if (!langSet.isEmpty() && !langSet.contains(applicant)) {
                    size--;
                    continue;
                }

                if (!jobGroupSet.isEmpty() && !jobGroupSet.contains(applicant)) {
                    size--;
                    continue;
                }

                if (!careerSet.isEmpty() && !careerSet.contains(applicant)) {
                    size--;
                    continue;
                }

                if (!soulFoodSet.isEmpty() && !soulFoodSet.contains(applicant)) {
                    size--;
                    continue;
                }

                if (applicant.score < score) {
                    size--;
                }
            }

            result[i] = size;
        }

        return result;
    }

    private Set<Applicant> getMinSizeSet(Set<Applicant> langSet, Set<Applicant> jobGroupSet, Set<Applicant> careerSet, Set<Applicant> soulFoodSet) {
        final int langSize = langSet.size();
        final int jobGroupSize = jobGroupSet.size();
        final int careerSize = careerSet.size();
        final int soulFoodSize = soulFoodSet.size();

        int minSize = Integer.MAX_VALUE;

        if (langSize != 0) {
            minSize = Math.min(minSize, langSize);
        }
        if (jobGroupSize != 0) {
            minSize = Math.min(minSize, jobGroupSize);
        }
        if (careerSize != 0) {
            minSize = Math.min(minSize, careerSize);
        }
        if (soulFoodSize != 0) {
            minSize = Math.min(minSize, soulFoodSize);
        }

        if (minSize == Integer.MAX_VALUE) {
            return applicants;
        }

        if (minSize == langSize) {
            return langSet;
        }
        if (minSize == jobGroupSize) {
            return jobGroupSet;
        }
        if (minSize == careerSize) {
            return careerSet;
        }
        return soulFoodSet;
    }

    private Set<Applicant> getLangSet(String lang) {
        switch (lang) {
            case CPP:
                return cpps;
            case JAVA:
                return javas;
            case PYTHON:
                return pythons;
            case EMPTY:
                return Collections.emptySet();
        }

        throw new IllegalArgumentException();
    }

    private Set<Applicant> getJobGroupSet(String jobGroup) {
        switch (jobGroup) {
            case BACKEND:
                return backEnds;
            case FRONTEND:
                return frontEnds;
            case EMPTY:
                return Collections.emptySet();
        }

        throw new IllegalArgumentException();
    }

    private Set<Applicant> getCareerSet(String career) {
        switch (career) {
            case JUNIOR:
                return juniors;
            case SENIOR:
                return seniors;
            case EMPTY:
                return Collections.emptySet();
        }

        throw new IllegalArgumentException();
    }

    private Set<Applicant> getSoulFoodSet(String food) {
        switch (food) {
            case CHICKEN:
                return chickens;
            case PIZZA:
                return pizzas;
            case EMPTY:
                return Collections.emptySet();
        }

        throw new IllegalArgumentException();
    }

    private void initApplicant(String[] infos) {
        for (int i = 0; i < infos.length; i++) {
            String[] s = infos[i].split(" ");
            String lang = s[0];
            String jobGroup = s[1];
            String career = s[2];
            String soulFood = s[3];
            int score = Integer.parseInt(s[4]);

            Applicant applicant = new Applicant(i, score);
            applicants.add(applicant);
            initLang(lang, applicant);
            initJobGroup(jobGroup, applicant);
            initCareer(career, applicant);
            initSoulFood(soulFood, applicant);
        }
    }

    private void initSoulFood(String soulFood, Applicant applicant) {
        if (soulFood.equals(CHICKEN)) {
            chickens.add(applicant);
            return;
        } else if (soulFood.equals(PIZZA)) {
            pizzas.add(applicant);
            return;
        }

        throw new IllegalArgumentException();
    }

    private void initCareer(String career, Applicant applicant) {
        if (career.equals(JUNIOR)) {
            juniors.add(applicant);
            return;
        } else if (career.equals(SENIOR)) {
            seniors.add(applicant);
            return;
        }

        throw new IllegalArgumentException();
    }

    private void initJobGroup(String jobGroup, Applicant applicant) {
        if (jobGroup.equals(BACKEND)) {
            backEnds.add(applicant);
            return;
        } else if (jobGroup.equals(FRONTEND)) {
            frontEnds.add(applicant);
            return;
        }

        throw new IllegalArgumentException();
    }

    private void initLang(String lang, Applicant applicant) {
        switch (lang) {
            case CPP:
                cpps.add(applicant);
                break;
            case JAVA:
                javas.add(applicant);
                break;
            case PYTHON:
                pythons.add(applicant);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}

public class P3 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"}))
                .isEqualTo(new int[]{1, 1, 1, 1, 2, 4});

        out.println("p3" + " success!");
    }
}
