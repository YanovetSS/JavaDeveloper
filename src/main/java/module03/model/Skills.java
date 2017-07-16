package module03.model;

import javax.persistence.*;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
@Entity
@Table(name = "SKILLS")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "SKILL_DEVELOPERS")
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
