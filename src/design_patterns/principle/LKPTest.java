package design_patterns.principle;

public class LKPTest {
    public static void main(String[] args) {
        Star star=new Star("Taylor");
        Fan fan=new Fan("Lili");
        Company company=new Company("20th fox");
        Agent agent=new Agent();
        agent.setCompany(company);
        agent.setStar(star);
        agent.setFan(fan);
        agent.meeting();
        agent.deal();
    }
}

class Agent {
    private Star star;
    private Fan fan;
    private Company company;

    public void setStar(Star star) {
        this.star = star;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void meeting() {
        System.out.println(this.star.getName() + " meets " + this.fan.getName());
    }

    public void deal() {
        System.out.println(this.company.getName() + " makes a deal with " + this.star.getName());
    }
}

class Star {
    private String name;

    public String getName() {
        return name;
    }

    public Star(String name) {
        this.name = name;
    }
}

class Company {
    private String name;

    public String getName() {
        return name;
    }

    public Company(String name) {
        this.name = name;
    }
}

class Fan {
    private String name;

    public Fan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}