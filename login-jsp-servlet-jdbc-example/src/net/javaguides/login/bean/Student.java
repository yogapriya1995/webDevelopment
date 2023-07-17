package net.javaguides.login.bean;

public class Student {
	private int studentId;
	private int mark;
    private String name;
    private String crs;
    // Parameterized Constructor to set Student
    // name, age, course enrolled in.
    public Student(int id,String n, int a, String c)
    {
    	this.studentId=id;
        this.name = n;
        this.mark = a;
        this.crs = c;
    }
    // Setter Methods to set table data to be
    // displayed
    public int getStudentId() {return studentId;}
    public String getName() { return name; }
    public int getMark() { return mark; }
    public String getCrs() { return crs; }
}
