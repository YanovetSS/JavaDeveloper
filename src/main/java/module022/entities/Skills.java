package module022.entities;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public class Skills {
    private int id;
    private String skillDeveloper;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillDeveloper() {
        return skillDeveloper;
    }

    public void setSkillDeveloper(String skillDeveloper) {
        this.skillDeveloper = skillDeveloper;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", skillDeveloper='" + skillDeveloper + '\'' +
                '}';
    }

    public Skills(){

    }

    public Skills(String skillDeveloper) {
        this.skillDeveloper = skillDeveloper;
    }
}
