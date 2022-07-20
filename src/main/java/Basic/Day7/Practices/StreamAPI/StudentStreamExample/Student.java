package Basic.Day7.Practices.StreamAPI.StudentStreamExample;

public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.score;
    }

    @Override
    public int compareTo(Student another) {
        return another.getScore() - this.getScore();
    }
}
