package hello.hellospring.controller;

public class MemberForm {
    private String name;

    public String getName() { //변수안에 저장된 값을 꺼내주는 역할.
        return name;
    }

    public void setName(String name) { //변수안에 값을 넣어주는 역할.
        this.name = name;
    }
}
